package com.wisestudy.groupleader.module.adapter.fragmentadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wisestudy.groupleader.module.view.fragment.CreateStudyFragment1;
import com.wisestudy.groupleader.module.view.fragment.CreateStudyFragment2;
import com.wisestudy.groupleader.module.view.fragment.CreateStudyFragment3;

import java.util.ArrayList;
import java.util.List;

public class CreateStudyFragmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> createStudyFragmentList = new ArrayList<>();

    public CreateStudyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        createStudyFragmentList.add(new CreateStudyFragment1());
        createStudyFragmentList.add(new CreateStudyFragment2());
        createStudyFragmentList.add(new CreateStudyFragment3());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return createStudyFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return createStudyFragmentList.size();
    }
}
