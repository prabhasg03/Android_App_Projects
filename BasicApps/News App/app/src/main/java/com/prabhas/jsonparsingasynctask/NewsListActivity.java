package com.prabhas.jsonparsingasynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class NewsListActivity extends AppCompatActivity {

    NewsRecyclerViewAdapter mNewsRecyclerViewAdapter;
    ArrayList<String> titlesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        titlesList=(ArrayList<String>) getIntent().getSerializableExtra("data");
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNewsRecyclerViewAdapter =new NewsRecyclerViewAdapter(this,titlesList);

        recyclerView.setAdapter(mNewsRecyclerViewAdapter);
    }
}