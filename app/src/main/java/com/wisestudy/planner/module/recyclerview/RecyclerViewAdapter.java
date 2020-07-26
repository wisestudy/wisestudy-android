package com.wisestudy.planner.module.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.wisestudy.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<PlannerVO> recyclerDataList;

    public RecyclerViewAdapter(List<PlannerVO> dataList){
        recyclerDataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_planner_recyclerview,parent,false);

        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.onBind(recyclerDataList.get(position),position);
    }

    @Override
    public int getItemCount() {
        return recyclerDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView imageView;
        private TextView dateView;
        private TextView titleView;
        private TextView contensView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageId);
            dateView = itemView.findViewById(R.id.dateId);
            titleView = itemView.findViewById(R.id.titleId);
            contensView = itemView.findViewById(R.id.contentsId);

        }

        public void onBind(PlannerVO plannerVO, int position) {
            imageView.setImageResource(recyclerDataList.get(position).getImageIndex());
            dateView.setText(recyclerDataList.get(position).getDate());
            titleView.setText(recyclerDataList.get(position).getTitle());
            contensView.setText(recyclerDataList.get(position).getContents());
        }
    }
}

