package com.example.flori.swim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertName extends AppCompatActivity {

    private EditText text;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_name);

        nextButton = findViewById(R.id.button_next);
        text = findViewById(R.id.playerName);


        nextButton.setOnClickListener(next);

    }

    @Override
    public void onBackPressed() {

    }

    //Holt sich den Namen aus dem Textfeld und speichert ihn in die game Logik
    View.OnClickListener next;

    {
        next = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerSelect.activeGame.players[playerSelect.activeGame.getPlayerTmp()].setPlayerName(text.getText().toString());
                playerSelect.activeGame.incTmp();
                if (playerSelect.activeGame.getPlayerTmp() == playerSelect.activeGame.getPlayerCnt()) {
                    finish();
                    startActivity(new Intent(insertName.this, lifeSelect.class));

                } else {
                    finish();
                    startActivity(new Intent(insertName.this, insertName.class));

                }


            }
        };
    }


}
