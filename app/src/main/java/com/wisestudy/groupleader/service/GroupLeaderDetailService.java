package com.wisestudy.groupleader.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
import com.wisestudy.groupleader.domain.GroupLeaderDetailVO;;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GroupLeaderDetailService {
        private RetrofitApi retrofitAPi;
        private RetrofitClient GroupLeaderDetailRetrofitClient;

        public GroupLeaderDetailService() {
            this.retrofitAPi = GroupLeaderDetailRetrofitClient.getInstance();
        }

        public void retrieveSchedules(Callback<List<GroupLeaderDetailVO>> callback){
            Call<List<GroupLeaderDetailVO>> call = retrofitAPi.getSchedules();
            call.enqueue(callback);
        }
}
