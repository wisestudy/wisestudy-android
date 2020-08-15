package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NonGroupMember extends AppCompatActivity {

    private StudyService service;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_group_member);

        service = new StudyService();
        service.retrieveStudy(new Callback<List<StudyVO>>() {
            @Override
            public void onResponse(Call<List<StudyVO>> call, Response<List<StudyVO>> response) {
                if(response.isSuccessful() == false){
                    Log.d("NonGroupMemberFail","Failed to register");
                }

                for(StudyVO item : response.body()){
                    Log.d("NonGroupMemSuccessful","Successful");

                }
            }

            @Override
            public void onFailure(Call<List<StudyVO>> call, Throwable t) {
                System.out.println("=====>"+t.getMessage());

            }
        });
    }
}
