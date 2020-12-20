package com.example.daggeradvanceconcepts.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.daggeradvanceconcepts.data.service.NewsApiServices;
import com.example.daggeradvanceconcepts.model.DataResponse;
import com.example.daggeradvanceconcepts.model.News;

import java.util.List;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class NewsRepository {

    private NewsApiServices newsApiServices;

    public NewsRepository(NewsApiServices newsApiServices) {
        this.newsApiServices = newsApiServices;
    }

    public MutableLiveData<List<News>> getNewsList() {

        final MutableLiveData<List<News>> newsList = new MutableLiveData<>();

        newsApiServices.getNewsList().enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {


                if (response.body().getNewsList() != null) {

                    newsList.setValue(response.body().getNewsList());

                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });

        return newsList;
    }
}
