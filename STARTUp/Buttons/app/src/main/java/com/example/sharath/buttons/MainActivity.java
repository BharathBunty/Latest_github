package com.example.sharath.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void signUp(View view){

        Log.i("Sign Up" , "Sign up is tapped");
    }

    public void logIn(View view){

        Log.i("Log In" , "Log In is tapped");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
