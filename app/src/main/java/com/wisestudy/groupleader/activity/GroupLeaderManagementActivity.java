package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.user.activity.UserCreateStudyActivity;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupLeaderManagementActivity extends AppCompatActivity {

    private MaterialButton managementModifyGroup;
    private MaterialButton managementCollectGroupMember;
    private MaterialButton manageCurrentApply;
    private MaterialButton managementGroupMember;
    private MaterialButton managementDeleteGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmanagement);

        UiHelper.toolBarInitialize(this, findViewById(R.id.managementToolbar));
        UiHelper.hideWindow(this);

        Initialized();
    }

    private void Initialized() {

        findViewById(R.id.managementCollectGroupMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserCreateStudyActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.manageCurrentApply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupLeaderPresentApplicationActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.managementGroupMember).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupLeaderManagementGroupMember.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.managementDeleteGroup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 스터디 삭제
                 */
            }
        });
    }
}
