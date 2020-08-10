package com.wisestudy.planner.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class PlannerDetailActivity extends AppCompatActivity {

    private MaterialButton movePlannerLocationClass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_detail);

        UiHelper.toolBarInitialize(this, findViewById(R.id.plannerDetailToolBar));
        UiHelper.hideWindow(this);

        Initialized();
        movePlannerLocationClass.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PlannerMemberLocationActivity.class);
            startActivity(intent);
        });

    }

    private void Initialized() {
        movePlannerLocationClass = findViewById(R.id.plannerSearchMemberLocation);
    }
}
