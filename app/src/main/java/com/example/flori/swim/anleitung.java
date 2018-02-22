package com.example.flori.swim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class anleitung extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anleitung);
        text = findViewById(R.id.anleitung_text);
        text.setText(Html.fromHtml(getString(R.string.beschreibung)));

    }
}
