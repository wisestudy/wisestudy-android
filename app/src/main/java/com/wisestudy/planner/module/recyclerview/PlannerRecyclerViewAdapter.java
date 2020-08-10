package com.wisestudy.planner.module.recyclerview;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.activity.PlannerDetailActivity;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class PlannerRecyclerViewAdapter extends RecyclerView.Adapter<PlannerRecyclerViewAdapter.MyViewHolder> {

    private List<PlannerVO> recyclerDataList = new ArrayList<>();

    @NonNull
    @Override
    public PlannerRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_planner_recyclerview_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlannerRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.onBind(recyclerDataList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    public void addItems(PlannerVO data){
        recyclerDataList.add(data);
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
            dateView.setText(recyclerDataList.get(position).getDatetime());
            titleView.setText(recyclerDataList.get(position).getStudy());
            locationView.setText(recyclerDataList.get(position).getPlace());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), PlannerDetailActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
