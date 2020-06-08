package com.wisestudy.planner.module.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wisestudy.wisestudy.R;
//import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
//    CircleImageView imageView;
    TextView dateView;
    TextView titleView;
    TextView contensView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

//        imageView = itemView.findViewById(R.id.imageId);
//        dateView = itemView.findViewById(R.id.dateId);
//        titleView = itemView.findViewById(R.id.titleId);
//        contensView = itemView.findViewById(R.id.contentsId);
    }
}
