package com.wisestudy.nongroup.retrofitapi;

import com.wisestudy.nongroup.dto.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface NonGroupCategoryApi {

    @GET("/api/v1/categories/1")
    Call<ResponseDto> getCategories();
}
