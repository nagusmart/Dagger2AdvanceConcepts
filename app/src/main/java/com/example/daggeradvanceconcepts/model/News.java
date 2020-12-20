package com.example.daggeradvanceconcepts.model;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private ImageModel images;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageModel getImages() {
        return images;
    }

    public void setImages(ImageModel images) {
        this.images = images;
    }

}
