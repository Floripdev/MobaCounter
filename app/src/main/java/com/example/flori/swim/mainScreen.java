package com.example.flori.swim;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class mainScreen extends AppCompatActivity {

    View[] v = new View[playerSelect.activeGame.getPlayerCnt()];
    static ConstraintLayout cl;
    static ScrollView sv;
    private Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(settingsListener);

        Button newButton = findViewById(R.id.button_new);
        newButton.setOnClickListener(newGameListener);

        cl = findViewById(R.id.statistik);
        sv = findViewById(R.id.scrollView3);

        timer = (Chronometer) findViewById(R.id.timer);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        refreshStats();
        insertBoxes();
        insertValues();
        initListener();




    }

    View.OnClickListener newGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mainScreen.this, newGamePopUp.class));

        }
    };

    View.OnClickListener flashListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            int boxNumber = Integer.parseInt(b.getText().toString());
            playerSelect.activeGame.flash(boxNumber);
            if(playerSelect.activeGame.players[boxNumber].getLife() != -1){
                playerSelect.activeGame.countFlashUp();
                playerSelect.activeGame.countRoundsUp();

            }
            insertValues();
            refreshStats();

        }
    };

    View.OnClickListener lifeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            int boxNumber = Integer.parseInt(b.getText().toString());
            playerSelect.activeGame.players[boxNumber].decLife();
            if(playerSelect.activeGame.players[boxNumber].getLife() != -1){
                playerSelect.activeGame.countRoundsUp();

            }
            insertValues();
            refreshStats();

        }
    };

    View.OnClickListener settingsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mainScreen.this, settings.class));

        }
    };


    public void initListener(){
        for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
            Button tmpLifeButton = v[i].findViewById(R.id.pos1_button_life);
            Button tmpFlashButton = v[i].findViewById(R.id.pos1_button_flash);
            tmpFlashButton.setText(""+i);
            tmpLifeButton.setText(""+i);
            tmpFlashButton.setOnClickListener(flashListener);
            tmpLifeButton.setOnClickListener(lifeListener);

        }

    }

    public void insertBoxes(){
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout mainLayout = findViewById(R.id.mainLayout);
        //PlayerBoxen holen
        for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
            v[i] = vi.inflate(R.layout.box_layout, null);

        }

        //PlayerBoxen in ScrollView einfügen
        for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
            mainLayout.addView(v[i]);

        }

    }

    public void insertValues(){
        for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
            TextView tmpName = v[i].findViewById(R.id.pos1_name);
            TextView tmpLife = v[i].findViewById(R.id.pos1_life);
            int tmpPlayerLife = playerSelect.activeGame.players[i].getLife();
            tmpName.setText(playerSelect.activeGame.players[i].getPlayerName());
            if(tmpPlayerLife == 0){
                tmpLife.setText("Schwimmt");

            }else if(tmpPlayerLife == -1){
                tmpLife.setText("Tod");

            }else{
                tmpLife.setText("" + tmpPlayerLife);

            }

        }

    }

    public void refreshStats(){
        TextView flashText = findViewById(R.id.flashView);
        TextView roundsText = findViewById(R.id.roundsView);
        flashText.setText("" + playerSelect.activeGame.flashes);
        roundsText.setText("" + playerSelect.activeGame.rounds);

    }


}
