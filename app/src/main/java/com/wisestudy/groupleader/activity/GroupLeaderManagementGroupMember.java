package com.wisestudy.groupleader.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.GroupMemberVO;
import com.wisestudy.groupleader.module.adapter.recyclerviewadapter.GroupLeaderManagementGroupMemberRecyclerViewAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class GroupLeaderManagementGroupMember extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<GroupMemberVO> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_managementgroupmember);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyMemberToolbar));
        UiHelper.hideWindow(this);

        Initialized();

        recyclerView = findViewById(R.id.groupLeaderCreateStudyMemberRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new GroupLeaderManagementGroupMemberRecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private void Initialized() {

        data = new ArrayList<>();
        data.add(new GroupMemberVO("이운기", "29", "안드로이드"));
        data.add(new GroupMemberVO("홍종현", "25", "안드로이드"));
        data.add(new GroupMemberVO("전병무", "25", "공기업"));
        data.add(new GroupMemberVO("김택윤", "28", "서버"));
        data.add(new GroupMemberVO("이동우", "25", "서버"));

    }

}
