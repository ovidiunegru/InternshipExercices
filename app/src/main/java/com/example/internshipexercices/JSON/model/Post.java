package com.example.internshipexercices.JSON.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")   //the same in the json format
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;


}
