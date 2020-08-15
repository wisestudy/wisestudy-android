package com.wisestudy.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisestudy.user.userDto.UserResponseDto;
import com.wisestudy.user.domain.UserStudyVO;
import com.wisestudy.user.module.adapter.UserRecyclerViewAdapter;
import com.wisestudy.user.service.UserService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private UserService services;
    private MaterialToolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private List<UserStudyVO> list;
    private TextView TextName;
    private TextView TextAge;
    private TextView TextPhoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        toolbar = findViewById(R.id.userToolbar);
        bottomNavigationView = findViewById(R.id.userBottomNavigation);
        TextName = findViewById(R.id.userName);
        TextAge = findViewById(R.id.userAge);
        TextPhoneNumber = findViewById(R.id.userPhoneNumber);

        UiHelper.toolBarInitialize(this,toolbar);
        UiHelper.hideWindow(this);

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.userApplyStudyRecyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserRecyclerViewAdapter();

        UiHelper.navigationOnclick(this, bottomNavigationView);

        services = new UserService();
        services.retrieveUsersId(new Callback<UserResponseDto>() {
            @Override
            public void onResponse(Call<UserResponseDto> call, Response<UserResponseDto> response) {
                if(response.isSuccessful() == false){
                    Log.d("User", "Failed to register");
                }

                if(response.isSuccessful()){
                    Log.d("User", "Successful");

                    UserResponseDto item = response.body();

                    TextName.setText(item.getMessage().getName());
                    TextAge.setText(item.getMessage().getAge() + "세");
                    TextPhoneNumber.setText(item.getMessage().getCellphone());

                    adapter.addItems(response.body().getMessage().getStudy_list());
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<UserResponseDto> call, Throwable t) {
                Log.d("UserFailure", t.getMessage());
            }
        }, "1");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.modify,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.appBarModify){
            Intent intent = new Intent(getApplicationContext(), UserModifyActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
