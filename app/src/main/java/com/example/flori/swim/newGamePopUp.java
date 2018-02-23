package com.example.flori.swim;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class newGamePopUp extends Activity {
    private DisplayMetrics dm;
    private int width, height;
    private Button resumeButton, newgameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_pop_up);

        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        width = dm.widthPixels;
        height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.5));

        resumeButton = findViewById(R.id.button_resume);
        resumeButton.setOnClickListener(resumeListener);

        newgameButton = findViewById(R.id.button_new_game);
        newgameButton.setOnClickListener(newgameListener);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



    }
    @Override
    public void onBackPressed() {
        finish();

    }

    //Activity beenden falls auf fortsetzen gedrückt wird
    View.OnClickListener resumeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();

        }
    };

    //Neues Spielk starten
    View.OnClickListener newgameListener= new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            finish();
            playerSelect.activeGame.setZero();
            startActivity(new Intent(newGamePopUp.this, playerSelect.class));

        }
    };

}
