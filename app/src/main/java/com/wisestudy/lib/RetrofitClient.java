package com.wisestudy.lib;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    //private static final String baseUrl = "https://api-wisestudy.herokuapp.com/";
    private static final String baseUrl ="https://api-stage-wisestudy.herokuapp.com/";

    private RetrofitClient() {}

    public static RetrofitApi getInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetrofitApi.class);
    }
}