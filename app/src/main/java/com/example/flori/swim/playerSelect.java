package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class playerSelect extends AppCompatActivity {

    public static game activeGame = new game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_select);

        final Button buttons[] = new Button[8];
        buttons[0] = findViewById(R.id.playerCnt_2);
        buttons[1] = findViewById(R.id.playerCnt_3);
        buttons[2] = findViewById(R.id.playerCnt_4);
        buttons[3] = findViewById(R.id.playerCnt_5);
        buttons[4] = findViewById(R.id.playerCnt_6);
        buttons[5] = findViewById(R.id.playerCnt_7);
        buttons[6] = findViewById(R.id.playerCnt_8);
        buttons[7] = findViewById(R.id.playerCnt_9);

        //listener den Buttons zuweisen
        for(int i = 0; i < 8; i++){
            buttons[i].setOnClickListener(buttonCount);

        }


    }
    View.OnClickListener buttonCount = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.playerCnt_2:
                    activeGame.setPlayerCnt(2);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_3:
                    activeGame.setPlayerCnt(3);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_4:
                    activeGame.setPlayerCnt(4);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_5:
                    activeGame.setPlayerCnt(5);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_6:
                    activeGame.setPlayerCnt(6);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_7:
                    activeGame.setPlayerCnt(7);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_8:
                    activeGame.setPlayerCnt(8);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.playerCnt_9:
                    activeGame.setPlayerCnt(9);
                    //String h = Integer.toString(activeGame.getPlayerCnt());
                    //Toast.makeText(playerSelect.this, h, Toast.LENGTH_SHORT).show();
                    break;

            }
            finish();
            startActivity(new Intent(playerSelect.this, askForNames.class));

        }
    };
}
