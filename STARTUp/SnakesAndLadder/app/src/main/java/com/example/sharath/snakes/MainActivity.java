package com.example.sharath.snakes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] myDices = {R.drawable.one, R.drawable.two, R.drawable.three,
                    R.drawable.four,R.drawable.five,R.drawable.six};


    public void rollTapped(View view){
        Log.i("Button", "Button is Tapped");


        Random random = new Random();
        int randomNumber = random.nextInt(6);
        Log.i("Random", "Random Number is :" + ((randomNumber)+1));

        ImageView dice = (ImageView) findViewById(R.id.dice);
        dice.setImageResource(myDices[randomNumber]);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
