package com.example.currencyconverter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    private TextView textView1,textView2;
    double first_input ;
    String resultFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView4);
        Bundle extras = getIntent().getExtras();
        resultFinal = extras.getString("Value1");
        first_input = extras.getDouble("Value2");
        textView1.setText(Double.toString(first_input));
        textView2.setText(resultFinal);
    }
}
