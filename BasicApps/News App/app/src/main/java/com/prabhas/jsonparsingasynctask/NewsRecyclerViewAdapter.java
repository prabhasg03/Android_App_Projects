package com.prabhas.jsonparsingasynctask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder>{

    private List<String> mData;
    private LayoutInflater mLayoutInflator;

    NewsRecyclerViewAdapter(Context context, List<String> data){
            this.mData=data;
            this.mLayoutInflator=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.news_recyclerview_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data=mData.get(position);
        holder.titleTextView.setText(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

    TextView titleTextView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView=itemView.findViewById(R.id.tvTitle);
    }
}
}
