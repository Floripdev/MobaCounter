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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game_pop_up);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.5));

        Button resumeButton = findViewById(R.id.button_resume);
        resumeButton.setOnClickListener(resumeListener);

        Button newgameButton = findViewById(R.id.button_new_game);
        newgameButton.setOnClickListener(newgameListener);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



    }
    @Override
    public void onBackPressed() {
        finish();

    }

    View.OnClickListener resumeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();

        }
    };

    View.OnClickListener newgameListener= new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            finish();
            playerSelect.activeGame.setZero();
            startActivity(new Intent(newGamePopUp.this, playerSelect.class));

        }
    };

}
