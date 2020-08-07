package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.nongroup.dto.ResponseDto;
import com.wisestudy.nongroup.module.view.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.service.CategoryService;
import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.nongroup.vo.StudySearchVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        categoryService = new CategoryService();
        findViewById(R.id.soccerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryService.retrieveCategory(new Callback<ResponseDto>() {
                    @Override
                    public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                        if(response.isSuccessful() == false){
                            Log.d(TAG,"category_failed");
                        }
                        System.out.println("======>"+response.body().getStudy().get(0).getTitle()
                        + "," + response.body().getStudy().get(0).getLimit() + "," + response.body().getStudy().get(0).getDescription());
                        adapter.addItems(response.body().getStudy());
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<ResponseDto> call, Throwable t) {
                        Log.d(TAG,t.getMessage());
                    }
                });
            }
        });
    }
}