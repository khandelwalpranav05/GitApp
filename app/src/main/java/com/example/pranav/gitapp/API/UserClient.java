package com.example.pranav.gitapp.API;

import com.example.pranav.gitapp.Model.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Pranav on 20-08-2017.
 */

public interface UserClient {

    @GET("search/users")
    Call<UserList> getUserList(@Query("q") String order);
}
