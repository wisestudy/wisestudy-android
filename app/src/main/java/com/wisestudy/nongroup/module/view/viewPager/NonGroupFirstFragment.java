package com.wisestudy.nongroup.activity.viewPager;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wisestudy.wisestudy.R;

public class NonGroupFirstFragment extends Fragment {

    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_non_group_fragment_one,viewGroup,false);
        return view;
    }
}
