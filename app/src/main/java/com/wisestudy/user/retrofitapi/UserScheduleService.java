package com.wisestudy.user.retrofitapi;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.UserDto.UserDto;

import retrofit2.Call;
import retrofit2.Callback;

public class UserScheduleService {

    private RetrofitApi retrofitAPi;
    private RetrofitClient UserRetrofitClient;

    public UserScheduleService() {
        this.retrofitAPi = UserRetrofitClient.getInstance();
    }

    public void retrieveCategory(Callback<PlannerVO> callback,String id){
        Call<PlannerVO> call = retrofitAPi.getScheduleID(id);
        call.enqueue(callback);
    }

}