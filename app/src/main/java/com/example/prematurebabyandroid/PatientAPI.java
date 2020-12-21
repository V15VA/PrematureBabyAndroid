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

    @POST("patients")
//    @FormUrlEncoded
    Call<ComTest> testPost(@Body POST post);

    @GET("patients")
    Call<ComTest> testGet();


}
