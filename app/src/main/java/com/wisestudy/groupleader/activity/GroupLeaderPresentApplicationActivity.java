package com.wisestudy.groupleader.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.PresentApplicationVO;
import com.wisestudy.groupleader.module.adapter.recyclerviewadapter.PresentApplicationRecyclerViewAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class PresentApplicationActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private List<PresentApplicationVO> list = new ArrayList<>();;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_presentapplication);

        UiHelper.toolBarInitialize(this,findViewById(R.id.presentApplicationToolbar));
        UiHelper.hideWindow(this);

        Initialized();

        recyclerView = findViewById(R.id.presentApplicationRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PresentApplicationRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

    }

    private void Initialized() {

        list.add(new PresentApplicationVO("이운기 29세", "010-8631-0498",
                "안드로이드 개발자가 꿈이예요","안드로이드"));
        list.add(new PresentApplicationVO("김택윤 28세", "010-0000-0000",
                "백엔드 개발자가 꿈이예요","파이썬"));
        list.add(new PresentApplicationVO("전병무 25세", "010-1111-1111",
                "공기업이 꿈이예요","서버"));
        list.add(new PresentApplicationVO("이동우 25세", "010-2222-2222",
                "안드로이드 개발자가 꿈이예요","안드로이드"));

    }
}
