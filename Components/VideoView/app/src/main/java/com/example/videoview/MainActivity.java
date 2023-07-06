package com.example.videoview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    public void onTap(View view){
    }
    public void onButtonTap(View view){
        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://youtu.be/d_xyD3nNQuo")));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView vv=findViewById(R.id.vv);
        vv.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video);
        MediaController mc=new MediaController(this);
        mc.setAnchorView(vv);
        vv.setMediaController(mc);
        vv.start();
    }
}