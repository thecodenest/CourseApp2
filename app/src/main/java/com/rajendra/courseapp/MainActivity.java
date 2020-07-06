package com.rajendra.courseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rajendra.courseapp.adapter.CourseForYouAdapter;
import com.rajendra.courseapp.adapter.PopularCourseAdapter;
import com.rajendra.courseapp.model.CourseData;
import com.rajendra.courseapp.model.CourseForYou;
import com.rajendra.courseapp.model.PopularCourse;
import com.rajendra.courseapp.retrofit.ApiInterface;
import com.rajendra.courseapp.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    RecyclerView popularRecycler, courseForYouRecycler;
    PopularCourseAdapter popularCourseAdapter;

    CourseForYouAdapter courseForYouAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<List<CourseData>> call = apiInterface.getAllCourses();

        call.enqueue(new Callback<List<CourseData>>() {
            @Override
            public void onResponse(Call<List<CourseData>> call, Response<List<CourseData>> response) {

                List<CourseData> courseDataList = response.body();

                setPopularRecycler(courseDataList.get(0).getPopularCourses());

                setCourseForYouRecycler(courseDataList.get(0).getCourseForYou());

            }



            @Override
            public void onFailure(Call<List<CourseData>> call, Throwable t) {

            }
        });


    }

    private void setPopularRecycler(List<PopularCourse> popularCourseList){

        popularRecycler = findViewById(R.id.popular_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecycler.setLayoutManager(layoutManager);
        popularCourseAdapter = new PopularCourseAdapter(this, popularCourseList);
        popularRecycler.setAdapter(popularCourseAdapter);

    }

    private void setCourseForYouRecycler(List<CourseForYou> courseForYouList){

        courseForYouRecycler = findViewById(R.id.course_for_you);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        courseForYouRecycler.setLayoutManager(layoutManager);
        courseForYouAdapter = new CourseForYouAdapter(this, courseForYouList);
        courseForYouRecycler.setAdapter(courseForYouAdapter);

    }
}

// Hello all as yoy know today we are going to build a course app which play learning videos.
// so we have two section in this 1 is popular and second is for you.
// so lets have a look on json data.
// so firts we will make  a model class for our data.
// so our model class is ready.
// lets add retrofit dependency for network call and Glide dependency for image feching from server
// lets start design.
// Now first we will setup retrofit for feching data from server.
// now we will setup a adapter class for popular courses
// Adapter is done.
//lets run it and check are we getting data from server?
// here you can see that we are getting data from server.
// here you can see that we have successfully setup popular section
// we will do same thing for next section
// so lets do it fast.
// we have setup both recycler data
// Now move to the next part set onclicklistener on recyclerview item
// Now we will design course detail page
// Now we need to set recyclerview adapter same as we have done earliar
// lets have look on model class
// now we setup a onlick on video lesson and open a video player.
// so u can see that video is playing
// see you in the next video.
// hi i forgot 1 things lets add some ui transition so that design looks cool
// i have added beautiful activity transition
// see you in the next video