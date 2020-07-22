package com.wisestudy.util;

import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class UiHelper  {

    /**
     앱바를 사용하려면 activity 마다 같은 코드를 반복적으로 사용해야함
     그래서 UIhelper로 빼서 관리해서 실행시 불러서 사용하게 만든 부분
     **/
    public static void toolBarInitialize(AppCompatActivity activity, View view){
        Toolbar toolbar = (Toolbar) view;
        activity.setSupportActionBar((toolbar));
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setDisplayShowTitleEnabled(false); // 제목 없애기
    }

    /**
      앱바를 사용하면 아래에 그림자가 생기게 되는데 그런 그림자 제거를 위해 만듬
     **/
    public static void hideWindow(AppCompatActivity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
