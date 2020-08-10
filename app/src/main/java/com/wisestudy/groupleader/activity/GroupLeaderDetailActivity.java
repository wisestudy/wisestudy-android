package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.wisestudy.planner.activity.PlannerActivity;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupLeaderDetailActivity extends AppCompatActivity {
    private MaterialButton createStudy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupleader_detail);

        UiHelper.toolBarInitialize(this, findViewById(R.id.groupLeaderDetailToolBar));
        UiHelper.hideWindow(this);

        createStudy = findViewById(R.id.groupLeaderDetailCreateStudy);
        createStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GroupLeaderCreatePlannerActivity.class);
                startActivity(intent);
            }
        });
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
