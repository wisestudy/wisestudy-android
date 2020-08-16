package com.wisestudy.groupleader.service;

import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;
;

import okhttp3.ResponseBody;
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

        public void retrieveGroupLeaderManagementGroupMember(Callback<GroupLeaderDto> callback, String id){
            Call<GroupLeaderDto> call = retrofitAPi.getGroupLeaderManagementGroupMember(id);
            call.enqueue(callback);
        }
        public void retrieveGroupLeaderManagementGroupMemberDelete(Callback<ResponseBody>callback, String studies_id, String study_members_id){
            Call<ResponseBody> call = retrofitAPi.deleteGroupMember(studies_id,study_members_id);
            call.enqueue(callback);
        }
}
