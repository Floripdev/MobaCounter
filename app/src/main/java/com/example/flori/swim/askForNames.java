package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class askForNames extends AppCompatActivity {

    private Button bNo, bYes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_names);


        //Buttons holen und Listener setzen
        bNo = findViewById(R.id.button_no);
        bYes = findViewById(R.id.button_yes);

        bNo.setOnClickListener(decision);
        bYes.setOnClickListener(decision);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(askForNames.this, playerSelect.class));
    }

    View.OnClickListener decision = new View.OnClickListener(){


        @Override
        public void onClick(View view) {
            playerSelect.activeGame.createPlayers();

            if(view.getId() == R.id.button_no){
                //Standardnamen setzen und zur Lebensauswahl-Activity springen
                for(int i=0; i < playerSelect.activeGame.getPlayerCnt(); i++){
                    playerSelect.activeGame.players[i].setplayerName(i+1);

                }
                finish();
                startActivity(new Intent(askForNames.this, lifeSelect.class));

            } else{
                //Springt in die Namenseingabe-Activity
                finish();
                startActivity(new Intent(askForNames.this, insertName.class));

            }

        }
    };
}
