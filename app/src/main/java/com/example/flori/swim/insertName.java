package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertName extends AppCompatActivity {

    EditText text = findViewById(R.id.playerName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_name);

        Button nextButton = findViewById(R.id.button_next);



        nextButton.setOnClickListener(next);

    }
    View.OnClickListener next = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            playerSelect.activeGame.players[playerSelect.activeGame.getPlayerTmp()].setPlayerName(text.getText().toString());
            playerSelect.activeGame.incTmp();
            if(playerSelect.activeGame.getPlayerTmp() == playerSelect.activeGame.getPlayerCnt()){
                finish();
                startActivity(new Intent(insertName.this, lifeSelect.class));

            }else{
                finish();
                startActivity(new Intent(insertName.this, insertName.class));

            }


        }
    };


}
