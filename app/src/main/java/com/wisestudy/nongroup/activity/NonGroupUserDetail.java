package com.wisestudy.nongroup.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class NonGroupUserDetail extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_group_member);

        UiHelper.hideWindow(this);
    }
}
