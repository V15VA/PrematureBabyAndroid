package com.example.prematurebabyandroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientController {
    static final String BASE_URL = "https://premhealthbabyservlet.herokuapp.com/";

    public void Start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        PatientAPI patientAPI = retrofit.create(PatientAPI.class);

//        Call<ComTest> call = patientAPI.testPost("test");
        Call<ComTest> call = patientAPI.testGet();
        call.enqueue(new Callback<ComTest>() {
            @Override
            public void onResponse(Call<ComTest> call, Response<ComTest> response) {
                if (response.isSuccessful()) {
                    System.out.println("SUCCESS");
                    System.out.println(response.body());

                    ComTest comTest = response.body();
                    System.out.println(comTest.getPatientID());
                    System.out.println(comTest.getDataRequested());
                }
                else {
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("RESPONSE FAIL");
                }
            }

            @Override
            public void onFailure(Call<ComTest> call, Throwable t) {
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });
    }

}
