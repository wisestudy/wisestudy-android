package com.wisestudy.lib;

import com.wisestudy.nongroup.retrofitapi.NonGroupCategoryApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static final String baseUrl = "https://api-wisestudy.herokuapp.com/";

    private RetrofitClient() {}

    public static NonGroupCategoryApi getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                                  .baseUrl(baseUrl)
                                  .addConverterFactory(GsonConverterFactory.create())
                                  .build();
        }

        return retrofit.create(NonGroupCategoryApi.class);
    }
}
