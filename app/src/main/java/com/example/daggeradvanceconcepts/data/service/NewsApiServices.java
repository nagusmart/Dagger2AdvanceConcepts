package com.example.daggeradvanceconcepts.data.service;

import com.example.daggeradvanceconcepts.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApiServices {

//    @Headers({
//            "x-rapidapi-key: d907e1b81emsha76b037e3a900d3p1d3acdjsne0ae42884ddf"
//    })
    @GET("news/")
    Call<DataResponse> getNewsList();

}
