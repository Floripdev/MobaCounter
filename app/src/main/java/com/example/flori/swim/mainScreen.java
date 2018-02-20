package com.example.flori.swim;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class mainScreen extends AppCompatActivity {

    View[] v = new View[playerSelect.activeGame.getPlayerCnt()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Button settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(settingsListener);


        refreshStats();
        insertBoxes();
        insertValues();



    }

    View.OnClickListener settingsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mainScreen.this, settings.class));

        }
    };

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
            tmpName.setText(playerSelect.activeGame.players[i].getPlayerName());
            tmpLife.setText("" + playerSelect.activeGame.players[i].getLife());

        }

    }

    public void refreshStats(){
        TextView flashText = findViewById(R.id.flashView);
        TextView roundsText = findViewById(R.id.roundsView);
        flashText.setText("" + playerSelect.activeGame.flashes);
        roundsText.setText("" + playerSelect.activeGame.rounds);

    }

}
