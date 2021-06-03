/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.quake_report;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
//        earthquakes.add(new Earthquake("4.6","San Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","jfjjk Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Frankjkvcisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","Sahvkn Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San ","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Frjhkfudancisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","gcj fd","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San Francisco","21/5/2020"));
//        earthquakes.add(new Earthquake("4.6","San hfj","21/5/2020"));


        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        final earthquake_adapter itemsAdapter = new earthquake_adapter(this, earthquakes );



        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(itemsAdapter);
        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected earthquake.
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = itemsAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
