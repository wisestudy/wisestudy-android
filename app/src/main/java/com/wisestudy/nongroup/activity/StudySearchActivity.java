package com.wisestudy.nongroup.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.activity.module.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.activity.vo.StudySearchVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class StudySearchActivity extends AppCompatActivity {

    private StudySearchRecyclerViewAdapter adapter;
    private List<StudySearchVO> studyVo;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_search);
        studyVo = new ArrayList<StudySearchVO>();

        VOinitialization();

        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        int columns=2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        adapter = new StudySearchRecyclerViewAdapter(this,studyVo);
        recyclerView.setAdapter(adapter);


        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);
    }

    private void VOinitialization(){
        studyVo.add(new StudySearchVO(1,"1","1",1));
        studyVo.add(new StudySearchVO(2,"2","2",2));
        studyVo.add(new StudySearchVO(3,"3","3",3));
        studyVo.add(new StudySearchVO(4,"4","4",4));
        studyVo.add(new StudySearchVO(5,"5","5",5));
        studyVo.add(new StudySearchVO(6,"6","6",6));
    }

}
