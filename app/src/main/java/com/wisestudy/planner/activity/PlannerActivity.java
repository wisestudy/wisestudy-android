package com.wisestudy.planner.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisestudy.planner.module.recyclerview.PlannerRecyclerViewAdapter;
import com.wisestudy.planner.service.PlannerService;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlannerActivity extends AppCompatActivity  {

    private PlannerService services;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private PlannerRecyclerViewAdapter adapter;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        Initialized();
        UiHelper.toolBarInitialize(this, findViewById(R.id.plannerToolBarId));
        UiHelper.hideWindow(this);
        UiHelper.navigationOnclick(this,bottomNavigationView);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PlannerRecyclerViewAdapter();


        services = new PlannerService();
        services.retrieveCategory(new Callback<List<PlannerVO>>() {
            @Override
            public void onResponse(Call<List<PlannerVO>> call, Response<List<PlannerVO>> response) {
                if(response.isSuccessful() == false){
                    Log.d("Planner", "Failed to register");
                }

                for(PlannerVO item : response.body()){
                    System.out.println("==>"+item);
                    adapter.addItems(item);
                }
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PlannerVO>> call, Throwable t) {
                Log.d("Planner", t.getMessage());
            }
        });
    }

    private void Initialized() {
        recyclerView = findViewById(R.id.plannerRecyclerId);
        bottomNavigationView = findViewById(R.id.plannerBottomNavigation);
    }


}