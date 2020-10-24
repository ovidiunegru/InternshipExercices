package com.example.internshipexercices.JSON.server;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;


public class ServerProvider {
    public static final String URL= "https://jsonplaceholder.typicode.com/todos/";

    public static PostService createPostService(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return retrofit.create(PostService.class);
    }

    private static OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor httpLoggingInterceptor = getHttpLoggingInterceptor();

        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    private static HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    private ServerProvider(){
    }
}
