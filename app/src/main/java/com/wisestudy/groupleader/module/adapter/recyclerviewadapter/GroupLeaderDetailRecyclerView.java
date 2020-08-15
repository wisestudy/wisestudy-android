package com.wisestudy.groupleader.module.adapter.recyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.groupleader.domain.GroupLeaderDetailVO;
import com.wisestudy.groupleader.domain.GroupLeaderVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class GroupLeaderDetailRecyclerView extends RecyclerView.Adapter<GroupLeaderDetailRecyclerView.ViewHolder> {
    private List<GroupLeaderVO> list = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_groupleader_detail_recyclerview_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.groupLeaderDetailRecyclerMemberName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems(List<GroupLeaderVO> data) {
        list = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialTextView groupLeaderDetailRecyclerMemberName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groupLeaderDetailRecyclerMemberName = itemView.findViewById(R.id.groupLeaderDetailRecyclerMemberName);
        }
    }
}
