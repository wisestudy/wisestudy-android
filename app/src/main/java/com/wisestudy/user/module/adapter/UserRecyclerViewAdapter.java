package com.wisestudy.user.module.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.activity.GroupLeaderDetailActivity;
import com.wisestudy.user.activity.UserDetailActivity;
import com.wisestudy.user.domain.UserStudyVO;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

import static com.wisestudy.login.activity.LoginActivity.studyCaptain;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {
    private List<UserStudyVO> list = new ArrayList<>();

    public UserRecyclerViewAdapter(List<UserStudyVO> data) {
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userRecyclerViewStudyName.setText(list.get(position).getStudyName());
        holder.userRecyclerViewStudyDate.setText(list.get(position).getStudyDate());
        holder.userRecyclerViewStudyLocation.setText(list.get(position).getStudyLocation() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userRecyclerViewStudyName;
        private TextView userRecyclerViewStudyDate;
        private TextView userRecyclerViewStudyLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userRecyclerViewStudyName = itemView.findViewById(R.id.userRecyclerViewStudyName);
            userRecyclerViewStudyDate = itemView.findViewById(R.id.userRecyclerViewStudyDate);
            userRecyclerViewStudyLocation = itemView.findViewById(R.id.userRecyclerViewStudyLocation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent;
                    if(studyCaptain == true){
                        intent = new Intent(itemView.getContext(), GroupLeaderDetailActivity.class);
                    }else{
                        intent = new Intent(itemView.getContext(), UserDetailActivity.class);
                    }

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
