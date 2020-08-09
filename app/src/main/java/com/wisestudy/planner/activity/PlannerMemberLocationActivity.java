package com.wisestudy.planner.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.module.recyclerview.PlannerMemberLocationRecyclerViewAdapter;
import com.wisestudy.planner.vo.PlannerMemberLocationVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;

public class PlannerMemberLocationActivity extends AppCompatActivity {

    private MapView mapView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<PlannerMemberLocationVO> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_memberlocation);

        UiHelper.toolBarInitialize(this,findViewById(R.id.plannerMemberLocationToolBar));
        UiHelper.hideWindow(this);

        Initialized();

        mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.plannerMemberLocationMapView);
        mapViewContainer.addView(mapView);

        recyclerView = findViewById(R.id.plannerMemberLocationRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PlannerMemberLocationRecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);


    }

    private void Initialized() {
        data = new ArrayList<>();

        data.add(new PlannerMemberLocationVO("이운기","경기도 안양시 동안구 호계동"));
        data.add(new PlannerMemberLocationVO("김택윤", "구로역 1번 출구 할리스"));
        data.add(new PlannerMemberLocationVO("이동우", "안양역 4번 출구"));
        data.add(new PlannerMemberLocationVO("김문성", "신림역 2번 출구"));
        data.add(new PlannerMemberLocationVO("전병무", "작전동"));
        data.add(new PlannerMemberLocationVO("조규진", "작전동"));
        data.add(new PlannerMemberLocationVO("홍종현", "중앙역 5번 출구"));
    }
}
