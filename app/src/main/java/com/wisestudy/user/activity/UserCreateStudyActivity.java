package com.wisestudy.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.wisestudy.nongroup.domain.StudyCreateVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.user.service.UserService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCreateStudyActivity extends AppCompatActivity {
    private static final String TAG = "USER_SERVICE";
    private UserService service;
    private StudyCreateVO studyCreateVO;
    private TextInputEditText groupLeaderCreateStudyMemberStudyName;
    private TextInputEditText groupLeaderCreateStudyMemberStudyDescription;
    private TextInputEditText groupLeaderCreateStudyMemberStudyCollectMemberCount;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_createstudy);

        Initialized();


    }

    private void Initialized() {
        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyMemberToolbar));
        UiHelper.hideWindow(this);

        groupLeaderCreateStudyMemberStudyName = findViewById(R.id.groupLeaderCreateStudyMemberStudyName);
        groupLeaderCreateStudyMemberStudyDescription = findViewById(R.id.groupLeaderCreateStudyMemberStudyDescription);
        groupLeaderCreateStudyMemberStudyCollectMemberCount = findViewById(R.id.groupLeaderCreateStudyMemberStudyCollectMemberCount);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_push_ok, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.ok){
            service = new UserService();
            service.createStudy(postStudy(), new Callback<StudyDto>() {
                @Override
                public void onResponse(Call<StudyDto> call, Response<StudyDto> response) {
                    if(response.isSuccessful() == false){
                        Log.d(TAG, "Failed to register");
                    }else{
                        Log.d(TAG, "Success to register");

                        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(intent);
                    }

                }

                @Override
                public void onFailure(Call<StudyDto> call, Throwable t) {
                    Log.d(TAG, t.getMessage());
                }
            });
        }
        return true;
    }

    private StudyCreateVO postStudy(){

        String field = "안드로이드";
        String name = groupLeaderCreateStudyMemberStudyName.getText().toString();
        String des = groupLeaderCreateStudyMemberStudyDescription.getText().toString();
        int member = Integer.parseInt(groupLeaderCreateStudyMemberStudyCollectMemberCount.getText().toString());

        studyCreateVO = new StudyCreateVO(field, name, member, des);

        return studyCreateVO;
    }
}
