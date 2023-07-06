package com.prabhas.mathsquiz;

import androidx.appcompat.app.AppCompatActivity;

import java.util.IllegalFormatException;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num=0;
    public void guess(View view){
        EditText editText=findViewById(R.id.number);
        Button bt=findViewById(R.id.button);
        TextView tv=findViewById(R.id.tv2);
        try{
        int n=Integer.parseInt(editText.getText().toString());
        if(n>num){
            tv.setText("Enter a Lower Number");
            bt.setText("Guess Again");
        }else if(n<num){
            tv.setText("Enter a Higher Number");
            bt.setText("Guess Again");
        }
        else{
            tv.setText("You guessed it Right :)");
            bt.setText("Play Again");
            editText.setText("");
            Random random=new Random();
            int num=random.nextInt(21);
        }}
        catch (Exception e){
            tv.setText("Please enter a number");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random=new Random();
        num=random.nextInt(21);
    }
}