package com.prabhas.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
boolean b=false;
    int num=0;
    public void guess(View view){
        try{
        Button bt=findViewById(R.id.button);
       if(!b){
        TextView tv=findViewById(R.id.tv1);
        int i=Integer.getInteger(tv.getText().toString());
        if(i<num){
            Snackbar.make(view,"Guess lower than this number", Snackbar.LENGTH_LONG);
        }
        else if(i>num){
            Snackbar.make(view,"Guess Higher than this number", Snackbar.LENGTH_LONG);
        }
        else{
            Snackbar.make(view,"You Guessed it right",Snackbar.LENGTH_LONG).show();
            bt.setText("Play Again");
            b=true;
        }
    }
    else{
        Random random=new Random();
        num=random.nextInt(20)+1;
bt.setText("Guess");
b=false;
       }}
        catch (Exception e){
            Snackbar.make(view,"Enter a number",5000);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random=new Random();
        num=random.nextInt(20)+1;
    }
}