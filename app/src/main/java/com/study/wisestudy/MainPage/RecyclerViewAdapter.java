package com.study.wisestudy.MainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.study.wisestudy.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<RecyclerViewData> recyclerDataList=null;
    RecyclerViewAdapter(ArrayList<RecyclerViewData> dataList){
        recyclerDataList=dataList;
    }
    private RecyclerViewHolder viewHolder;
    private View view;
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view=inflater.inflate(R.layout.activity_recyclerview,parent,false);
        viewHolder=new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(recyclerDataList.get(position).getPic());
        holder.dateView.setText(recyclerDataList.get(position).getDate());
        holder.titleView.setText(recyclerDataList.get(position).getTitle());
        holder.contensView.setText(recyclerDataList.get(position).getContents());
    }


    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }
}
