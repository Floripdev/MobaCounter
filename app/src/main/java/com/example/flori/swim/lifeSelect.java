package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class lifeSelect extends AppCompatActivity {

    EditText lifeText = findViewById(R.id.lifeInput);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_select);

        Button accept = findViewById(R.id.button_accept);
        Button plus = findViewById(R.id.button_plus);
        Button minus = findViewById(R.id.button_minus);



            accept.setOnClickListener(lifeListener);
            plus.setOnClickListener(sideButtons);
            minus.setOnClickListener(sideButtons);

        }


    View.OnClickListener lifeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String x_string = lifeText.getText().toString();
            int x = Integer.parseInt(x_string);
            playerSelect.activeGame.initLifes(x);
            finish();
            startActivity(new Intent(lifeSelect.this, mainScreen.class));

        }
    };

    View.OnClickListener sideButtons = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String x_string = lifeText.getText().toString();
            int x = Integer.parseInt(x_string);
            if(view.getId() == R.id.button_minus){
                if(x != 0){
                    x--;
                    lifeText.setText("" + x);

                }

            }else{
                x++;
                lifeText.setText("" + x);

            }


        }

    };


    }

