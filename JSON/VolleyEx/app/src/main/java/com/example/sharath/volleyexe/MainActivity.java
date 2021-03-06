package com.example.sharath.volleyexe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String  myURL = "https://www.facebook.com";
        Button myButton =  findViewById(R.id.button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);

               final  StringRequest stringRequest = new StringRequest(Request.Method.POST, myURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("Page","WEB" +  response);
                            }
                        },
                        new Response.ErrorListener() {
                             @Override
                            public void onErrorResponse(VolleyError error) {

                                 Log.i("ERROR", "ERROR is" + error);
                             }
                        }
                );
              requestQueue.add(stringRequest);
            }

        });

    }
}
