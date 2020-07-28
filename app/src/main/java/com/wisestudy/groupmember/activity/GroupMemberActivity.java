package com.wisestudy.groupmember.activity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupMemberActivity extends AppCompatActivity {
    private ViewPager GroupMemberViewPager;
    private TabLayout GroupMemberTabDot;
    private TextView groupMemberGroupName;
    private TextView groupMemberGroupLeader;
    private TextView groupMemberCategory;
    private TextView groupMemberTotalMember;
    private TextView groupMemberRecruitment;
    private TextView groupMemberLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmember_detailscreen);

        GroupMemberViewPager = findViewById(R.id.groupMemberDetailScreenImage);
        GroupMemberTabDot = findViewById(R.id.groupMemberDetailScreenTabDots);
        UiHelper.toolBarInitialize(this, findViewById(R.id.groupMemberDetailScreenTitle));
        UiHelper.hideWindow(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_group_leave,menu);

        return true;
    }
}
