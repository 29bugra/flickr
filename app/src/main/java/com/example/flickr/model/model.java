package com.example.flickr.model;

import com.example.flickr.model.Photos;

public class model {

    public Photos photos;

    public String stat;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "model{" +
                "photos=" + photos +
                ", stat='" + stat + '\'' +
                '}';
    }
}



