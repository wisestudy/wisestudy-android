package com.wisestudy.user.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;
import com.wisestudy.user.domain.UserVO;
import com.wisestudy.user.service.UserService;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.wisestudy.user.activity.UserActivity.userEmail;
import static com.wisestudy.user.activity.UserActivity.userGender;
import static com.wisestudy.user.activity.UserActivity.userId;

public class UserModifyActivity extends AppCompatActivity {

    private UserService service;
    private MaterialTextView userModifyUserName;
    private MaterialTextView userModifyUserAge;
    private MaterialTextView userModifyUserPhone;
    private MaterialTextView userModifyUserDescription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_modfiy);

        Initialized();

    }

    private void Initialized() {

        UiHelper.toolBarInitialize(this,findViewById(R.id.userModifyToolbar));
        UiHelper.hideWindow(this);

        userModifyUserName = findViewById(R.id.userModifyUserName);
        userModifyUserAge = findViewById(R.id.userModifyUserAge);
        userModifyUserPhone = findViewById(R.id.userModifyUserPhone);
        userModifyUserDescription = findViewById(R.id.userModifyUserDescription);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_push_ok, menu);

        return true;
    }



    public boolean onOptionsItemSelected(MenuItem menuItem){
        if(menuItem.getItemId() == R.id.ok){
            /**
             *  내 정보 변경 저장하기
             */
            service = new UserService();
            service.modifyUser(putUser(), new Callback<UserVO>() {
                @Override
                public void onResponse(Call<UserVO> call, Response<UserVO> response) {

                }

                @Override
                public void onFailure(Call<UserVO> call, Throwable t) {

                }
            }, userId);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private UserVO putUser() {
        int id = Integer.parseInt(userId);
        String email = userEmail;
        String name = userModifyUserName.getText().toString();
        int age = Integer.parseInt(userModifyUserAge.getText().toString());
        String phone = userModifyUserPhone.getText().toString();
        String gender = userGender;
        String des = userModifyUserDescription.getText().toString();
        String categories = "안드로이드";

        UserVO userVO = new UserVO(id,email,name,age,phone,gender,des,categories);


        return userVO;
    }
}
