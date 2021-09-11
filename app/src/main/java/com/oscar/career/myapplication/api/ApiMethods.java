package com.oscar.career.myapplication.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiMethods {

    @GET("api/User/10")
    Call<List<MyApiResponce>> getData(@Header("authorization") String token);


}
