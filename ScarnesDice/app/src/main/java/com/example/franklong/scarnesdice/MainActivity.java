package com.example.franklong.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView javaNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        javaNumberTextView = (TextView) findViewById(R.id.number_textview);
    }

    public void random(View view) {
        int randomNum = (int) (Math.random() * 6) + 1;
        javaNumberTextView.setText("" + randomNum);
    }
}
