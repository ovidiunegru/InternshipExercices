package com.example.internshipexercices.JSON.server;

import com.example.internshipexercices.JSON.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
