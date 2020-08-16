package com.wisestudy.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisestudy.groupleader.service.GroupLeaderDetailService;
import com.wisestudy.nongroup.activity.NonGroupStudySearchActivity;
import com.wisestudy.planner.activity.PlannerActivity;
import com.wisestudy.user.activity.UserActivity;
import com.wisestudy.user.activity.UserCreateStudyActivity;
import com.wisestudy.wisestudy.R;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UiHelper {

    /**
     * 앱바를 사용하려면 activity 마다 같은 코드를 반복적으로 사용해야함
     * 그래서 UIhelper로 빼서 관리해서 실행시 불러서 사용하게 만든 부분
     **/
    public static void toolBarInitialize(AppCompatActivity activity, View view) {
        Toolbar toolbar = (Toolbar) view;
        activity.setSupportActionBar((toolbar));
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setDisplayShowTitleEnabled(false); // 제목 없애기
    }

    /**
     * 앱바 위에 보면 상태 표시줄이 있는데 상태표시줄을 없애는 코드
     **/
    public static void hideWindow(AppCompatActivity activity) {
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void navigationOnclick(AppCompatActivity  activity, View view){

        BottomNavigationView bottomNavigationView = (BottomNavigationView) view;
        Context context = activity.getApplicationContext();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Class clazz = null;

                switch (item.getItemId()){
                    case R.id.action_create :
                        clazz = UserCreateStudyActivity.class;
                        break;

                    case R.id.action_schedule :
                        clazz = PlannerActivity.class;
                        break;

                    case R.id.action_search :
                        clazz = NonGroupStudySearchActivity.class;
                        break;

                    case R.id.action_my :
                        clazz = UserActivity.class;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

                Intent intent = new Intent(context, clazz);
                activity.startActivity(intent);

                return true;
            }
        });
    }

    public static void dialogStart(Context context, String message, boolean flag,String id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        if(flag == false){
            // 확인버튼
            alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    GroupLeaderDetailService service = new GroupLeaderDetailService();
                    service.retrieveGroupLeaderManagementGroupMemberDelete(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.isSuccessful() == false){
                                Log.d("GroupMemberDelete", "Failed to register");
                            }else{

                                Log.d("body",response.body().toString()+"=-=-");
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {

                        }
                    },"1",id);
                }
            });

            // 취소버튼
            alertDialog.setNegativeButton("아니오", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        }
        // 메인 다이얼로그 생성
        AlertDialog alert = alertDialog.create();
        // 다이얼로그 보기
        alert.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });

        alert.show();
    }
    public static void dialogStart(Context context, String message, boolean flag) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        if(flag == true){
            // 확인버튼
            alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(context,NonGroupStudySearchActivity.class);
                    context.startActivity(intent);
                }
            });

    }

        // 메인 다이얼로그 생성
        AlertDialog alert = alertDialog.create();
        // 다이얼로그 보기
        alert.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });

        alert.show();
    }
}
