package com.wisestudy.nongroup.activity.module.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.wisestudy.wisestudy.R;

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

    public TextView getTextName() {
        return textName;
    }

    public void setTextName(TextView textName) {
        this.textName = textName;
    }

    public TextView getTextField() {
        return textField;
    }

    public void setTextField(TextView textField) {
        this.textField = textField;
    }

    public TextView getTextNumber() {
        return textNumber;
    }

    public void setTextNumber(TextView textNumber) {
        this.textNumber = textNumber;
    }
}
