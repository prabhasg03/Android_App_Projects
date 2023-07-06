package com.prabhas.tables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerViewTables;

    public void generateDataInRecyclerView(int tableNum){
        ArrayList<String> tables=new ArrayList<>();
        for(int i=1;i<=10;i++){
            tables.add(Integer.toString(tableNum)+"x"+Integer.toString(i)+"="+Integer.toString(i*tableNum));
        }
        mRecyclerViewTables.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerViewTables.setAdapter(new TablesRecylerViewAdapter(tables,this));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerViewTables=findViewById(R.id.rv);
        SeekBar ms=findViewById(R.id.seekBar);
        int max=100,min=1,sp=10;
        ms.setMax(max);
        ms.setProgress(sp);
        generateDataInRecyclerView(sp);
        ms.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int tn;
                if(i<min){
                    tn=min;
                    ms.setProgress(tn);
                }else {
                    tn = i;
                }   Log.d("seek","Value:"+tn);
                generateDataInRecyclerView(tn);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}