package com.example.clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TimeZone;

public class GetTimeZone extends AppCompatActivity {

    String countries[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_design);

        countries = TimeZone.getAvailableIDs();

        ArrayAdapter x = new ArrayAdapter(this, R.layout.count_tv, countries);
        ListView lv = findViewById(R.id.lvTimeZone);
        lv.setAdapter(x);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GetTimeZone.this, MainActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("country", countries[position]);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}
