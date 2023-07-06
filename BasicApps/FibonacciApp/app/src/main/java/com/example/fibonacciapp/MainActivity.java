package com.example.fibonacciapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String e="",o="",pr="True",p="",f="";
    long num;
    public boolean isPerfectSquare(){
        double sqRoot = (int) Math.sqrt(num);
        //Example : 18 sqRoot : 5.6
        //Math.floor(sqRoot) = 4

        return sqRoot * sqRoot == num;
    }

    //Challenge : Print fibonacci series
    public boolean isFibonaaciNumber(){
        this.num = 5*num*num+4;
        boolean var1 = isPerfectSquare();
        this.num = 5*num*num-4;
        boolean var2 = isPerfectSquare();
        return (var1 || var2);
    }
    public boolean isprime(Long n){
        if(n==2||n==3){
            return true;
        }
        else if(n%2==0){
            return false;
        }
        else{
            for(int i=4;i<n/i;i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public void info(Long n){
    num=n;
    e=n%2==0?"True":"False";
    o=n%2!=0?"True":"False";
    pr=isprime(n)?"True":"False";
    p=isPerfectSquare()?"True":"False";
    f=isFibonaaciNumber()?"True":"False";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("SetTextI18n")
    public void onclick(View view){
        try{
        EditText g=findViewById(R.id.no);
        Long n=Long.parseLong(g.getText().toString());
        info(n);
        TextView l= findViewById(R.id.sol);
        l.setText("Number:"+n+"\nEven:"+e+"\nOdd:"+o+"\nPrime:"+pr+"\nPerfect Square:"+p+"\nFibonacci:"+f);}
        catch(Exception e){
            TextView l= findViewById(R.id.sol);
            l.setText("Please Enter a number!");
        }
    }
}