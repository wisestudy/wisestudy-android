package com.wisestudy.groupleader.module.adapter.recyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.groupleader.domain.GroupMemberVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

public class GroupLeaderManagementGroupMemberRecyclerViewAdapter extends RecyclerView.Adapter<GroupLeaderManagementGroupMemberRecyclerViewAdapter.ViewHolder> {
    private List<GroupMemberVO> list;

    public GroupLeaderManagementGroupMemberRecyclerViewAdapter(List<GroupMemberVO> data) {
        list = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_groupleader_managementgroupmember_recyclerview_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.groupLeaderManagementGroupMemberName.setText(list.get(position).getName());
        holder.groupLeaderManagementGroupMemberAge.setText(list.get(position).getAge());
        holder.groupLeaderManagementGroupMemberField.setText(list.get(position).getField());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private MaterialButton memberOut;
        private MaterialTextView groupLeaderManagementGroupMemberName;
        private MaterialTextView groupLeaderManagementGroupMemberAge;
        private MaterialTextView groupLeaderManagementGroupMemberField;
        private MaterialButton upgradeManager;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            memberOut = itemView.findViewById(R.id.memberOut);
            groupLeaderManagementGroupMemberName = itemView.findViewById(R.id.groupLeaderManagementGroupMemberName);
            groupLeaderManagementGroupMemberAge = itemView.findViewById(R.id.groupLeaderManagementGroupMemberAge);
            groupLeaderManagementGroupMemberField = itemView.findViewById(R.id.groupLeaderManagementGroupMemberField);
            upgradeManager = itemView.findViewById(R.id.upgradeManager);

            memberOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UiHelper.dialogStart(itemView.getContext(),"탈퇴 시키시겠습니까?", false);
                }
            });

            upgradeManager.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}
