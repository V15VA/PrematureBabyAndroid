package com.example.prematurebabyandroid.APIs;

import com.example.prematurebabyandroid.POJOs.SQLEditClinician;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PatientAPIInterface {
    @POST("patients")
    Call<String> SendNewPatientData(@Body SQLEditClinician clinician);
}
