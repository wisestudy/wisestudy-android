package com.wisestudy.planner.module.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wisestudy.planner.vo.plannerVO;
import com.wisestudy.wisestudy.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<plannerVO> recyclerDataList = null;
    public RecyclerViewAdapter(ArrayList<plannerVO> dataList){
        recyclerDataList = dataList;
    }
    private RecyclerViewHolder viewHolder;
    private View view;
    private Context context;
    private LayoutInflater inflater;

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_planner_recyclerview,parent,false);
        viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(recyclerDataList.get(position).getImageIndex());
        holder.dateView.setText(recyclerDataList.get(position).getDate());
        holder.titleView.setText(recyclerDataList.get(position).getTitle());
        holder.contensView.setText(recyclerDataList.get(position).getContents());
    }


    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }
}

