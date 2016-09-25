package com.learning.pranavjain.memorableplaces;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static ArrayList<String> placesArray;
    static ArrayAdapter arrayAdapter;
    static ArrayList<LatLng> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        //List for places
        placesArray = new ArrayList<>();
        placesArray.add("Click to add a new location");

        //List for latlng
        locations = new ArrayList<>();
        locations.add(new LatLng(0,0));

        //Array adapter for the list and listView.
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, placesArray);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("LocationInfo",position);
                startActivity(i);

            }
        });

    }
}
