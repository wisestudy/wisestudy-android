package com.wisestudy.user.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.nongroup.domain.StudyCreateVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.domain.UserVO;
import com.wisestudy.user.userDto.UserResponseDto;

import retrofit2.Call;
import retrofit2.Callback;

public class UserService {

    private RetrofitApi retrofitAPi;
    private RetrofitClient UserRetrofitClient;

    public UserService() {
        this.retrofitAPi = UserRetrofitClient.getInstance();
    }

    public void retrieveUsersId(Callback<UserResponseDto> callback, String id){
        Call<UserResponseDto> call = retrofitAPi.getUsersId(id);
        call.enqueue(callback);
    }

    public void retrieveCategory(Callback<PlannerVO> callback, String id){
        Call<PlannerVO> call = retrofitAPi.getScheduleID(id);
        call.enqueue(callback);
    }

    public void createStudy(StudyCreateVO studyCreateVO, Callback<StudyDto> callback){
        Call<StudyDto> call = retrofitAPi.postUserCreateStudy(studyCreateVO);
        call.enqueue(callback);
    }

    public void modifyUser(UserVO userVO, Callback<UserVO> callback,  String id){
        Call<UserVO> call = retrofitAPi.putUserInformation(id, userVO);
        call.enqueue(callback);
    }


}
