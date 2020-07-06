package com.rajendra.courseapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.courseapp.CourseDetails;
import com.rajendra.courseapp.R;
import com.rajendra.courseapp.model.PopularCourse;

import java.util.List;

public class PopularCourseAdapter extends RecyclerView.Adapter<PopularCourseAdapter.PopulatViewHolder> {

        Context context;
        List<PopularCourse> popularCourseList;

    public PopularCourseAdapter(Context context, List<PopularCourse> popularCourseList) {
        this.context = context;
        this.popularCourseList = popularCourseList;
    }

    @NonNull
    @Override
    public PopulatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_row_item, parent, false);

        //here we need to create a row item layout file
        return new PopulatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopulatViewHolder holder, int position) {

        //here we will bind data to our layout

        holder.courseName.setText(popularCourseList.get(position).getName());
        holder.totalLessons.setText(popularCourseList.get(position).getTotalLesson());

        // setting up image using GLIDE

        Glide.with(context).load(popularCourseList.get(position).getImageUrl()).into(holder.courseImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context, CourseDetails.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(holder.courseImage, "image");
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity)context, pairs);

                context.startActivity(i, activityOptions.toBundle());

            }
        });


    }

    @Override
    public int getItemCount() {
        return popularCourseList.size();
    }

    public  static class PopulatViewHolder extends RecyclerView.ViewHolder{


        ImageView courseImage;
        TextView courseName, totalLessons;

        public PopulatViewHolder(@NonNull View itemView) {
            super(itemView);

            courseImage = itemView.findViewById(R.id.course_image);
            courseName = itemView.findViewById(R.id.lesson_name);
            totalLessons = itemView.findViewById(R.id.total_lesson);

        }
    }




}
