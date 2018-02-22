package com.example.flori.swim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class winningPopUp extends Activity {

    TextView winningText;
    Button newGamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_pop_up);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.5));

        winningText = findViewById(R.id.winner_text);
        winningText.setText(""+playerSelect.activeGame.getWinner().getPlayerName() + "\nhat Gewonnen!");
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        newGamButton = findViewById(R.id.winner_button);
        newGamButton.setOnClickListener(newgameListener);

    }

    View.OnClickListener newgameListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
            startActivity(new Intent(winningPopUp.this, playerSelect.class));
        }
    };
}
