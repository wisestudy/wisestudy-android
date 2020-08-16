package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.wisestudy.groupleader.domain.GroupLeaderMangementPlannerVO;
import com.wisestudy.groupleader.service.GroupLeaderService;
import com.wisestudy.nongroup.domain.StudyCreateVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.planner.activity.PlannerActivity;
import com.wisestudy.user.activity.UserActivity;
import com.wisestudy.user.service.UserService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wisestudy.groupleader.activity.GroupLeaderDetailActivity.GroupLeaderStudyId;

public class GroupLeaderCreatePlannerActivity extends AppCompatActivity {

    private static final String TAG = "GROUP_LEADER_SERVICE";
    private TextInputEditText groupLeaderCreateStudyLocation;
    private TextInputEditText groupLeaderCreateStudyDate;
    private TextInputEditText groupLeaderCreateStudyTime;
    private TextInputEditText groupLeaderCreateStudyDescription;
    private GroupLeaderService service;
    private String id = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmanagement_createstudy);

        Initialized();

    }

    private void Initialized() {
        groupLeaderCreateStudyLocation = findViewById(R.id.groupLeaderCreateStudyLocation);
        groupLeaderCreateStudyDate = findViewById(R.id.groupLeaderCreateStudyDate);
        groupLeaderCreateStudyTime = findViewById(R.id.groupLeaderCreateStudyTime);
        groupLeaderCreateStudyDescription = findViewById(R.id.groupLeaderCreateStudyDescription);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyToolbar));
        UiHelper.hideWindow(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.createStudy){
            service = new GroupLeaderService();
            service.createGroupLeaderPlanner(postGroupLeaderPlanner(), new Callback<GroupLeaderMangementPlannerVO>() {
                @Override
                public void onResponse(Call<GroupLeaderMangementPlannerVO> call, Response<GroupLeaderMangementPlannerVO> response) {
                    if(response.isSuccessful() == false){
                        Log.d(TAG, "Failed to register");
                    }else{
                        Log.d(TAG, "Success to register");

                        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(intent);
                    }

                }

                @Override
                public void onFailure(Call<GroupLeaderMangementPlannerVO> call, Throwable t) {
                    Log.d(TAG, t.getMessage());
                }
            },id);
        }
        return true;
    }

    private GroupLeaderMangementPlannerVO postGroupLeaderPlanner(){

        id = "21";
        String location = groupLeaderCreateStudyLocation.getText().toString();
        String dayTime =groupLeaderCreateStudyDate.getText().toString()+"T"+groupLeaderCreateStudyTime.getText().toString();
        String description =groupLeaderCreateStudyDescription.getText().toString();

        GroupLeaderMangementPlannerVO groupLeaderMangementPlannerVO = new GroupLeaderMangementPlannerVO(Integer.parseInt(id),dayTime,location,description);

        return groupLeaderMangementPlannerVO;
    }

}
