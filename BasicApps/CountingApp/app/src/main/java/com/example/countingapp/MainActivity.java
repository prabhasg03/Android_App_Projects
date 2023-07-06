package com.example.countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
MediaPlayer mp;
    public void OnTap(View view){
        Button bc=(Button)view;
        if(mp!=null){mp.stop();}
        mp= MediaPlayer.create(this, getResources().getIdentifier(bc.getTag().toString(), "raw", getPackageName()));
        mp.start();
    }
    public void Stop(View view){
        if(mp!=null){
        mp.stop();
    }}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}