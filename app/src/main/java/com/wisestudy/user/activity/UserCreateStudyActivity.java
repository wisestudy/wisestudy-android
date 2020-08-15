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
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.user.UserDto.UserRequestDto;
import com.wisestudy.user.UserDto.UserResponseDto;
import com.wisestudy.user.UserService.UserService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserCreateStudyActivity extends AppCompatActivity {
    private UserService service;
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
            service.createStudy(postStudy(), new Callback<UserResponseDto>() {
                @Override
                public void onResponse(Call<UserResponseDto> call, Response<UserResponseDto> response) {
                    if(response.isSuccessful() == false){
                        Log.d("createStudy", "Failed to register");
                    }else{
                        Log.d("createStudy", "Success to register");
                    }
                }

                @Override
                public void onFailure(Call<UserResponseDto> call, Throwable t) {

                }
            });
            Intent intent = new Intent(getApplicationContext(), UserActivity.class);
            startActivity(intent);
        }
        return true;
    }

    private StudyCreateVO postStudy(){
        String name = groupLeaderCreateStudyMemberStudyName.getText().toString();
        String des = groupLeaderCreateStudyMemberStudyDescription.getText().toString();
        int member = Integer.parseInt(groupLeaderCreateStudyMemberStudyCollectMemberCount.getText().toString());

        StudyCreateVO studyCreateVO = new StudyCreateVO("안드로이드",name,member,des);
        return studyCreateVO;
    }

}
