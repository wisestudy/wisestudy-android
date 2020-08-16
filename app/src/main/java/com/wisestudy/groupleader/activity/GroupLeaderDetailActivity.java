package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
import com.wisestudy.groupleader.module.adapter.recyclerviewadapter.GroupLeaderDetailRecyclerView;
import com.wisestudy.groupleader.service.GroupLeaderService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupLeaderDetailActivity extends AppCompatActivity {
    private MaterialButton createStudy;
    private MaterialTextView groupLeaderDetailStudyTitle;
    private GroupLeaderService services;
    public static String GroupLeaderStudyId = "";
    private RecyclerView recyclerView;
    private GroupLeaderDetailRecyclerView adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_detail);

        Initialized();

        createStudy = findViewById(R.id.groupLeaderDetailCreateStudy);
        createStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupLeaderCreatePlannerActivity.class);
                startActivity(intent);
            }
        });

        services = new GroupLeaderService();
        services.retrieveGroupLeaderDetail(new Callback<GroupLeaderDto>() {
            @Override
            public void onResponse(Call<GroupLeaderDto> call, Response<GroupLeaderDto> response) {
                if(response.isSuccessful() == false){
                    Log.d("GroupLeaderDetail", "Failed to register");
                }
                else{
                    Log.d("GroupLeaderDetail", "Success to register");

                    adapter.addItems(response.body().getMessage().getStudy_members());
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<GroupLeaderDto> call, Throwable t) {
                Log.d("GroupLeaderDetail", t.getMessage());
            }
        },GroupLeaderStudyId);
    }

    private void Initialized() {
        UiHelper.toolBarInitialize(this, findViewById(R.id.groupLeaderDetailToolBar));
        UiHelper.hideWindow(this);

        Intent getIntent = getIntent();
        GroupLeaderStudyId = getIntent.getExtras().getString("studyId");
        groupLeaderDetailStudyTitle = findViewById(R.id.groupLeaderDetailStudyTitle);
        groupLeaderDetailStudyTitle.setText(getIntent.getExtras().getString("studyTitle"));

        recyclerView = findViewById(R.id.groupLeaderDetailRecyclerView);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new GroupLeaderDetailRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.management, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.management){
            Intent intent = new Intent(getApplicationContext(), GroupLeaderManagementActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
