package com.example.prematurebabyandroid;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PatientAPI {
//    @POST("/patients")
//    Call<Patient> createPatient(@Body Patient patient);
//
//    @FormUrlEncoded
//    @POST("patients")
//    Call<Patient> createPatient(@Field("patient_id") )
    @GET("/api/character")
    Call<Patient> getAllNames();


}
