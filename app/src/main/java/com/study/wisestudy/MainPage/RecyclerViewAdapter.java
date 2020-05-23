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
    private ArrayList<RecyclerViewData> R_DataList=null;
    RecyclerViewAdapter(ArrayList<RecyclerViewData> dataList){
        R_DataList=dataList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.activity_recyclerview,parent,false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.Iv.setImageResource(R_DataList.get(position).getPic());
        holder.Dv.setText(R_DataList.get(position).getDate());
        holder.Tv.setText(R_DataList.get(position).getTitle());
        holder.Cv.setText(R_DataList.get(position).getContents());
    }


    @Override
    public int getItemCount() {
        return R_DataList.size();
    }
}
