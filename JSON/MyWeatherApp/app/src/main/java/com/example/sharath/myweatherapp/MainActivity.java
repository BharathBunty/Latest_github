package com.example.sharath.myweatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText city;
    TextView result;

    String baseURL = "http://api.openweathermap.org/data/2.5/weather?q=";
    String API = "&appid=5f6d15635eda9ba6f71a4546c6b9f9de";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        city = findViewById(R.id.getCity);
        result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


             String myURL = baseURL + city.getText().toString() + API;


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
                                        String myWeather = parObj.getString("main");
                                        result.setText(myWeather);
                                        Log.i("ID", "ID: " + parObj.getString("id"));
                                        Log.i("Main", "Main: " + parObj.getString("main"));
                                    }

                                    String tem = response.getString("main");
                                    result.setText(tem);
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
