package com.example.kieran.conversionappwithintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> conversions;
    private ArrayList<Double> rates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text_view);
        listView = (ListView) findViewById(R.id.list_view);
        conversions = new ArrayList<>();
        conversions.add("Kilograms");
        conversions.add("Grams");
        conversions.add("Ounces");
        conversions.add("Tons");
        conversions.add("Baby Elephants");

        rates = new ArrayList<>();
        rates.add(0.453592);
        rates.add(453.592);
        rates.add(16.0);
        rates.add(0.0005);
        rates.add(0.0045);

        adapter = new ArrayAdapter<>(this, R.layout.list_view_item,
                R.id.item_text_view, conversions);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = conversions.get(position);
                Double rate = rates.get(position);

                Intent i = new Intent(getApplicationContext(), ConversionActivity.class);
                i.putExtra("unit", s);
                i.putExtra("rate", rate);
                startActivity(i);
            }
        });
    }


}
