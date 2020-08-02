package com.wisestudy.nongroup.activity.module.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.activity.vo.StudySearchVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchRecyclerViewAdapter extends RecyclerView.Adapter<com.wisestudy.nongroup.activity.module.recyclerview.ViewHolder> {

    private List<StudySearchVO> studyVO;
    private LayoutInflater layoutInflater;

    public StudySearchRecyclerViewAdapter(Context context, List<StudySearchVO>studyVO){
        this.layoutInflater=LayoutInflater.from(context);
        this.studyVO=new ArrayList<>();
        this.studyVO=studyVO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.activity_study_search_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextName().setText(studyVO.get(position).getName());
        holder.getTextField().setText(studyVO.get(position).getField());
        holder.getTextNumber().setText(Integer.toString(studyVO.get(position).getNumber()));
    }

    @Override
    public int getItemCount() {
        return studyVO.size();
    }

}

