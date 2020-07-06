package com.rajendra.courseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rajendra.courseapp.adapter.LessonAdapter;
import com.rajendra.courseapp.adapter.PopularCourseAdapter;
import com.rajendra.courseapp.model.CourseData;
import com.rajendra.courseapp.model.CourseDetail;
import com.rajendra.courseapp.model.PopularCourse;
import com.rajendra.courseapp.model.VideoLession;
import com.rajendra.courseapp.retrofit.ApiInterface;
import com.rajendra.courseapp.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseDetails extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView lessonRecycler;
    LessonAdapter lessonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);



        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<CourseDetail>> call = apiInterface.getAllLesson();

        call.enqueue(new Callback<List<CourseDetail>>() {
            @Override
            public void onResponse(Call<List<CourseDetail>> call, Response<List<CourseDetail>> response) {

                List<CourseDetail> courseDataList = response.body();

                setLessonList(courseDataList.get(0).getVideoLession());

            }



            @Override
            public void onFailure(Call<List<CourseDetail>> call, Throwable t) {

            }
        });


    }

    private void setLessonList(List<VideoLession> videoLessionList){

        lessonRecycler = findViewById(R.id.lesson_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lessonRecycler.setLayoutManager(layoutManager);
        lessonAdapter = new LessonAdapter(this, videoLessionList);
        lessonRecycler.setAdapter(lessonAdapter);

    }
}
