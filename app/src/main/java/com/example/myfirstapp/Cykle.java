package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Cykle extends AppCompatActivity {

    @SuppressLint("SimpleDateFormat")
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());

    public static String stateOnCreateCycle;
    public static String stateOnResumeCycle;
    public static String stateOnPauseCycle;
    public static String stateOnStopCycle;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StringBuilder sb = new StringBuilder();
        setContentView(R.layout.active_cykle_layout);
        stateOnCreateCycle = sb.append(timeStamp).append(" onCreate, Klasa Cycle").toString();
        Display();

    }
    @Override
    public void onResume() {
        super.onResume();
        StringBuilder sb = new StringBuilder();
        Log.d("[" + timeStamp + "]", "[onResume KlasaCykle]");
        stateOnResumeCycle = sb.append(timeStamp).append(" onResume, Klasa Cycle").toString();
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("[" + timeStamp + "]", "[onPause KlasaCykle]");
        StringBuilder sb = new StringBuilder();
        stateOnPauseCycle = sb.append(timeStamp).append(" onPause, Klasa Cycle").toString();
    }
    @Override
    protected void onStop() {
        super.onStop();
        StringBuilder sb = new StringBuilder();
        Log.d("[" + timeStamp + "]", "[onStop KlasaCykle]");
        stateOnStopCycle = sb.append(timeStamp).append(" onStop, Klasa Cycle").toString();
    }
    public void Display() {
        TextView CycleOnCreate = (TextView) findViewById(R.id.cykleCreate);
        CycleOnCreate.setText(stateOnCreateCycle);
        TextView MainOnResume = (TextView) findViewById(R.id.mainResume);
        MainOnResume.setText(MainActivity.stateOnResumeMain);
        TextView MainOnStop = (TextView) findViewById(R.id.mainStop);
        MainOnStop.setText(MainActivity.stateOnStopMain);
        TextView MainOnPause = (TextView) findViewById(R.id.mainPause);
        MainOnPause.setText(MainActivity.stateOnPauseMain);
        TextView DisplayOnResume = (TextView) findViewById(R.id.displayResume);
        DisplayOnResume.setText(DisplayMessageActivity.stateOnResumeDisplay);
        TextView DisplayOnPause = (TextView) findViewById(R.id.displayPause);
        DisplayOnPause.setText(DisplayMessageActivity.stateOnPauseDisplay);


    }

}
