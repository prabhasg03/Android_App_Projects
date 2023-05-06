package com.example.edittextapp;

import static android.widget.Toast.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclickbutton(View view){
        EditText nm=findViewById(R.id.editTextName);
        EditText pw=findViewById((R.id.password));
        String a=nm.getText().toString().replaceAll(" ",""),b=pw.getText().toString();
        Log.i("button","Button clicked");
        Log.i("button","Name:"+a);
        if(a.equals("Prabhas")&&b.equals("2003")) {
            Toast.makeText(MainActivity.this, "Welcome " + a + " Sir", LENGTH_LONG).show();
            Snackbar.make(view, "Message Sent " + a + " Sir", 3000).setAction("Undo", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Just Kidding ;)", 500).show();
                }
            }).show();
        }else{
            Toast.makeText(MainActivity.this,"Incorrect Password/Name",LENGTH_LONG).show();
        }
    }
}