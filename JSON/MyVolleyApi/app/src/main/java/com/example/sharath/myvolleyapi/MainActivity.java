package com.example.sharath.myvolleyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String myURL = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonapi);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Button", "Button is Tapped");

                final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, myURL, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                              Log.i("JSON", "JSON Object" + response);

                              try {

                                  String coor = response.getString("coord");
                                  Log.i("CO-ord", "COord" + coor);

                                  JSONObject co = new JSONObject(coor);
                                  String lon = co.getString("lon");
                                  String lat = co.getString("lat");

                                  Log.i("Lon", "Lon" + lon);
                                  Log.i("Lon", "Lon" + lat);

                                  String info = response.getString("weather");
                                  Log.i("INFO", "INFO" + info);

                                  JSONArray ar = new JSONArray(info);
                                  for (int i = 0; i<ar.length(); i++){
                                     JSONObject parObj = ar.getJSONObject(i);
                                     Log.i("ID", "ID: " + parObj.getString("id"));
                                     Log.i("Main", "Main: " + parObj.getString("main"));
                                  }

                                  String tem = response.getString("main");
                                  Log.i("mainO", "MainTemp: " + tem);

                                  JSONObject t = new JSONObject(tem);
                                  String temp = t.getString("temp");
                                  String humid = t.getString("humidity");

                                  Log.i("Temp", "TEMP: " + temp);
                                  Log.i("Humid", "Humidity: " + humid);

                              }
                              catch (JSONException e){
                                  e.printStackTrace();
                              }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                               Log.i("ERROR", "NO URL Found" + error);
                            }
                        }
                );

                MySingleton.getmInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);

            }
        });
    }
}
