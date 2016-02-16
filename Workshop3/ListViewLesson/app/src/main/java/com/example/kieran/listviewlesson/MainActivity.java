package com.example.kieran.listviewlesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText poundsEditText;
    private ListView conversionList;
    private ArrayList<String> results;
    private ArrayAdapter adapter;

    final double KILO_CONVERSION_RATE = 0.453592;
    final double GRAMS_CONVERSION_RATE = 453.592;
    final double OUNCES_CONVERSION_RATE = 16;
    final double TONS_CONVERSION_RATE = 0.0005;
    final double ELEPHANT_CONVERSION_RATE = 0.0045;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poundsEditText = (EditText) findViewById(R.id.edit_text_pounds);
        conversionList = (ListView) findViewById(R.id.conversion_list);

        /*
            Key for Results ArrayList
            [0] - kg
            [1] - grams
            [2] - oz
            [3] - tons
            [4] - Elephants
         */
        results = new ArrayList<>();
    }

    public void convert(View view) {
        String s = poundsEditText.getText().toString();
        int valPounds = Integer.parseInt(s);
        results.clear();

        results.add((valPounds * KILO_CONVERSION_RATE) + " kg");
        results.add((valPounds * GRAMS_CONVERSION_RATE) + " grams");
        results.add((valPounds * OUNCES_CONVERSION_RATE) + " oz");
        results.add((valPounds * TONS_CONVERSION_RATE) + " tons");
        results.add((valPounds * ELEPHANT_CONVERSION_RATE) + " baby elephants");

        adapter = new ArrayAdapter(this, R.layout.list_item, R.id.list_view_item, results);
        conversionList.setAdapter(adapter);
        poundsEditText.setText("");
    }
}
