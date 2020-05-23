package com.study.wisestudy.MainPage;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.study.wisestudy.R;
import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    CircleImageView Iv; //이미지뷰
    TextView Dv;        //날짜텍스트
    TextView Tv;        //제목텍스트
    TextView Cv;        //내용텍스트
    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        Iv=itemView.findViewById(R.id.image_id);
        Dv=itemView.findViewById(R.id.date_id);
        Tv=itemView.findViewById(R.id.title_id);
        Cv=itemView.findViewById(R.id.contents_id);
    }
}
