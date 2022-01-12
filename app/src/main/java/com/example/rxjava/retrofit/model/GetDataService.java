package com.example.rxjava.retrofit.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {


    @GET("/posts")
    Call<List<Posts>> getAllPost();

}
