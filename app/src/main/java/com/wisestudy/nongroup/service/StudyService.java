package com.wisestudy.nongroup.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;

import com.wisestudy.nongroup.vo.Study;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class StudyService {

    private RetrofitApi nonGroupStudyApi;
    private RetrofitClient nonGroupRetrofitClient;

    public StudyService() {
        this.nonGroupStudyApi = nonGroupRetrofitClient.getInstance();
    }

    public void retrieveStudy(Callback<List<Study>> callback){
        Call<List<Study>> call = nonGroupStudyApi.getStudies();
        call.enqueue(callback);
    }
}