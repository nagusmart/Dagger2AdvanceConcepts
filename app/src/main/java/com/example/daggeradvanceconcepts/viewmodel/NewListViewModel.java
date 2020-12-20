package com.example.daggeradvanceconcepts.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daggeradvanceconcepts.data.repository.NewsRepository;
import com.example.daggeradvanceconcepts.data.service.NewsApiServices;
import com.example.daggeradvanceconcepts.model.News;

import java.util.List;

import javax.inject.Inject;

public class NewListViewModel extends ViewModel {

    private NewsRepository newsRepository=null;

    private MutableLiveData<List<News>> newsList=new MutableLiveData<>();

    @Inject
    public NewListViewModel(NewsApiServices newsApiServices){
        newsRepository=new NewsRepository(newsApiServices);
        newsList=newsRepository.getNewsList();
    }

    public MutableLiveData<List<News>> getNewsList() {
        return newsList;
    }
}
