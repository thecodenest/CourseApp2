package com.rajendra.courseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.courseapp.R;
import com.rajendra.courseapp.VideoPlayer;
import com.rajendra.courseapp.model.VideoLession;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {


    Context context;
    List<VideoLession> videoLessionList;

    public LessonAdapter(Context context, List<VideoLession> videoLessionList) {
        this.context = context;
        this.videoLessionList = videoLessionList;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.lesson_row_item, parent, false);

        //here we need to create a row item layout file
        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, final int position) {

        //here we will bind data to our layout

        holder.lessonName.setText(videoLessionList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, VideoPlayer.class);
                i.putExtra("url", videoLessionList.get(position).getVideoUrl());
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return videoLessionList.size();
    }

    public  static class LessonViewHolder extends RecyclerView.ViewHolder{



        TextView lessonName;

        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);


            lessonName = itemView.findViewById(R.id.lesson_name);

        }
    }



}
