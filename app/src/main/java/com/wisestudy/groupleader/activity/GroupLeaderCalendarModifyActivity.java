package com.wisestudy.groupleader.activity;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.CalendarModifyVO;
import com.wisestudy.groupleader.module.adapter.recyclerviewadapter.CalendarRecyclerViewAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;


public class GroupLeaderCalendarModifyActivity extends AppCompatActivity {

    private List<CalendarModifyVO> list;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.ItemDecoration itemDecoration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_calendarmodify);

        UiHelper.toolBarInitialize(this, findViewById(R.id.calendarModifyToolbar));
        UiHelper.hideWindow(this);

        Initialized();
        recyclerView = findViewById(R.id.calendarModifyRecyclerView);

        /**
         * 리사이클러뷰 안에 표시해 줄 레이아웃매니저 설정
         */
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CalendarRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private void Initialized() {
        list = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            list.add(new CalendarModifyVO(getDrawable(R.drawable.kakao_default_profile_image), 6,"경기도 안양시 동안구 스타벅스", "이운기 스터디"));
            list.add(new CalendarModifyVO(getDrawable(R.drawable.kakao_default_profile_image), 7, "신림동 이름 모를카페", "문성쓰 스터디"));
            list.add(new CalendarModifyVO(getDrawable(R.drawable.kakao_default_profile_image), 10, "구로 할리스", "택윤이의 스터디"));
            list.add(new CalendarModifyVO(getDrawable(R.drawable.kakao_default_profile_image), 13, "작전동 커피빈", "병무의 스터디"));
        }
    }
}
