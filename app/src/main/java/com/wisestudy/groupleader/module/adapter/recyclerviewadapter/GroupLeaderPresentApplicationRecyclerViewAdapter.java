package com.wisestudy.groupleader.module.adapter.recyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.PresentApplicationVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class GroupLeaderPresentApplicationRecyclerViewAdapter extends RecyclerView.Adapter<GroupLeaderPresentApplicationRecyclerViewAdapter.ViewHolder> {

    private List<PresentApplicationVO> data = new ArrayList<>();
    public GroupLeaderPresentApplicationRecyclerViewAdapter(List<PresentApplicationVO> list) {
        data = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_groupleader_presentapplication_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.presentApplicationName.setText(data.get(position).getName());
        holder.presentApplicationPhone.setText(data.get(position).getPhone());
        holder.presentApplicationDescription.setText(data.get(position).getDes());
        holder.presentApplicationField.setText(data.get(position).getField());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView presentApplicationName;
        private TextView presentApplicationPhone;
        private TextView presentApplicationDescription;
        private TextView presentApplicationField;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            presentApplicationName = itemView.findViewById(R.id.presentApplicationName);
            presentApplicationPhone = itemView.findViewById(R.id.presentApplicationPhone);
            presentApplicationDescription = itemView.findViewById(R.id.presentApplicationDescription);
            presentApplicationField = itemView.findViewById(R.id.presentApplicationField);
        }
    }
}
