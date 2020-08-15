package com.wisestudy.nongroup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NonGroupUserDetail extends AppCompatActivity {

    private static final String TAG = "NON_GROUP_SERVICES";

    private MaterialButton nonGroupUserDetailApplyStudy;
    private StudyService service;
    private String studyId;

    private MaterialTextView nonGroupUserDetailStudyName;
    private MaterialTextView nonGroupUserDetailStudyDescription;
    private MaterialTextView nonGroupUserDetailStudyNowMember;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_group_member);

        UiHelper.hideWindow(this);
        Initialized();

        service = new StudyService();
        service.retrieveNonGroupDetailStudy(new Callback<StudyDto>() {
            @Override
            public void onResponse(Call<StudyDto> call, Response<StudyDto> response) {
                if(response.isSuccessful() == false){
                    Log.d(TAG,"Failed to register");
                }else{
                    Log.d(TAG,"Success to register");
                    nonGroupUserDetailStudyName.setText(response.body().getMessage().getTitle());
                    nonGroupUserDetailStudyDescription.setText(response.body().getMessage().getDescription());
                    nonGroupUserDetailStudyNowMember.setText(Integer.toString(response.body().getMessage().getLimit()));
                }
            }

            @Override
            public void onFailure(Call<StudyDto> call, Throwable t) {
                System.out.println("=====>"+t.getMessage());
            }
        }, studyId);

        nonGroupUserDetailApplyStudy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UiHelper.dialogStart(nonGroupUserDetailApplyStudy.getContext(), "신청 완료 되었습니다.", true);
            }
        });

    }

    private void Initialized() {
        nonGroupUserDetailApplyStudy = findViewById(R.id.nonGroupUserDetailApplyStudy);
        nonGroupUserDetailStudyName = findViewById(R.id.nonGroupUserDetailStudyName);
        nonGroupUserDetailStudyDescription = findViewById(R.id.nonGroupUserDetailStudyDescription);
        nonGroupUserDetailStudyNowMember = findViewById(R.id.nonGroupUserDetailStudyNowMember);


        Intent getIntent = getIntent();
        studyId = getIntent.getStringExtra("STUDY_ID");



    }
}
