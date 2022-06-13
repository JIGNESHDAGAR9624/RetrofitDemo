package com.example.retrofitandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface Apiinterface {


@GET("/posts")
    Call<List<posts>> getposts();
}
