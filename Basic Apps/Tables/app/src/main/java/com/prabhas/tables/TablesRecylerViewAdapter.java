package com.prabhas.tables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TablesRecylerViewAdapter extends RecyclerView.Adapter<TablesRecylerViewAdapter.ViewHolder>{

    List<String> mdata;
    LayoutInflater mLayoutInflator;
    TablesRecylerViewAdapter(List<String> data,Context context){
        this.mdata=data;
        this.mLayoutInflator=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflator.inflate(R.layout.recycler_row_table,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tableVal=mdata.get(position);
        holder.mTextViewTables.setText(tableVal);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView mTextViewTables;
     public ViewHolder(@NonNull View itemView){
         super(itemView);
         mTextViewTables =itemView.findViewById(R.id.tv_table);
     }
    }
}
