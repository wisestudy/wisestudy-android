package com.wisestudy.planner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.planner.module.recyclerview.RecyclerViewAdapter;
import com.google.android.material.navigation.NavigationView;
import com.wisestudy.planner.module.expandablelist.ExpandableListAdapter;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.activity.UserActivity;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlannerActivity extends AppCompatActivity  {

    private List<PlannerVO> recyclerDataList;

    private RecyclerView recyclerView;
    private LinearLayoutManager manager;


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> expandableListJoinedGroup = new ArrayList<>();
    private Map<String,ArrayList<String>> expandableListJoinedGroupChild = new HashMap<>();

    private View navigationHeader;
    private ImageButton drawerNavigationClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        toolbar = findViewById(R.id.plannerToolBarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.calendar_toolbar_menu);


        drawerLayout = findViewById(R.id.mainPageId);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        expandableListView = findViewById(R.id.joinedGroupListId);
        navigationView = findViewById(R.id.navigationviewId);
        navigationHeader = navigationView.getHeaderView(0);
        drawerNavigationClose = navigationHeader.findViewById(R.id.navigationviewCloseId);
        drawerNavigationClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        joinedData();

        this.InitializeData();
        recyclerView = findViewById(R.id.plannerRecyclerId);

        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(recyclerDataList));



    }

    private void joinedData(){

        List<String> joinedList = new ArrayList<>();

        expandableListJoinedGroup.add("가입한 그룹");


        joinedList.add("프로그라피");
        joinedList.add("SCH");

        expandableListJoinedGroupChild.put(expandableListJoinedGroup.get(0), (ArrayList<String>) joinedList);
        expandableListAdapter = new ExpandableListAdapter((ArrayList<String>) expandableListJoinedGroup,expandableListJoinedGroupChild,this);
        expandableListView.setAdapter(expandableListAdapter);

    }
    private void InitializeData() {
        recyclerDataList = new ArrayList<>();
        recyclerDataList.add(new PlannerVO(R.color.colorAccent,"7일","안양 커피빈","오후 2시"));
        recyclerDataList.add(new PlannerVO(R.color.colorPrimary,"14일","안양 스터디룸","오후 1시"));
        recyclerDataList.add(new PlannerVO(R.color.colorPrimaryDark,"21일","범계 커피빈","오후 3시"));
    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START))
       {
           drawerLayout.closeDrawer(GravityCompat.START);
       }
       else {
           super.onBackPressed();
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch(item.getItemId()){
            case R.id.appbarProfile :
                Intent profileIntent = new Intent(getApplication(), UserActivity.class);
                startActivity(profileIntent);
                return true;
            case R.id.appbarSearchId :
                //SearchActivity Intent
                return true;
            case R.id.appbarAddGroup :
                //AddGroupActivity Intent
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

}