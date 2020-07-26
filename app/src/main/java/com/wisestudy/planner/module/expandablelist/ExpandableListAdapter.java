package com.wisestudy.planner.module.expandablelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.wisestudy.wisestudy.R;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private List<String> expandableListJoinedGroup;
    private Map<String,ArrayList<String>> expandableListJoinedGroupChild;
    private Context expandableListContext;
    private String expandableListJoinedGroupTitle;
    private TextView expandableListJoinedGroupTextview;
    private String expandableListJoinedGroupChildTitle;
    private TextView expandableListJoinedGroupChildTextview;

    public ExpandableListAdapter(ArrayList<String> joinedGoup, Map<String, ArrayList<String>> joinedGroupChild, Context expandableContext) {
        this.expandableListJoinedGroup = joinedGoup;
        this.expandableListJoinedGroupChild = joinedGroupChild;
        this.expandableListContext = expandableContext;
    }

    @Override
    public int getGroupCount() {
        return expandableListJoinedGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return expandableListJoinedGroupChild.get(expandableListJoinedGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return expandableListJoinedGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return expandableListJoinedGroupChild.get(expandableListJoinedGroup.get(groupPosition)).get(childPosition);
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
        expandableListJoinedGroupTitle = (String)getGroup(groupPosition);
        convertView = LayoutInflater.from(expandableListContext).inflate(R.layout.activity_calendarpage_navigationdrawer_joinedgroup,null);
        expandableListJoinedGroupTextview = convertView.findViewById(R.id.joinedGroupHeaderId);
        expandableListJoinedGroupTextview.setText(expandableListJoinedGroupTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        expandableListJoinedGroupChildTitle = (String)getChild(groupPosition,childPosition);
        convertView = LayoutInflater.from(expandableListContext).inflate(R.layout.activity_calendarpage_navigationdrawer_joinedgroupchild,null);
        expandableListJoinedGroupChildTextview = convertView.findViewById(R.id.joinedGroupChildId);
        expandableListJoinedGroupChildTextview.setText(expandableListJoinedGroupChildTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}