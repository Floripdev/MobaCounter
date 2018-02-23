package com.example.flori.swim;

import android.content.Intent;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class settings extends AppCompatActivity {
    public static Button statButton, anleitungButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        statButton = findViewById(R.id.button_statistik);
        anleitungButton = findViewById(R.id.button_anleitung);

        anleitungButton.setOnClickListener(anleitungListener);
        statButton.setOnClickListener(statListener);
        setButtonStat(); //Bei start der Activity Statistik Button on/off richtig anzeigen

    }

    View.OnClickListener anleitungListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(settings.this, anleitung.class));

        }
    };


    View.OnClickListener statListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean status = playerSelect.activeGame.getStatus();
            if(status){
                //statistik entfernen
                mainScreen.cl.setVisibility(View.INVISIBLE);
                status=false;
                mainScreen.sv.getLayoutParams().height += mainScreen.cl.getLayoutParams().height; // 200
            } else{
                //Statistik einfügen
                mainScreen.cl.setVisibility(View.VISIBLE);
                status = true;
                mainScreen.sv.getLayoutParams().height -= mainScreen.cl.getLayoutParams().height;

            }

            playerSelect.activeGame.setStatus(status);
            setButtonStat(); //Button aktualisieren

        }
    };

    public void setButtonStat(){
        if(playerSelect.activeGame.getStatus()){
            statButton.setBackgroundResource(R.drawable.button_stat_on);

        } else{
            statButton.setBackgroundResource(R.drawable.button_stat_off);

        }
    }

}
