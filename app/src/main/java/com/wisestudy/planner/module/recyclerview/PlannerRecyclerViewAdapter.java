package com.wisestudy.planner.module.recyclerview;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.wisestudy.R;

import java.util.List;

public class PlannerRecyclerViewAdapter extends RecyclerView.Adapter<PlannerRecyclerViewAdapter.MyViewHolder> {

    private List<PlannerVO> recyclerDataList;

    public PlannerRecyclerViewAdapter(List<PlannerVO> dataList){
        recyclerDataList = dataList;
    }

    @NonNull
    @Override
    public PlannerRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_planner_recyclerview_item,parent,false);

        return new PlannerRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlannerRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.onBind(recyclerDataList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView dateView;
        private TextView titleView;
        private TextView locationView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            dateView = itemView.findViewById(R.id.dateId);
            titleView = itemView.findViewById(R.id.titleId);
            locationView = itemView.findViewById(R.id.locationId);

        }

        public void onBind(PlannerVO plannerVO, int position) {
            dateView.setText(recyclerDataList.get(position).getDate());
            titleView.setText(recyclerDataList.get(position).getTitle());
            locationView.setText(recyclerDataList.get(position).getContents());
        }
    }
}

