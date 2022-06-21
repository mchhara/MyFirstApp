package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DisplayMessageActivity extends AppCompatActivity {

    @SuppressLint("SimpleDateFormat")
    String timeStampDM = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
    public static String stateOnCreateDisplay;
    public static String stateOnResumeDisplay;
    public static String stateOnPauseDisplay;
    public static String stateOnStopDisplay;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String Fmessage = intent.getStringExtra(MainActivity.FEXTRA_MESSAGE);
        String Lmessage = intent.getStringExtra(MainActivity.LEXTRA_MESSAGE);
        String Dmessage = intent.getStringExtra(MainActivity.DEXTRA_MESSAGE);
        String Mmessage = intent.getStringExtra(MainActivity.MEXTRA_MESSAGE);
        String Ymessage = intent.getStringExtra(MainActivity.YEXTRA_MESSAGE);


        TextView FtextView = findViewById(R.id.FtextView);
        TextView LtextView = findViewById(R.id.LtextView);
        TextView day = findViewById(R.id.DtextView);
        TextView month = findViewById(R.id.MtextView);
        TextView year = findViewById(R.id.YtextView);
        TextView gender = findViewById(R.id.GtextView);


        FtextView.setText(Fmessage);
        LtextView.setText(Lmessage);
        day.setText(Dmessage);
        month.setText(Mmessage);
        year.setText(Ymessage);

        String g=intent.getStringExtra("Gender");
        gender.setText(g);
    }
    public void goToThirdLayout(View view) {
        Intent intent = new Intent(this, Cykle.class);
        startActivity(intent);
    }


    public void backToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("[" + timeStampDM + "]", "[onCreate KlasaDisplay]");
        StringBuilder sb = new StringBuilder();
        stateOnResumeDisplay = sb.append(timeStampDM).append(" onResume, KlasaDisplay").toString();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("[" + timeStampDM + "]", "[onPause KlasaDisplay]");
        StringBuilder sb = new StringBuilder();
        stateOnPauseDisplay = sb.append(timeStampDM).append(" onPause, KlasaDisplay").toString();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("[" + timeStampDM + "]", "[onStop KlasaDisplay ]");
        StringBuilder sb = new StringBuilder();
        stateOnStopDisplay = sb.append(timeStampDM).append(" onStop, KlasaDisplay").toString();
    }

}