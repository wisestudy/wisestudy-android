package com.wisestudy.user.retrofitapi;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.user.UserDto.UserDto;
import com.wisestudy.user.domain.UserVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class UserService {

    private RetrofitApi retrofitAPi;
    private RetrofitClient UserRetrofitClient;

    public UserService() {
        this.retrofitAPi = UserRetrofitClient.getInstance();
    }

    public void retrieveCategory(Callback<UserDto> callback){
        Call<UserDto> call = retrofitAPi.getUsers();
        call.enqueue(callback);
    }

}
