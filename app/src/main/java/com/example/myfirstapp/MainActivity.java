package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String FEXTRA_MESSAGE = "com.example.myfirstapp.FMESSAGE";
    public static final String LEXTRA_MESSAGE = "com.example.myfirstapp.LMESSAGE";
    public static final String DEXTRA_MESSAGE = "com.example.myfirstapp.DMESSAGE";
    public static final String MEXTRA_MESSAGE = "com.example.myfirstapp.MMESSAGE";
    public static final String YEXTRA_MESSAGE = "com.example.myfirstapp.YMESSAGE";

    String timeStampMA = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
    public static String stateOnCreateMain;
    public static String stateOnResumeMain;
    public static String stateOnPauseMain;
    public static String stateOnStopMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.months, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

    }


    public void sendMessage(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText firstName = (EditText) findViewById(R.id.editTextTextFirstName);
        EditText lastName = (EditText) findViewById(R.id.editTextTextLastName);
        Spinner day = (Spinner) findViewById(R.id.spinner1);
        Spinner month = (Spinner) findViewById(R.id.spinner2);
        Spinner year = (Spinner) findViewById(R.id.spinner3);
        CheckBox man = (CheckBox) findViewById(R.id.man);
        CheckBox woman = (CheckBox) findViewById(R.id.woman);

        StringBuffer g= new StringBuffer();

        if(man.isChecked())
        {
            g.append("Man");
        }

        if(woman.isChecked())
        {
            g.append("Woman");
        }

        if(man.isChecked() && woman.isChecked()){g.delete(0,8);}


        String Fmessage = firstName.getText().toString();
        String Lmessage = lastName.getText().toString();
        String Dmessage = day.getSelectedItem().toString();
        String Mmessage = month.getSelectedItem().toString();
        String Ymessage = year.getSelectedItem().toString();
        String Gender =g.toString();

        intent.putExtra("Gender",Gender);
        intent.putExtra(FEXTRA_MESSAGE, Fmessage);
        intent.putExtra(LEXTRA_MESSAGE, Lmessage);
        intent.putExtra(DEXTRA_MESSAGE, Dmessage);
        intent.putExtra(MEXTRA_MESSAGE, Mmessage);
        intent.putExtra(YEXTRA_MESSAGE, Ymessage);


        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("[" + timeStampMA + "]", "[onCreate KlasaGłówna]");
        StringBuilder sb = new StringBuilder();
        stateOnResumeMain = sb.append(timeStampMA).append(" onResume, Klasa Main").toString();
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("[" + timeStampMA + "]", "[onPause KlasaGłówna]");
        StringBuilder sb = new StringBuilder();
        stateOnPauseMain = sb.append(timeStampMA).append(" onPause, Klasa Main").toString();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("[" + timeStampMA + "]", "[onStop KlasaGłówna]");
        StringBuilder sb = new StringBuilder();
        stateOnStopMain = sb.append(timeStampMA).append(" onStop, Klasa Main").toString();
    }


}