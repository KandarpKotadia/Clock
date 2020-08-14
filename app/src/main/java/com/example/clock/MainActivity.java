package com.example.clock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextClock;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView countriesList;
    Button add;
    String country;
    ArrayList<Integer> position;
    ArrayList<String> selectedCountry;
    TextClock tc;
    MyListAdapter ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countriesList = findViewById(R.id.lvCountries);
        add = findViewById(R.id.bAdd);
        tc = findViewById(R.id.tcCountryTime);
        selectedCountry = new ArrayList<>();
        position = new ArrayList<>();

        ob = new MyListAdapter(this, selectedCountry);
        countriesList.setAdapter(ob);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GetTimeZone.class);
                startActivityForResult(i, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                country = data.getStringExtra("country");

                if (position.contains(data.getIntExtra("position", 0))) {
                } else {
                    selectedCountry.add(country);
                    ob.add(country);
                    position.add(data.getIntExtra("position", 0));
                }
            }
        }
    }
}



