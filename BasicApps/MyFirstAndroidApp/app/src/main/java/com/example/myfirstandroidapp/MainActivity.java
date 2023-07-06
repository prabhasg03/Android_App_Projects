package com.example.myfirstandroidapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static int a=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClickButton(View view){
        Log.i("button","Hey you clicked me");
        TextView tv=(TextView) findViewById(R.id.textView2);
            tv.setText(a==1?"Hey,You Clicked me "+a+" time":"Hey,You Clicked me "+a+" times");
            a++;
    }
}