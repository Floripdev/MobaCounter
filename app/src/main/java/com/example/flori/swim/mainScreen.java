package com.example.flori.swim;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class mainScreen extends AppCompatActivity {

    private View[] v = new View[playerSelect.activeGame.getPlayerCnt()];
    public static ConstraintLayout cl;
    public static ScrollView sv;
    private Chronometer timer;
    private player[] tmpPlayers = new player[10];
    //private static game undoPlayers;
    private boolean startOnce = false;
    private Button settingsButton, newButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //Button holen und Listener setzen für Settings_Button
        settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(settingsListener);

        //Button holen und Listener setzen für New_Game_Button
        newButton = findViewById(R.id.button_new);
        newButton.setOnClickListener(newGameListener);



        //Constraint Layout nur einmal holen! sonst fehler bei height berechnung & Player für undo holen damit nicht Null auf player Array geschreiben wird
        if(!startOnce){
            //undoPlayers = playerSelect.activeGame;
            cl = findViewById(R.id.statistik); //TODO: test ohne once
            startOnce = true;

        }

        //ScrollView für height berechnung holen
        sv = findViewById(R.id.scrollView3);

        //Timer(Chronometer) holen und starten, sobald Activity aufgerufen wird/Das Spiel gestartet wird
        timer = (Chronometer) findViewById(R.id.timer);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();

        //Inhalte in mainActivity laden udn Listener setzen
        refreshStats(); //holt die Stats aus der game-Class
        insertBoxes(); //Fügt die Spieler-Boxen ein
        insertValues(); //Fügt die Daten in die Spieler-Boxen ein
        initListener(); //Initalisiert die Listener




    }

    //Keine Aktion beim drücken der back-Taste
    @Override
    public void onBackPressed() {
       /* playerSelect.activeGame = undoPlayers;
        insertValues();
        refreshStats();
*/

    }


    //Startet ein neues Spiel
    View.OnClickListener newGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(mainScreen.this, newGamePopUp.class));

        }
    };

    //Listener für die Blitz-Buttons
    View.OnClickListener flashListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            int boxNumber = Integer.parseInt(b.getText().toString());
            playerSelect.activeGame.flash(boxNumber);
            //Wenn Leben -1 ist wird der Zähler für die Runden und Blitze nicht hoch gezählt
            if(playerSelect.activeGame.players[boxNumber].getLife() != -1){
                playerSelect.activeGame.countFlashUp();
                playerSelect.activeGame.countRoundsUp();

            }
            tmpPlayers = playerSelect.activeGame.players;
            //undoPlayers = playerSelect.activeGame;
            playerSelect.activeGame.players = bubblesort(tmpPlayers);
            //mainActivity aktualisieren
            insertValues();
            refreshStats();
            gameIsFinished();

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
            tmpPlayers = playerSelect.activeGame.players;
            //undoPlayers = playerSelect.activeGame;
            playerSelect.activeGame.players = bubblesort(tmpPlayers);
            insertValues();
            refreshStats();
            gameIsFinished();

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
            TextView tmpName = v[i].findViewById(R.id.name_text);
            TextView tmpLife = v[i].findViewById(R.id.life_text);
            int tmpPlayerLife = playerSelect.activeGame.players[i].getLife();
            tmpName.setText(playerSelect.activeGame.players[i].getPlayerName());
            if(tmpPlayerLife == 0){
                tmpLife.setText("Schwimmt");

            }else if(tmpPlayerLife == -1){
                tmpLife.setText("Ertrunken");

            }else{
                tmpLife.setText("" + tmpPlayerLife);

            }

        }


    }

    //Holt Runden und Blitze aus der Game-Logik und fügt sie in das Text-View ein
    public void refreshStats(){
        TextView flashText = findViewById(R.id.flashView);
        TextView roundsText = findViewById(R.id.roundsView);
        flashText.setText("" + playerSelect.activeGame.getFlashesCount());
        roundsText.setText("" + playerSelect.activeGame.getRoundCount());

    }

    public player[] bubblesort(player[] sortplayers) {
        player temp;
        for(int i=1; i<sortplayers.length; i++) {
            for(int j=0; j<sortplayers.length-i; j++) {
                if(sortplayers[j] != null && sortplayers[j+1] != null){
                    if(sortplayers[j].getLife()<sortplayers[j+1].getLife()) {
                        temp=sortplayers[j];
                        sortplayers[j]=sortplayers[j+1];
                        sortplayers[j+1]=temp;
                    }

                }


            }
        }
        return sortplayers;
    }

    //Funktion zum
    public void gameIsFinished(){
        int tmp = 0;
        boolean finished = false;
        for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
            if(playerSelect.activeGame.players[i].getLife() == -1){
                tmp++;
                if(tmp == (playerSelect.activeGame.getPlayerCnt()-1)){
                    finished = true;

                }

            }

        }

        if(finished){
            for(int i = 0; i < playerSelect.activeGame.getPlayerCnt(); i++){
                if(playerSelect.activeGame.players[i].getLife() != -1){
                    playerSelect.activeGame.setWinner(playerSelect.activeGame.players[i]);
                    startActivity(new Intent(mainScreen.this, winningPopUp.class));

                }

            }

        }
    }



}
