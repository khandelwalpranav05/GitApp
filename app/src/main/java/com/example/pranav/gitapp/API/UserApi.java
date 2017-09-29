package com.example.pranav.gitapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pranav on 20-08-2017.
 */

public class UserApi {

    public UserClient getUserListGET()
    {
        String BASE_URL = "https://api.github.com";

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(UserClient.class);
    }
}
