package com.wisestudy.login.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.login.domain.LoginVO;
import com.wisestudy.login.dto.LoginDto;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginService {

    private RetrofitApi LoginRetrofitApi;
    private RetrofitClient LoginRetrofitClient;

    public LoginService() {
        this.LoginRetrofitApi = LoginRetrofitClient.getInstance();
    }

    public void sendAccessToken(Callback<LoginDto> callback, String key){
        Call<LoginDto> call = LoginRetrofitApi.postKey(key);
        call.enqueue(callback);
    }
}
