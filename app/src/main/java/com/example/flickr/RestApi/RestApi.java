package com.example.flickr.RestApi;





import com.example.flickr.model.model;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RestApi {


    @GET("services/rest/?method=flickr.photos.getRecent&api_key=9e797d1607207866847745de08a4a88f&per_page=20&format=json&nojsoncallback=1")
    Call<model> veriGetir();



}