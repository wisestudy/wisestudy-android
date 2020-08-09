package com.wisestudy.nongroup.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.nongroup.dto.ResponseDto;
import com.wisestudy.nongroup.retrofitapi.NonGroupCategoryApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class CategoryService {

    private RetrofitApi nonGroupCategoryApi;

    public CategoryService() {
        this.nonGroupCategoryApi = RetrofitClient.getInstance();
    }
}
