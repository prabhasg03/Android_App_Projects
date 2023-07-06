package com.example.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    boolean a=true;
    String url="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3";
    public void play(View view){
        if(a==true){mp.start();}
        else{        mp=MediaPlayer.create(this, Uri.parse(url));
        mp.start();
        a=true;}
    }
    public void pause(View view){
        mp.pause();
    }
    public void stop(View view){
        mp.stop();
        a=false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this, Uri.parse(url));
       //MediaPlayer mp=MediaPlayer.create(this,R.raw.sample);
        mp.start();
    }
}