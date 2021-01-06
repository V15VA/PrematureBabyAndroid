package com.example.prematurebabyandroid.APIs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class PatientAPIClient {
    private static Retrofit retrofit = null;
    private static Gson gson = null;

//    Defines the base URL, requests can be sent to pages on this URL
    private static final String BASE_URL = "https://premhealthbabyservlet.herokuapp.com/";

//    Creates a new Retrofit2 instance for handling POST and GET requests
    public static Retrofit getClient() {
//        For JSON file handling
        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
