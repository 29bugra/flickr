package com.example.flickr.RestApi;

public class BaseManager {
    protected RestApi getRestApil()
    {

        RestApiClient restApiClient=new RestApiClient(BaseUrl.URL);
        return restApiClient.getRestApii();

    }
}