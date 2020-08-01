package com.wisestudy.nongroup.activity.viewPager;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<Fragment> items=new ArrayList<>();

    public ViewPagerAdapter(@Nullable FragmentManager fm, int Behavior){
        super(fm,Behavior);
        items.add(new NonGroupFirstFragment());
        items.add(new NonGroupSecondFragment());
        items.add(new NonGroupThirdFragment());
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
