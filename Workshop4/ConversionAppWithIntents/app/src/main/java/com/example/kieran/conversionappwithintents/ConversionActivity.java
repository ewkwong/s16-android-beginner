package com.example.kieran.conversionappwithintents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConversionActivity extends AppCompatActivity {

    private EditText editText;
    private TextView poundsTextView;
    private TextView conversionTextView;
    private Button convertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        editText = (EditText) findViewById(R.id.edit_text);
        poundsTextView = (TextView) findViewById(R.id.pounds_text_view);
        conversionTextView = (TextView) findViewById(R.id.converion_text_view);
        convertButton = (Button) findViewById(R.id.convert_button);
    }

    public void doConversion(View view){
        String unit = getIntent().getStringExtra("unit");
        Double rate = getIntent().getDoubleExtra("rate", 0.0);
        String value = editText.getText().toString();
        Double input = Double.parseDouble(value);

        poundsTextView.setText(input + " pounds");
        conversionTextView.setText((input * rate) + " " + unit);
        editText.setText("");
    }

    public void goBack(View view){
        finish();
    }


}
