package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prematurebabyandroid.APIs.PatientAPIClient;
import com.example.prematurebabyandroid.APIs.PatientAPIInterface;
import com.example.prematurebabyandroid.POJOs.Patient;
import com.example.prematurebabyandroid.POJOs.SQLEditClinician;
import com.google.gson.Gson;

import java.io.IOException;
import java.sql.Time;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClinicianLandingActivity extends AppCompatActivity {

    EditText patientIDinput;
    Button searchButton;
    TextView searchedFor;

    PatientAPIInterface patientAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_clinician_landing);

        patientIDinput = (EditText) findViewById(R.id.et_patient_id_input);
        searchButton = (Button) findViewById(R.id.bt_search);
        searchedFor = (TextView) findViewById(R.id.searched_for);

        //Creates a new instance of the patientAPIInterface interface, and in turn a new Retrofit2
        //instance for communicating with the server
        patientAPIInterface = PatientAPIClient.getClient().create(PatientAPIInterface.class);

//        OLD_PatientController OLDPatientController = new OLD_PatientController();
//        OLDPatientController.Start();

    }

   // Called when the user taps the search button in view_home.xml

    public void searchId(View view) {

//        Creates an intent to move to the FoundPatient activity
        Intent toFoundPatient = new Intent(getApplicationContext(), ClinicianFoundPatientActivity.class);

//        Gets the input from the "patietnIDinput" edit text widget
        String patientID_string = patientIDinput.getText().toString();

//        Sets the input to zero if it is not valid
        if (patientID_string.length()<4) {patientID_string = "0";}

//        Converts the text to an integer
        int patientID = Integer.parseInt(patientID_string);

//        Creates a new instance of the sqlEditClinician class with arbitrary values and the
//        specified patient ID
        SQLEditClinician sqlEditClinician = new SQLEditClinician(patientID, "",
                0, 0, 0, 0, "",
                Time.valueOf("00:00:00"));

//                        OLD_CharacterController OLDCharacterController = new OLD_CharacterController();
//                        OLD_Character OLDCharacter = new OLD_Character();
//                        OLD_CharacterCallback OLDCharacterCallback = new OLD_CharacterCallback() {
//                            @Override
//                            public void onSuccess(OLD_Character characterCalled) {
//                                OLDCharacter.setID(characterCalled.getID());
//                                OLDCharacter.setName(characterCalled.getName());
//                                System.out.println("Name: " + OLDCharacter.getName() + " ID: " + OLDCharacter.getID());
//                                startActivity(toFoundPatient);
//                            }
//
//                            @Override
//                            public void onError(Throwable throwable) {
//
//                            }
//                        };
//                        OLDCharacterController.Start(patientID_string, OLDCharacterCallback);


        //Creates a new POST request of the from SendNewPatientData and queues it to be sent
        Call<String> call = patientAPIInterface.SendNewPatientData(sqlEditClinician);


        //Callback functions which activate if a response is received from the server
        //onResponse is called when the server responds, onFailure if there is no response

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

                    //If the server reports a successful response, do the following

                    System.out.println("SUCCESS");
                    System.out.println(response.body());

                    String resBody = response.body();


                    String patientString = resBody.substring(resBody.indexOf("}")+1);
                    patientString.trim();

                    Gson patientGson = new Gson();
                    Patient patient = patientGson.fromJson(patientString, Patient.class);

                    try {
                        if (patient.getLen() != 0) {

                            //Displays a Toast notification to the user showing that the patient ID is
                            //valid

                            Toast.makeText(ClinicianLandingActivity.this, "Patient Found!",
                            Toast.LENGTH_LONG).show();

                            System.out.println(patient.getRow(0));

                            //Send the patient ID and the patient class to the next activity
                            toFoundPatient.putExtra("EXTRA_PATIENT_ID", patientID);
                            toFoundPatient.putExtra("EXTRA_PATIENT", (Parcelable) patient);

                            //Starts the next activity
                            startActivity(toFoundPatient);
                        } else {

                            //Displays a Toast notification to the user showing that the patient ID is
                            //not valid
                            Toast.makeText(ClinicianLandingActivity.this, "Patient not found in Database!",
                            Toast.LENGTH_LONG).show();
                        }
                    } catch (NullPointerException e){

                        //Displays an Toast notification to the user if the servlet cannot handle
                        //the input

                        Toast.makeText(ClinicianLandingActivity.this, "Server Communication Error! Contact Support",
                        Toast.LENGTH_LONG).show();
                    }

                }

                else {

                    //If the server reports an unsuccessful response, print the error as a string
                    try {
                        System.out.println(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("RESPONSE FAIL");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                //If the connection to the server fails, print the error
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");

            }
        });
    }
}