package com.example.prematurebabyandroid.APIs;

import com.example.prematurebabyandroid.POJOs.SQLEditClinician;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PatientAPIInterface {
//    Defines a new POST request for the "patients" page on the base URL, the full web address
//    would be https://premhealthbabyservlet.herokuapp.com/patients
    @POST("patients")
//    Sends an object of type SQLEditClinician in the POST request, expects a response in the form
//    of a string
    Call<String> SendNewPatientData(@Body SQLEditClinician clinician);
}
