package com.example.daggeradvanceconcepts.model;

import com.google.gson.annotations.SerializedName;

public class ThumbnailModle {


    @SerializedName("_type")
    private String contentType;

    @SerializedName("contentUrl")
    private String contentUrl;

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
