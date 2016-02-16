package com.example.frank.conversionmad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText poundsEditText;
    private TextView kilosLabel;

    final double CONVERSION_RATE = 0.453592;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poundsEditText = (EditText) findViewById(R.id.edit_text_pounds);
        kilosLabel = (TextView) findViewById(R.id.kilos_label);
    }

    public void convert(View view) {
        String s = poundsEditText.getText().toString();
        int valPounds = Integer.parseInt(s);
        double valKilos = valPounds * CONVERSION_RATE;
        poundsEditText.setText("");
        kilosLabel.setText(valKilos + "");
    }
}
