package com.wisestudy.nongroup.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.module.view.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.service.CategoryService;
import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

public class StudySearchActivity extends AppCompatActivity {

    private StudySearchRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Study> studyList;
    private CategoryService categoryService;
    private static String TAG = "CATEGORY_SERVICE";

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);

        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudySearchRecyclerViewAdapter();

    }
}
