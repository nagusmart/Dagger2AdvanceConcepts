package com.example.daggeradvanceconcepts.model;

import com.google.gson.annotations.SerializedName;

public class ImageModel {

    @SerializedName("thumbnail")
    private ThumbnailModle thumbnailModle;

    public ThumbnailModle getThumbnailModle() {
        return thumbnailModle;
    }

    public void setThumbnailModle(ThumbnailModle thumbnailModle) {
        this.thumbnailModle = thumbnailModle;
    }


}
