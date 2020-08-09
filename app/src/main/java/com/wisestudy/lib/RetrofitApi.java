package com.wisestudy.lib;


import com.wisestudy.nongroup.vo.Study;
import com.wisestudy.planner.vo.PlannerVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

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
}