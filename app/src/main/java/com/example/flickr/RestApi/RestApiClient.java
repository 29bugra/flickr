package com.example.flickr.RestApi;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    private RestApi mRestApi;
    public RestApiClient(String restApiSerciceUrl)
    {
        OkHttpClient.Builder builder=new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(3,TimeUnit.SECONDS);
        OkHttpClient okHttpClient=builder.build();
        Gson gson=new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(restApiSerciceUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRestApi=retrofit.create(RestApi.class);

    }
    public RestApi getRestApii(){

        return mRestApi;
    }
}

