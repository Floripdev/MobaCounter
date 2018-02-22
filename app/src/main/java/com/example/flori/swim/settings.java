package com.example.flori.swim;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class settings extends AppCompatActivity {
    public static Button statButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        statButton = findViewById(R.id.button_statistik);

        statButton.setOnClickListener(statListener);
        setButtonStat();

    }


    View.OnClickListener statListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean status = playerSelect.activeGame.getStatus();
            if(status){
                //Button ändern + statistik entfernen
                mainScreen.cl.setVisibility(View.INVISIBLE);
                status=false;
                mainScreen.sv.getLayoutParams().height += 255; //ConstraintLayout.LayoutParams.MATCH_PARENT;
            } else{
                mainScreen.cl.setVisibility(View.VISIBLE);
                status = true;
                mainScreen.sv.getLayoutParams().height -= 255;

            }

            playerSelect.activeGame.setStatus(status);
            setButtonStat();

        }
    };

    public void setButtonStat(){
        if(playerSelect.activeGame.getStatus()){
            //Button ändern + statistik entfernen
            statButton.setBackgroundResource(R.drawable.button_stat_on);

        } else{
            statButton.setBackgroundResource(R.drawable.button_stat_off);

        }
    }

}
