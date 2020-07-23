package com.wisestudy.groupleader.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.wisestudy.groupleader.module.adapter.fragmentadapter.CreateStudyFragmentPagerAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

public class CreateStudyActivity extends AppCompatActivity {

    private ViewPager createStudyImageViewPager;
    private CreateStudyFragmentPagerAdapter createStudyFragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmanagement_createstudy);

        UiHelper.toolBarInitialize(this,findViewById(R.id.groupLeaderCreateStudyToolbar));
        UiHelper.hideWindow(this);

        Initialized();

    }

    private void Initialized() {

        // fragment + viewPager
        createStudyImageViewPager = findViewById(R.id.groupLeaderViewPager);
        createStudyFragmentPagerAdapter = new CreateStudyFragmentPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        createStudyImageViewPager.setAdapter(createStudyFragmentPagerAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.groupleader_createstudy_toolbar_item, menu);

        return true;
    }


}
