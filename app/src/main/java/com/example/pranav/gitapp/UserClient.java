package com.example.pranav.gitapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Pranav on 20-08-2017.
 */

public interface UserClient {

    @GET("search/users?q=pranav")
    Call<ArrayList<Users>> getUserList();
}
