package com.derk.mobilecomputingassignment1number3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends Activity {

    public static int timeCounter = 0;
    private boolean running = true;
    public static int external_hours;
    public static int external_minutes;
    public static int external_secs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            timeCounter = savedInstanceState.getInt("timeCounter");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("timeCounter", timeCounter);
        savedInstanceState.putBoolean("running", running);
    }

    private void runTimer(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = timeCounter /3600;
                int minutes = (timeCounter %3600)/60;
                int secs = timeCounter %60;

                external_hours = hours;
                external_minutes = minutes;
                external_secs = secs;

                if(running){
                    timeCounter++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


    public void about_buttonClicked(View view){
        Intent intent_uptime = new Intent(this, About.class);
        startActivity(intent_uptime);
    }

    // Celsius Button Press
    public void cTf_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //running actual code
        try {
            userInput = findViewById(R.id.cNf_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Celsius to Fahrenheit conversion
            double cTf = (parsedDouble * 9/5) + 32;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", cTf);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " degrees Celsius is:\n" + shortenedDouble +
                    " degrees Fahrenheit.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //running error catcher
        catch(NumberFormatException ex) {
            //They didn't enter a number.  Pop up a toast or warn them in some other way
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    // Fahrenheit Button Press
    public void fTc_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //Running actual code
        try {
            userInput = findViewById(R.id.cNf_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Fahrenheit to Celsius conversion
            double fTc = (parsedDouble - 32) * 5/9;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", fTc);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " degrees Fahrenheit is:\n" + shortenedDouble +
                    " degrees Celsius.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Running error catcher
        catch(NumberFormatException ex) {
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    // Kilometres Button Press
    public void kTm_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //Running actual code
        try {
            userInput = findViewById(R.id.kNm_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Kilometres to Miles conversion
            double kTm = parsedDouble/1.609;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", kTm);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " Kilometres is:\n" + shortenedDouble + " Miles.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Running error catcher
        catch(NumberFormatException ex) {
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    // Miles Button Press
    public void mTk_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //Running actual code
        try {
            userInput = findViewById(R.id.kNm_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Kilometres to Miles conversion
            double mTk = parsedDouble*1.609;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", mTk);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " Miles is:\n" + shortenedDouble + " Kilometres.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Running error catcher
        catch(NumberFormatException ex) {
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    // Kilograms Button Press
    public void kTp_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //Running actual code
        try {
            userInput = findViewById(R.id.kNp_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Kilometres to Miles conversion
            double kTp = parsedDouble*2.205;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", kTp);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " Kilograms is:\n" + shortenedDouble + " Pounds.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Running error catcher
        catch(NumberFormatException ex) {
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    // Pounds Button Press
    public void pTk_buttonClicked(View view) {
        EditText userInput;
        double parsedDouble;

        //Running actual code
        try {
            userInput = findViewById(R.id.kNp_input);
            parsedDouble = Double.parseDouble(userInput.getText().toString());

            // Kilometres to Miles conversion
            double pTk = parsedDouble/2.205;
            @SuppressLint("DefaultLocale") String shortenedDouble = String.format("%.2f", pTk);

            //Printing conversion in Toast format
            Context context = getApplicationContext();
            CharSequence text = parsedDouble + " Pounds is:\n" + shortenedDouble + " Kilograms.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        //Running error catcher
        catch(NumberFormatException ex) {
            Context context = getApplicationContext();
            CharSequence text = "Please input a number.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
