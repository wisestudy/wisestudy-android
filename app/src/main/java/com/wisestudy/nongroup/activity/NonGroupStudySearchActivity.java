package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.wisestudy.nongroup.module.view.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NonGroupStudySearchActivity extends AppCompatActivity {

    private static final String TAG = "STUDY_SERVICES";
    private StudyService service;
    private StudySearchRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Study> data;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongroup_study_search);

        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);

        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudySearchRecyclerViewAdapter();


        service = new StudyService();
        service.retrieveStudy(new Callback<List<Study>>() {
            @Override
            public void onResponse(Call<List<Study>> call, Response<List<Study>> response) {
                if(response.isSuccessful() == false){
                    Log.d(TAG,"Failed to register");
                }

                for(Study item : response.body()){
                    adapter.addItems(item);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Study>> call, Throwable t) {
                System.out.println("=====>"+t.getMessage());

            }
        });
    }
}