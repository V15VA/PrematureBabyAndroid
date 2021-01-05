package com.example.prematurebabyandroid;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OLD_PatientAPI {
    //    @POST("/patients")
//    Call<Patient> createPatient(@Body Patient patient);
//

    @POST("patients")
//    @FormUrlEncoded
    Call<OLD_Request> testPost(@Body OLD_Request OLDRequest);

    @GET("patients")
    Call<OLD_ComTest> testGet();


}
