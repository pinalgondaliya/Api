package com.oscar.career.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.oscar.career.myapplication.api.ApiMethods;
import com.oscar.career.myapplication.api.MyApiResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    /*
     *  path, query parameter
     *
     * */

    ApiMethods a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit r = new Retrofit.Builder().baseUrl("https://saloon.mycodelibraries.com/api/").addConverterFactory(GsonConverterFactory.create()).build();
        a = r.create(ApiMethods.class);


    }

    public void getUserData(View view) {

        String t = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJZCI6IjIiLCJVc2VyTmFtZSI6InJ1dHZpayIsIlJvbGVJZCI6IjMiLCJSb2xlIjoiVXNlciIsIm5iZiI6MTYzMTMzMDAyOSwiZXhwIjoxNjMxNDE2NDI5LCJpYXQiOjE2MzEzMzAwMjksImlzcyI6Imh0dHBzOi8vc2Fsb29uLm15Y29kZWxpYnJhcmllcy5jb20iLCJhdWQiOiJodHRwczovL3NhbG9vbi5teWNvZGVsaWJyYXJpZXMuY29tIn0.re1CQSwFvhhNwJiFrHDQ_oX6BA3hzFuxex9ix6RQZ00";

        Call<List<MyApiResponce>> data = a.getData(t);
        data.enqueue(new Callback<List<MyApiResponce>>() {
            @Override
            public void onResponse(Call<List<MyApiResponce>> call, Response<List<MyApiResponce>> response) {

                if (response.isSuccessful()) {

                    switch (response.code()) {

                        case 200:
                            List<MyApiResponce> myData = response.body();
                            Log.d("TAG", "onResponse: "+myData.size());
                            break;
                        case 401:
                            break;
                        case 400:
                            break;
                        case 500:
                            break;

                    }

                }

            }

            @Override
            public void onFailure(Call<List<MyApiResponce>> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });

    }
}