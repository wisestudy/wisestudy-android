package com.wisestudy.user.UserService;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.nongroup.domain.StudyCreateVO;
import com.wisestudy.nongroup.nonGroupDto.StudySearchDto;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.UserDto.UserResponseDto;

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

    public void createStudy(StudyCreateVO studyCreateVO, Callback<StudySearchDto> callback){
        Call<StudySearchDto> call = retrofitAPi.postUserCreateStudy(studyCreateVO);
        call.enqueue(callback);
    }


}
