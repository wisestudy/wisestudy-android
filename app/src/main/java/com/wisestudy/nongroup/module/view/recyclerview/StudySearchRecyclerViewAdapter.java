package com.wisestudy.nongroup.module.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchRecyclerViewAdapter extends RecyclerView.Adapter<StudySearchRecyclerViewAdapter.ViewHolder> {

    private List<Study> dataList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_study_search_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textName.setText(dataList.get(position).getTitle());
        holder.textField.setText(dataList.get(position).getDescription());
        holder.textNumber.setText(Integer.toString(dataList.get(position).getLimit()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItems(List<Study> studyList){
        dataList = studyList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private TextView textField;
        private TextView textNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.study_name_text);
            textField=itemView.findViewById(R.id.description_text);
            textNumber=itemView.findViewById(R.id.description_text);

        }
    }
}

