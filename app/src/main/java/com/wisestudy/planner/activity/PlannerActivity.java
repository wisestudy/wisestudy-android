package com.wisestudy.planner.activity;

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
import com.wisestudy.planner.vo.plannerVO;
//import com.google.android.material.navigation.NavigationView;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlannerActivity extends AppCompatActivity  {

    private ArrayList<plannerVO> recyclerDataList;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
//    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private ExpandableListView expandableListView;
//    private NavigationDrawerPageExpandListviewAdapter expandListviewAdapter;
    private ArrayList<String> joinedGroup = new ArrayList<>();
    private Map<String,ArrayList<String>> joinedGroupChild = new HashMap<>();

    private View navigationHeader;
    private ImageButton drawerNavigationClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner);

        toolbar = findViewById(R.id.toolBarId);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);


        drawerLayout = findViewById(R.id.mainPageId);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        expandableListView = findViewById(R.id.joinedGroupListId);
//        navigationView = findViewById(R.id.navigationviewId);
//        navigationHeader = navigationView.getHeaderView(0);
        drawerNavigationClose = navigationHeader.findViewById(R.id.navigationviewCloseId);
        drawerNavigationClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        joinedData();

        this.InitializeData();
        recyclerView = findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new RecyclerViewAdapter(recyclerDataList));


    }

    private void joinedData(){

        ArrayList<String> joinedList = new ArrayList<>();

        joinedGroup.add("������ �׷�");


        joinedList.add("���α׶���");
        joinedList.add("SCH");

        joinedGroupChild.put(joinedGroup.get(0),joinedList);
//        expandListviewAdapter = new NavigationDrawerPageExpandListviewAdapter(joinedGroup,joinedGroupChild,this);
//        expandableListView.setAdapter(expandListviewAdapter);

    }
    private void InitializeData() {
        recyclerDataList = new ArrayList<>();
        recyclerDataList.add(new plannerVO(R.color.colorAccent,"7��","�Ⱦ� Ŀ�Ǻ�","���� 2��"));
        recyclerDataList.add(new plannerVO(R.color.colorPrimary,"14��","�Ⱦ� ���͵���","���� 1��"));
        recyclerDataList.add(new plannerVO(R.color.colorPrimaryDark,"21��","���� Ŀ�Ǻ�","���� 3��"));
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
                //ModifyProfile Intent
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