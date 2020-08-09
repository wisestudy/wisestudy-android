package com.wisestudy.nongroup.module.view.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.nongroup.vo.StudySearchVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchRecyclerViewAdapter extends RecyclerView.Adapter<StudySearchRecyclerViewAdapter.ViewHolder> {

    private List<StudySearchVO> list = new ArrayList<>();

    public StudySearchRecyclerViewAdapter(List<StudySearchVO> data) {
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_study_search_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studySearchStudyTitle.setText(list.get(position).getTitle());
        holder.studySearchStudyLocation.setText(list.get(position).getLocaton());
        holder.studySearchStudyMemberCount.setText(list.get(position).getMember());
        holder.studySearchStudyDescription.setText(list.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ShapeableImageView studySearchImage;
        private MaterialTextView studySearchStudyTitle;
        private MaterialTextView studySearchStudyLocation;
        private MaterialTextView studySearchStudyMemberCount;
        private MaterialTextView studySearchStudyDescription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studySearchStudyTitle = itemView.findViewById(R.id.studySearchStudyTitle);
            studySearchStudyLocation = itemView.findViewById(R.id.studySearchStudyLocation);
            studySearchStudyMemberCount = itemView.findViewById(R.id.studySearchStudyMemberCount);
            studySearchStudyDescription = itemView.findViewById(R.id.studySearchStudyDescription);

        }
    }
}

