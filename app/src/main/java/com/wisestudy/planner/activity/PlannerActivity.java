package com.wisestudy.planner.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.module.recyclerview.PlannerRecyclerViewAdapter;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class PlannerActivity extends AppCompatActivity  {

    private List<PlannerVO> recyclerDataList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        UiHelper.toolBarInitialize(this, findViewById(R.id.plannerToolBarId));
        UiHelper.hideWindow(this);

        InitializeData();

        recyclerView = findViewById(R.id.plannerRecyclerId);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PlannerRecyclerViewAdapter(recyclerDataList);
        recyclerView.setAdapter(adapter);

    }


    private void InitializeData() {
        recyclerDataList = new ArrayList<>();
        recyclerDataList.add(new PlannerVO("운기의 스터디","안양 커피빈","오후 2시"));
        recyclerDataList.add(new PlannerVO("문성이형의 스터디","안양 스터디룸","오후 1시"));
        recyclerDataList.add(new PlannerVO("택윤이의 스터디","범계 커피빈","오후 3시"));
    }
}