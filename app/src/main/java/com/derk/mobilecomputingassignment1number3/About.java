package com.derk.mobilecomputingassignment1number3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import java.util.Locale;

public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        if(savedInstanceState != null){
            savedInstanceState.getInt("timeCounter");
            savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    private void runTimer(){
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = MainActivity.external_hours;
                int minutes = MainActivity.external_minutes;
                int secs = MainActivity.external_secs;
                String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                handler.postDelayed(this, 1000);
            }
        });
    }

}
