package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.nongroup.vo.Study;
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
        service.retrieveStudy(new Callback<List<Study>>() {
            @Override
            public void onResponse(Call<List<Study>> call, Response<List<Study>> response) {
                if(response.isSuccessful() == false){
                    Log.d("NonGroupMemberFail","Failed to register");
                }

                for(Study item : response.body()){
                    Log.d("NonGroupMemSuccessful","Successful");

                }
            }

            @Override
            public void onFailure(Call<List<Study>> call, Throwable t) {
                System.out.println("=====>"+t.getMessage());

            }
        });
    }
}
