package com.wisestudy.planner.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.planner.vo.PlannerVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PlannerService {

    private RetrofitApi retrofitAPi;
    private RetrofitClient plannerRetrofitClient;

    public PlannerService() {
        this.retrofitAPi = plannerRetrofitClient.getInstance();
    }

    public void retrieveCategory(Callback<List<PlannerVO>> callback){
        Call<List<PlannerVO>> call = retrofitAPi.getCategories();
        call.enqueue(callback);
    }

}