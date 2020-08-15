package com.wisestudy.lib;


import com.wisestudy.groupleader.domain.GroupLeaderDetailVO;
import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.UserDto.UserDto;
import com.wisestudy.user.domain.UserVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApi {
    /**
     * planner Api
     * @return
     */
    @GET("/api/v1/schedules")
    Call<List<PlannerVO>> getCategories();

    /**
     * nongroup Api
     */
    @GET("/api/v1/studies")
    Call<List<Study>> getStudies();

    /**
     * GroupLeaderDetail Api
     * @return
     */
    @GET("/api/v1/schedules")
    Call<List<GroupLeaderDetailVO>> getSchedules();

    /**
     * user Api
     */
    @GET("api/v1/users/1")
    Call<UserDto> getUsers();

    /**
     * schedule
     * @param id
     * @return
     */
    @GET("api/v1/schedules/{userId}")
    Call<PlannerVO> getScheduleID(@Path("userId") String id);
}