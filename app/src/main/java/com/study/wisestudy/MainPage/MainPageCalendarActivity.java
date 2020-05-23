package com.study.wisestudy.MainPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.wisestudy.R;

import java.util.ArrayList;

public class MainPageCalendarActivity extends AppCompatActivity {
    ImageView menu_img;
    private ArrayList<RecyclerViewData> Recycler_DataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calenda_page);
        menu_img=(ImageView)findViewById(R.id.menu_id);
        this.InitializeData();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_id);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(Recycler_DataList));

        menu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainPageMenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void InitializeData() {
        Recycler_DataList=new ArrayList<>();
        Recycler_DataList.add(new RecyclerViewData(R.color.colorAccent,"7일","안양 커피빈","오후 2시"));
        Recycler_DataList.add(new RecyclerViewData(R.color.colorPrimary,"14일","안양 스터디룸","오후 1시"));
        Recycler_DataList.add(new RecyclerViewData(R.color.colorPrimaryDark,"21일","범계 커피빈","오후 3시"));
    }
}
