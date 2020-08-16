package com.wisestudy.groupleader.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.GroupLeaderVO;
import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
import com.wisestudy.groupleader.module.adapter.recyclerviewadapter.GroupLeaderManagementGroupMemberRecyclerViewAdapter;
import com.wisestudy.groupleader.service.GroupLeaderDetailService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import static com.wisestudy.groupleader.activity.GroupLeaderDetailActivity.GroupLeaderStudyId;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupLeaderManagementGroupMember extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GroupLeaderManagementGroupMemberRecyclerViewAdapter adapter;
    private CircleImageView groupLeaderImg;

    private GroupLeaderDetailService service;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_managementgroupmember);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyMemberToolbar));
        UiHelper.hideWindow(this);



        recyclerView = findViewById(R.id.groupLeaderCreateStudyMemberRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        groupLeaderImg = findViewById(R.id.groupLeaderCreateStudyManagerImageView);
        adapter = new GroupLeaderManagementGroupMemberRecyclerViewAdapter();

        service = new GroupLeaderDetailService();
        service.retrieveGroupLeaderManagementGroupMember(new Callback<GroupLeaderDto>() {
            @Override
            public void onResponse(Call<GroupLeaderDto> call, Response<GroupLeaderDto> response) {
                if(response.isSuccessful() == false){
                    Log.d("GroupLeaderManagement", "Failed to register");
                }
                else{
                    Log.d("GroupLeaderManagement", "Success to register");
                    int size = response.body().getMessage().getStudy_members().size();
                    for(GroupLeaderVO item : response.body().getMessage().getStudy_members()){
                        if(item.isIs_manager() == true){
                            groupLeaderImg.setImageResource(R.drawable.kakao_default_profile_image);
                        }
                        else{
                            adapter.addItems(item);

                        }
                    }
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<GroupLeaderDto> call, Throwable t) {
                System.out.println("-->"+t.getMessage());
            }
        }, "1");
        recyclerView.setAdapter(adapter);
    }



}
