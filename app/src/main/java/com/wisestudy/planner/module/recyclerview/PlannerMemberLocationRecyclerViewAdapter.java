package com.wisestudy.planner.module.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.planner.vo.PlannerMemberLocationVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class PlannerMemberLocationRecyclerViewAdapter extends RecyclerView.Adapter<PlannerMemberLocationRecyclerViewAdapter.ViewHolder> {

    private List<PlannerMemberLocationVO> list = new ArrayList<>();

    public PlannerMemberLocationRecyclerViewAdapter(List<PlannerMemberLocationVO> data) {
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_planner_memberlocation_recycelrview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.memberLocationName.setText(list.get(position).getName());
        holder.memberLocationNowLocation.setText(list.get(position).getNowLocation());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialTextView memberLocationName;
        private MaterialTextView memberLocationNowLocation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            memberLocationName = itemView.findViewById(R.id.memberLocationName);
            memberLocationNowLocation = itemView.findViewById(R.id.memberLocationNowLocation);
        }
    }
}
