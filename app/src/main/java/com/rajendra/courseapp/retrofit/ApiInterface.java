package com.rajendra.courseapp.retrofit;

import com.rajendra.courseapp.model.CourseData;
import com.rajendra.courseapp.model.CourseDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("coursedata.json")
    Call<List<CourseData>> getAllCourses();

    @GET("video_lession.json")
    Call<List<CourseDetail>> getAllLesson();

}
