package com.wisestudy.nongroup.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.module.view.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.vo.StudySearchVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchActivity extends AppCompatActivity {

    private StudySearchRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<StudySearchVO> data;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);

        Initialized();
        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudySearchRecyclerViewAdapter(data);
        recyclerView.setAdapter(adapter);

    }

    private void Initialized() {
        data = new ArrayList<>();
        data.add(new StudySearchVO("안드로이드 입문","서울", "2/8", "안드로이드 초보자 환영"));
        data.add(new StudySearchVO("자바스크립트","안양", "3/6", "자바스크립트 같이 하실 분"));
        data.add(new StudySearchVO("Node.js","신림", "2/8", "백엔드의 세계로 초대 합니다."));
        data.add(new StudySearchVO("딥러닝","수원", "1/4", "같이 배워나가요"));
    }
}
