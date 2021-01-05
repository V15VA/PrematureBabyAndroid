package com.example.prematurebabyandroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.sql.Time;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OLD_PatientController {
    static final String BASE_URL = "https://premhealthbabyservlet.herokuapp.com/";
//    static final String BASE_URL = "https://prenatal.herokuapp.com/";

    public void Start(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OLD_PatientAPI OLDPatientAPI = retrofit.create(OLD_PatientAPI.class);

        OLD_Request testOLDRequest = new OLD_Request();
//        testRequest.setPatientID("hmmm");
//        testRequest.setDataRequested("nope");
        testOLDRequest.setType("EditClinician");
        testOLDRequest.setPatientID("2342");
//        Time time = new Time(8, 13, 0);
        testOLDRequest.setTime(Time.valueOf("08:16:00"));
//        testRequest.setTime(time);
        testOLDRequest.setGlucose_manual(7.00);
        testOLDRequest.setComment("test comment");
        testOLDRequest.setLactate_manual(7.00);
        testOLDRequest.setPotassium_manual(7.00);
        testOLDRequest.setSodium_manual(7.00);
        testOLDRequest.setEvent_type("test event type");


        Call<OLD_Request> call = OLDPatientAPI.testPost(testOLDRequest);
//        Call<ComTest> call = patientAPI.testGet();
        call.enqueue(new Callback<OLD_Request>() {
            @Override
            public void onResponse(Call<OLD_Request> call, Response<OLD_Request> response) {
                if (response.isSuccessful()) {
                    System.out.println("SUCCESS");
//                    System.out.println(response.body());

                    OLD_Request OLDRequest = response.body();
//                    System.out.println(comTest.getPatientID());
//                    System.out.println(comTest.getDataRequested());
                    System.out.println(OLDRequest.toString());
//                    System.out.println(comTest.getPatientID());
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
            public void onFailure(Call<OLD_Request> call, Throwable t) {
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });
    }

}
