package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prematurebabyandroid.APIs.PatientAPIClient;
import com.example.prematurebabyandroid.APIs.PatientAPIInterface;
import com.example.prematurebabyandroid.POJOs.Patient;
import com.example.prematurebabyandroid.POJOs.SQLEditClinician;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EngineerLandingActivity extends AppCompatActivity {

    Button diaryButton;

    PatientAPIInterface patientAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_engineer_landing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        diaryButton = (Button) findViewById(R.id.diary_btn);

        //        Creates a new instance of the patientAPIInterface interface, and in turn a new Retrofit2
        //        instance for communicating with the server
        patientAPIInterface = PatientAPIClient.getClient().create(PatientAPIInterface.class);

        diaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEngineerDiaryActivity = new Intent(getApplicationContext(),
                        EngineerDiaryActivity.class);

//        Creates a new instance of the sqlEditClinician class with arbitrary values and the
//        specified patient ID
                SQLEditClinician sqlEditClinician = new SQLEditClinician(2342, "",
                        0.0, 0.0, 0.0, 0.0, "",
                        Time.valueOf("00:00:00"));

                //        Creates a new POST request of the from SendNewPatientData and queues it to be sent
//        The POST request is only used here due to time constraints, it acts as a GET request
//        by writing arbitrary data at a set time
                Call<String> call = patientAPIInterface.SendNewPatientData(sqlEditClinician);

//        Callback functions which activate if a response is received from the server
//        onResponse is called when the server responds, onFailure if there is no response
                call.enqueue(new Callback<String>() {

                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {

//                  If the server reports a successful response, do the following

                            System.out.println("SUCCESS");

                            String resBody = response.body();

                            String patientString = resBody.substring(resBody.indexOf("}")+1);
                            patientString.trim();

                            Gson patientGson = new Gson();
                            Patient patient = patientGson.fromJson(patientString, Patient.class);

                            try {
                                if (patient.getLen() != 0) {
//                        Displays a Toast notification to the user showing that the patient ID is
//                        valid
                                    Toast.makeText(EngineerLandingActivity.this,
                                            "Data Retrieved Successfully!",
                                            Toast.LENGTH_LONG).show();

//                        Send the patient ID and the patient class to the next activity
                                    toEngineerDiaryActivity.putExtra("EXTRA_PATIENT_ID", 1234);
                                    toEngineerDiaryActivity.putExtra("EXTRA_PATIENT", patient);

//                            Non-String ArrayLists must be parcelled individually

                                    ArrayList<Integer> patientIDlist = patient.getPatient_id();
                                    toEngineerDiaryActivity.putExtra("patientIDlist", patientIDlist);
                                    ArrayList<Double> potassium = patient.getPotassium();
                                    toEngineerDiaryActivity.putExtra("potassium", potassium);
                                    ArrayList<Double> sodium = patient.getSodium();
                                    toEngineerDiaryActivity.putExtra("sodium", sodium);
                                    ArrayList<Double> lactate = patient.getLactate();
                                    toEngineerDiaryActivity.putExtra("lactate", lactate);
                                    ArrayList<Double> glucose = patient.getGlucose();
                                    toEngineerDiaryActivity.putExtra("glucose", glucose);
                                    ArrayList<Double> potassium_input = patient.getPotassium_input();
                                    toEngineerDiaryActivity.putExtra("potassium_input", potassium_input);
                                    ArrayList<Double> sodium_input = patient.getSodium_input();
                                    toEngineerDiaryActivity.putExtra("sodium_input", sodium_input);
                                    ArrayList<Double> lactate_input = patient.getLactate_input();
                                    toEngineerDiaryActivity.putExtra("lactate_input", lactate_input);
                                    ArrayList<Double> glucose_input = patient.getGlucose_input();
                                    toEngineerDiaryActivity.putExtra("glucose_input", glucose_input);

//                        Starts the next activity
                                    startActivity(toEngineerDiaryActivity);
                                }
                            }catch (NullPointerException e){
//                        Displays an Toast notification to the user if the servlet cannot handle
//                        the input
                                Toast.makeText(EngineerLandingActivity.this,
                                        "Server Communication Error! Contact Support",
                                        Toast.LENGTH_LONG).show();
                            }


                        }
                        else {

//                  If the server reports an unsuccessful response, print the error as a string
                            try {
                                System.out.println(response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
//                      Displays an Toast notification to the user if no response is received
//                      usually due to a timeout
                                Toast.makeText(EngineerLandingActivity.this,
                                        "Server Communication Error! Please Restart the App",
                                        Toast.LENGTH_LONG).show();
                            }
                            System.out.println("RESPONSE FAIL");
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
//              If the connection to the server fails, print the error
                        t.printStackTrace();
                        System.out.println("CONNECTION FAIL");
//              Displays an Toast notification to the user if the servlet cannot be
//              reached
                        Toast.makeText(EngineerLandingActivity.this,
                                "Check Internet Connection!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}