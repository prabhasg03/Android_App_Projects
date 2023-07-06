package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public RadioGroup radioGroup;
    public RadioButton radioButton;
    String a="";
        public void onclick (View view){
            try{
        EditText x = findViewById(R.id.inp);
        EditText o = findViewById(R.id.opt);
        a = o.getText().toString();
        if (a.equals("1")) {
            Double a = Double.parseDouble(x.getText().toString());
            Double b = a + 273.15;
            Double c = ((9.0 / 5.0) * a) + 32.0;
            TextView cel = (TextView) findViewById(R.id.cel);
            TextView fah = (TextView) findViewById(R.id.fah);
            TextView kev = (TextView) findViewById(R.id.kev);
            cel.setText("Celsius=" + String.valueOf(a) + "°C");
            fah.setText("Fahrenheit=" + String.valueOf(c) + "°F");
            kev.setText("Kelvin=" + String.valueOf(b) + "K");
        }
        if (a.equals("2")) {
            Double c = Double.parseDouble(x.getText().toString());
            Double a = ((5.0 / 9.0) * (c - 32.0));
            Double b = a + 273.15;
            TextView cel = (TextView) findViewById(R.id.cel);
            TextView fah = (TextView) findViewById(R.id.fah);
            TextView kev = (TextView) findViewById(R.id.kev);
            cel.setText("Celsius=" + String.valueOf(a) + "°C");
            fah.setText("Fahrenheit=" + String.valueOf(c) + "°F");
            kev.setText("Kelvin=" + String.valueOf(b) + "K");
        }
        if (a.equals("3")) {
            Double b = Double.parseDouble(x.getText().toString());
            Double a = b - 273.15;
            Double c = ((9.0 / 5.0) * a) + 32.0;
            TextView cel = (TextView) findViewById(R.id.cel);
            TextView fah = (TextView) findViewById(R.id.fah);
            TextView kev = (TextView) findViewById(R.id.kev);
            cel.setText("Celsius=" + String.valueOf(a) + "°C");
            fah.setText("Fahrenheit=" + String.valueOf(c) + "°F");
            kev.setText("Kelvin=" + String.valueOf(b) + "K");
        }}
            catch(Exception e) {
                Toast.makeText(MainActivity.this,"Please Enter a value",Toast.LENGTH_LONG);
            }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}}