package com.wisestudy.groupleader.service;

import com.wisestudy.groupleader.domain.GroupLeaderMangementPlannerVO;
import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
;

import retrofit2.Call;
import retrofit2.Callback;

public class GroupLeaderService {
        private RetrofitApi retrofitAPi;
        private RetrofitClient GroupLeaderDetailRetrofitClient;

        public GroupLeaderService() {
            this.retrofitAPi = GroupLeaderDetailRetrofitClient.getInstance();
        }

        public void retrieveGroupLeaderDetail(Callback<GroupLeaderDto> callback, String id){
            Call<GroupLeaderDto> call = retrofitAPi.getGroupLeaderDetail(id);
            call.enqueue(callback);
        }

        public void createGroupLeaderPlanner(GroupLeaderMangementPlannerVO groupLeaderMangementPlannerVO, Callback<GroupLeaderMangementPlannerVO> callback,String id){
            Call<GroupLeaderMangementPlannerVO> call = retrofitAPi.postGroupSchedule(id,groupLeaderMangementPlannerVO);
            call.enqueue(callback);
        }
}
