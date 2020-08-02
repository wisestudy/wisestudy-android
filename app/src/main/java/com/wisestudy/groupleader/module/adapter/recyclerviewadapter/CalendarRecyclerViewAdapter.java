package com.wisestudy.groupleader.module.adapter.recyclerviewadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.groupleader.domain.CalendarModifyVO;
import com.wisestudy.wisestudy.R;

import java.util.List;

public class CalendarRecyclerViewAdapter extends RecyclerView.Adapter<CalendarRecyclerViewAdapter.MyViewHodler> {

    private List<CalendarModifyVO> list;

    public CalendarRecyclerViewAdapter(List<CalendarModifyVO> data) {
        list = data;
    }

    @NonNull
    @Override
    public MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendarmoddify_recyclerview_item,parent,false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodler holder, int position) {
        holder.calenderModifyImageView.setImageDrawable(list.get(position).getImage());
        holder.calenderModifyDay.setText(Integer.toString(list.get(position).getDay()));
        holder.calenderModifyLocation.setText(list.get(position).getLocation());
        holder.calenderModifyName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHodler extends RecyclerView.ViewHolder {
        private ImageView calenderModifyImageView;
        private TextView calenderModifyDay;
        private TextView calenderModifyLocation;
        private TextView calenderModifyName;

        public MyViewHodler(@NonNull View itemView) {
            super(itemView);
            calenderModifyImageView = itemView.findViewById(R.id.calendarModifyRecyclerViewImage);
            calenderModifyDay = itemView.findViewById(R.id.calendarModifyRecyclerViewDay);
            calenderModifyLocation = itemView.findViewById(R.id.calendarModifyRecyclerViewLocation);
            calenderModifyName = itemView.findViewById(R.id.calendarModifyRecyclerViewStudyName);
        }
    }
}
