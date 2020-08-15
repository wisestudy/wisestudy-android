package com.wisestudy.nongroup.module.view.recyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.nongroup.activity.NonGroupUserDetail;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchRecyclerViewAdapter extends RecyclerView.Adapter<StudySearchRecyclerViewAdapter.ViewHolder> {

    private List<StudyVO> list = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_nongroup_studysearch_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.studySearchStudyTitle.setText(list.get(position).getTitle());
        holder.studySearchStudyMemberCount.setText(Integer.toString(list.get(position).getLimit()));
        holder.studySearchStudyDescription.setText(list.get(position).getDescription());
        holder.studySearchStudyLocation.setText(Integer.toString(list.get(position).getStudy_id()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems(StudyVO data){
        list.add(data);
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
            studySearchStudyMemberCount = itemView.findViewById(R.id.studySearchStudyMemberCount);
            studySearchStudyDescription = itemView.findViewById(R.id.studySearchStudyDescription);
            studySearchStudyLocation = itemView.findViewById(R.id.studySearchStudyLocation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String study_id = studySearchStudyLocation.getText().toString();

                    Intent intent = new Intent(itemView.getContext(), NonGroupUserDetail.class);
                    intent.putExtra("STUDY_ID", study_id);

                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}