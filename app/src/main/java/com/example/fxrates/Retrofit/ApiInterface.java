package com.example.fxrates.Retrofit;

import com.example.fxrates.PostList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("e210db9bed13bada22f86f91/latest/EUR")
    Call<PostList> getCurrency();

}
