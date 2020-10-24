package com.example.internshipexercices.JSON.DownloadImageUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class ServiceProvider {
    public static OkHttpClient okHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    public ServiceProvider() {
    }
}