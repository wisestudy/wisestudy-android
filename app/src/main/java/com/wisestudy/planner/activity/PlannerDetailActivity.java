package com.wisestudy.planner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.planner.service.PlannerService;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlannerDetailActivity extends AppCompatActivity {

    private MaterialButton movePlannerLocationClass;
    private PlannerService services;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_detail);

        UiHelper.toolBarInitialize(this, findViewById(R.id.plannerDetailToolBar));
        UiHelper.hideWindow(this);

        Initialized();
        movePlannerLocationClass.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PlannerMemberLocationActivity.class);
            startActivity(intent);
        });

        services = new PlannerService();
        services.retrieveCategory(new Callback<List<PlannerVO>>() {
            @Override
            public void onResponse(Call<List<PlannerVO>> call, Response<List<PlannerVO>> response) {
                if(response.isSuccessful() == false){
                    Log.d("Planner", "Failed to register");
                }

                for(PlannerVO item : response.body()){
                    System.out.println("==>"+item);
                    Log.d("PlannerDetail", "Success");
                }
            }

            @Override
            public void onFailure(Call<List<PlannerVO>> call, Throwable t) {
                Log.d("Planner", t.getMessage());
            }
        });
    }

    private void Initialized() {
        movePlannerLocationClass = findViewById(R.id.plannerSearchMemberLocation);
    }
}
