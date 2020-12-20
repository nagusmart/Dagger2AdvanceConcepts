package com.example.daggeradvanceconcepts.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {


    @SerializedName("_type")
    private String type;

    @SerializedName("value")
    private List<News> newsList;

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
