package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class askForNames extends AppCompatActivity {

    //public static game activeGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_names);
        Button bNo, bYes;


        bNo = findViewById(R.id.button_no);
        bYes = findViewById(R.id.button_yes);

        bNo.setOnClickListener(decision);
        bYes.setOnClickListener(decision);

    }

    View.OnClickListener decision = new View.OnClickListener(){


        @Override
        public void onClick(View view) {
            playerSelect.activeGame.createPlayers();

            if(view.getId() == R.id.button_no){
                //jump to next Screen and create standard names
                for(int i=0; i < playerSelect.activeGame.getPlayerCnt(); i++){
                    playerSelect.activeGame.players[i].setplayerName(i+1);

                }
                finish();
                startActivity(new Intent(askForNames.this, lifeSelect.class));

            } else{
                //jump to playerName Screens
                finish();
                startActivity(new Intent(askForNames.this, insertName.class));

            }

        }
    };
}
