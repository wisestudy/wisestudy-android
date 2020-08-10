package com.wisestudy.groupleader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.planner.activity.PlannerActivity;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class GroupLeaderCreatePlannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmanagement_createstudy);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyToolbar));
        UiHelper.hideWindow(this);

        Initialized();

    }

    private void Initialized() {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.createStudy){
            Intent intent = new Intent(getApplicationContext(), PlannerActivity.class);
            startActivity(intent);
        }

        return true;
    }

}
