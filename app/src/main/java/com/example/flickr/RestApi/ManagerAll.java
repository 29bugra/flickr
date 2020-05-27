package com.example.flickr.RestApi;





import com.example.flickr.model.model;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance= new ManagerAll();
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;


    }

    public Call<model> veri()
    {
        Call<model> x= getRestApil().veriGetir();
        return  x;

    }

}
