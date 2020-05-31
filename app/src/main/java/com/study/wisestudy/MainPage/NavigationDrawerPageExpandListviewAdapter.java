package com.study.wisestudy.MainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.study.wisestudy.R;

import java.util.ArrayList;
import java.util.Map;

public class NavigationDrawerPageExpandListviewAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> joinedGroup;
    private Map<String,ArrayList<String>> joinedGroupChild;
    private Context expandableContext;
    private String joinedGroupTitle;
    private TextView joinedGroupTextview;
    private String joinedGroupChildTitle;
    private TextView joinedGroupChildTextview;

    public NavigationDrawerPageExpandListviewAdapter(ArrayList<String> joinedGoup, Map<String, ArrayList<String>> joinedGroupChild, Context expandableContext) {
        this.joinedGroup = joinedGoup;
        this.joinedGroupChild = joinedGroupChild;
        this.expandableContext = expandableContext;
    }

    @Override
    public int getGroupCount() {
        return joinedGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return joinedGroupChild.get(joinedGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return joinedGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return joinedGroupChild.get(joinedGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        joinedGroupTitle = (String)getGroup(groupPosition);
        convertView = LayoutInflater.from(expandableContext).inflate(R.layout.activity_calendarpage_navigationdrawer_joinedgroup,null);
        joinedGroupTextview = convertView.findViewById(R.id.joinedGroupHeaderId);
        joinedGroupTextview.setText(joinedGroupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        joinedGroupChildTitle = (String)getChild(groupPosition,childPosition);
        convertView = LayoutInflater.from(expandableContext).inflate(R.layout.activity_calendarpage_navigationdrawer_joinedgroupchild,null);
        joinedGroupChildTextview = convertView.findViewById(R.id.joinedGroupChildId);
        joinedGroupChildTextview.setText(joinedGroupChildTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
