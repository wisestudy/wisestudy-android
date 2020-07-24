package com.wisestudy.nongroup.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.wisestudy.planner.viewPager.ViewPagerAdapter;
import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class NonGruopActivity extends AppCompatActivity {

    private ArrayList<Integer> imageList;
    private static final int DP=24;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_group_member);

        this.initializeData();
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);
        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.non_group_indicator);
        indicator.setViewPager(viewPager);
        UiHelper.toolBarInitialize(this, findViewById(R.id.nonGruopToolbar));
        UiHelper.hideWindow(this);
    }

    private void initializeData() {
        imageList = new ArrayList();
        imageList.add(R.drawable.kakao_default_profile_image);
        imageList.add(R.drawable.kakao_default_profile_image);
        imageList.add(R.drawable.kakao_default_profile_image);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.non_group_menu_toolbar_button, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }

            case R.id.toolbar_apply_button: {
                AlertDialog.Builder dig = new AlertDialog.Builder(NonGruopActivity.this);
                dig.setTitle("신청");
                dig.setMessage("신청 되었습니다.");
                dig.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dig.show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
