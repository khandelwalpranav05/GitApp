package com.example.pranav.gitapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Pranav on 20-08-2017.
 */

public class Users {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar;

    @SerializedName("id")
    @Expose
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getLogin() {
        return login;
    }
}
