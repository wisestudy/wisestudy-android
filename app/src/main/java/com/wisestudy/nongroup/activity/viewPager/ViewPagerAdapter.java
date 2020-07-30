package com.wisestudy.nongroup.activity.viewPager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.wisestudy.wisestudy.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> items=new ArrayList<>();

    public ViewPagerAdapter(@Nullable FragmentManager fm, int Behavior){
        super(fm,Behavior);
        items.add(new FirstFragment());
        items.add(new SecondFragment());
        items.add(new ThirdFragment());
    }

    @Nullable
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }


}
