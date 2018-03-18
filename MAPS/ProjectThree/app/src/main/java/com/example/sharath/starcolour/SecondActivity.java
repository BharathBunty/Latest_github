package com.example.sharath.starcolour;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Context;

public class SecondActivity extends AppCompatActivity {



    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("Name"), Toast.LENGTH_SHORT).show();

        String colour = intent.getStringExtra("Name");

        imageView.setImageResource(getImageId(this, colour));

    }
}
