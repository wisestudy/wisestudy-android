package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.module.recyclerview.StudySearchRecyclerDecoration;
import com.wisestudy.planner.module.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;

public class StudySearchActivity extends AppCompatActivity {

    StudySearchRecyclerViewAdapter adapter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);

        String[] name={"1","2","3","4","5","6","7","8","9","10"};
        String[] field={"1","2","3","4","5","6","7","8","9","10"};
        String[] number={"1","2","3","4","5","6","7","8","9","10"};

        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        int columns=2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        adapter = new StudySearchRecyclerViewAdapter(this,name,field,number);
        StudySearchRecyclerDecoration decoration = new StudySearchRecyclerDecoration(1);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);


        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);
    }

}
