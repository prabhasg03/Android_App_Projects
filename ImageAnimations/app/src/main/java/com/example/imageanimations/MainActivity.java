package com.example.imageanimations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void oncki(View view){
        boolean d=false;
        //ImageView iv=findViewById(R.id.op);
        ImageView ivb=findViewById(R.id.bb);
        //fading animation
        /*iv.animate().alpha(1).setDuration(2000);
        ivb.animate().alpha(0).setDuration(2000);*/
        //fading -2 code
        /*if(d){
            d=false;
            iv.animate().alpha(0).setDuration(2000);
            ivb.animate().alpha(1).setDuration(2000);
        }else{
            d=true;
            iv.animate().alpha(1).setDuration(2000);
            ivb.animate().alpha(0).setDuration(2000);
        }*/
        //Translation animation
        /*ivb.animate().translationXBy(-2000).setDuration(2000);
        ivb.animate().translationYBy(+3000).setDuration(2000);*/
        //scaling animation
        //ivb.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);
        //rotation
        ivb.animate().rotation(360).setDuration(2000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //rotation without touching
        ImageView ivb=findViewById(R.id.bb);
        ivb.setX(-2000);
        ivb.animate().translationXBy(2000).rotation(3600).setDuration(5000);
    }
}