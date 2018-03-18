package com.example.sharath.myindianstates;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] states = {"Jammu & Kashmir", "Himachal Pradesh", "punjab", "Haryana", "Delhi", "Uttrakhand", "Uttarpradesh", "Rajasthan", "Bihar","jharkhand","madhyapradesh","West Bengal","orissa","chattisgarh","Gujarat","Maharastra","Goa","Telangana","Karnataka","Kerala","Tamilnadu","Andhrapradesh","Sikkim","Meghalaya","mizoram","Nagaland","Assam","ArunachalPradesh","Tripura"};

        final ArrayList arrayList = new ArrayList(Arrays.asList(states));
        ListView listView = findViewById(R.id.mylistview);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"You tapped on:" + arrayList.get(position), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
