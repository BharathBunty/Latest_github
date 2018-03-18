package com.example.sharath.mytimercount;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final  TextView mnumber = findViewById(R.id.mnumber);
        final TextView result = findViewById(R.id.done);

        new CountDownTimer(10000,1000){
            public void onTick(long msecUntilDone){
                mnumber.setText("Time:" + String.valueOf(msecUntilDone/1000));
            }
            public void onFinish(){
                result.setText("Done!!!");

               result.animate().rotation(360).setDuration(1000);

            }
        }.start();
    }
}
