package com.study.wisestudy.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.wisestudy.R;

import java.util.ArrayList;

public class MainPageCalendarActivity extends AppCompatActivity {
    private ImageView menuImg;
    private ArrayList<RecyclerViewData> recyclerDataList;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendarpage);
        menuImg=findViewById(R.id.menuId);
        this.InitializeData();
        recyclerView=findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(recyclerDataList));

        menuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainPageMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InitializeData() {
        recyclerDataList=new ArrayList<>();
        recyclerDataList.add(new RecyclerViewData(R.color.colorAccent,"7일","안양 커피빈","오후 2시"));
        recyclerDataList.add(new RecyclerViewData(R.color.colorPrimary,"14일","안양 스터디룸","오후 1시"));
        recyclerDataList.add(new RecyclerViewData(R.color.colorPrimaryDark,"21일","범계 커피빈","오후 3시"));
    }
}
