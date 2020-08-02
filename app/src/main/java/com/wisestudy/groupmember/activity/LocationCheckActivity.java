package com.wisestudy.groupmember.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.wisestudy.util.UiHelper;
import com.wisestudy.wisestudy.R;

import net.daum.mf.map.api.MapView;

public class LocationCheckActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupmember_detailscreen);


        UiHelper.toolBarInitialize(this, findViewById(R.id.groupMemberLocationToolbar));
        UiHelper.hideWindow(this);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.groupMemberLocationMap);
        mapViewContainer.addView(mapView);
    }
}
