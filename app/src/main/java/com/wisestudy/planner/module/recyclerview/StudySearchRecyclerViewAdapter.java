package com.wisestudy.planner.module.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.wisestudy.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StudySearchRecyclerViewAdapter extends RecyclerView.Adapter<StudySearchRecyclerViewAdapter.ViewHolder> {

    private String[] name;
    private String[] field;
    private String[] number;
    private LayoutInflater layoutInflater;

    public StudySearchRecyclerViewAdapter(Context context, String[] name, String[] field, String[] number){
        this.layoutInflater=LayoutInflater.from(context);
        this.name=name;
        this.field=field;
        this.number=number;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.activity_study_search_recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textName.setText(name[position]);
        holder.textField.setText(field[position]);
        holder.textNumber.setText(number[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textField;
        private TextView textNumber;
        public ViewHolder(View itemView) {
            super(itemView);
            textName=itemView.findViewById(R.id.study_name_text);
            textField=itemView.findViewById(R.id.field_text);
            textNumber=itemView.findViewById(R.id.number_text);
        }
    }
}

