package com.wisestudy.groupleader.service;

import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
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

        public void retrieveGroupLeaderDetail(Callback<GroupLeaderDto> callback, String id){
            Call<GroupLeaderDto> call = retrofitAPi.getGroupLeaderDetail(id);
            call.enqueue(callback);
        }
}
