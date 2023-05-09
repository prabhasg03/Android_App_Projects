package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    public void onTap(View view){
        VideoView vw=(VideoView) findViewById(R.id.vv);
         vw.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
         vw.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}