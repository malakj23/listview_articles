package com.example.user.test.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 02/04/2018.
 */

public class ConfigRetrofit {

    public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.1.6:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
