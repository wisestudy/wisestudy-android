package com.wisestudy.nongroup.service;

import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.nongroup.dto.ResponseDto;
import com.wisestudy.nongroup.retrofitapi.NonGroupCategoryApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CategoryService {

    private NonGroupCategoryApi nonGroupCategoryApi;

    public CategoryService() {
        this.nonGroupCategoryApi = RetrofitClient.getInstance();
    }

    public void retrieveCategory(Callback<ResponseDto> callback){
        Call<ResponseDto> call = nonGroupCategoryApi.getCategories();
        call.enqueue(callback);
    }
}
