package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.groupleader.domain.GroupLeaderDetailVO;
import com.wisestudy.groupleader.service.GroupLeaderDetailService;
import com.wisestudy.planner.activity.PlannerActivity;
import com.wisestudy.planner.service.PlannerService;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupLeaderDetailActivity extends AppCompatActivity {
    private MaterialButton createStudy;
    private GroupLeaderDetailService services;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_detail);

        UiHelper.toolBarInitialize(this, findViewById(R.id.groupLeaderDetailToolBar));
        UiHelper.hideWindow(this);

        createStudy = findViewById(R.id.groupLeaderDetailCreateStudy);
        createStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupLeaderCreatePlannerActivity.class);
                startActivity(intent);
            }
        });

        services = new GroupLeaderDetailService();
        services.retrieveSchedules(new Callback<List<GroupLeaderDetailVO>>() {
            @Override
            public void onResponse(Call<List<GroupLeaderDetailVO>> call, Response<List<GroupLeaderDetailVO>> response) {
                if(response.isSuccessful() == false){
                    Log.d("GroupLeaderDetail", "Failed to register");
                }

                for(GroupLeaderDetailVO item : response.body()){
                    System.out.println("==>"+item);
                    Log.d("RetrofitSuccessful", "successful");
                }
            }

            @Override
            public void onFailure(Call<List<GroupLeaderDetailVO>> call, Throwable t) {
                Log.d("GroupLeaderDetail", t.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.management, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.management){
            Intent intent = new Intent(getApplicationContext(), GroupLeaderManagementActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
