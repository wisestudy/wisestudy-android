package com.wisestudy.nongroup.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class NonGroupUserDetail extends AppCompatActivity {

    private MaterialButton nonGroupUserDetailApplyStudy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_group_member);

        UiHelper.hideWindow(this);
        Initialized();

        nonGroupUserDetailApplyStudy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                UiHelper.dialogStart(nonGroupUserDetailApplyStudy.getContext(), "신청 완료 되었습니다.", true);
            }
        });

    }

    private void Initialized() {
        nonGroupUserDetailApplyStudy = findViewById(R.id.nonGroupUserDetailApplyStudy);
    }
}
