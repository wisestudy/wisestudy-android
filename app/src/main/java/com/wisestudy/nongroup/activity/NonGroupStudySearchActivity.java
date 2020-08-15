package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.wisestudy.nongroup.module.view.recyclerview.StudySearchRecyclerViewAdapter;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.nongroup.nonGroupDto.StudySearchDto;
import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.nongroup.domain.StudyVO;
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
    private List<StudyVO> data;
    private String UserFavoriteField;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nongroup_study_search);

        Initialized();

        RecyclerView recyclerView = findViewById(R.id.study_search_recycler_view);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudySearchRecyclerViewAdapter();

        String[] field = getResources().getStringArray(R.array.favoriteField);
        ArrayAdapter<String> autoCompleteTextAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, field);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.editTextTextPersonName);
        autoCompleteTextView.setAdapter(autoCompleteTextAdapter);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserFavoriteField = ((TextView)view).getText().toString();

                service.retrieveNonGroupSearchStudy(new Callback<StudySearchDto>() {
                    @Override
                    public void onResponse(Call<StudySearchDto> call, Response<StudySearchDto> response) {
                        if(response.isSuccessful() == false){
                            Log.d(TAG,"Failed to register");
                        }
                        else{
                            Log.d(TAG,"Success to register");
                            for(StudyVO item : response.body().getMessage()){
                                adapter.addItems(item);
                                System.out.println(item.getCategory() +"," + item.getDescription() + "," + item.getTitle());
                            }
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<StudySearchDto> call, Throwable t) {
                        System.out.println("=====>"+t.getMessage());

                    }
                },UserFavoriteField);
            }
        });
    }

    private void Initialized() {

        UiHelper.toolBarInitialize(this, findViewById(R.id.studySearchToolBar));
        UiHelper.hideWindow(this);
        service = new StudyService();


    }
}