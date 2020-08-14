package com.example.clock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    Activity context;
    ArrayList<String> countries;

    public MyListAdapter(Activity context, ArrayList<String> countries) {
        super(context, 0);
        this.context = context;
        this.countries = countries;
    }

    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.lv_content, null, true);

        TextView countryName = rowView.findViewById(R.id.tvCountryName);
        TextClock countryTime = rowView.findViewById(R.id.tcCountryTime);

        countryName.setText(countries.get(position));
        countryTime.setTimeZone(countries.get(position));
        countryTime.setVisibility(View.VISIBLE);

        return rowView;
    }
}
