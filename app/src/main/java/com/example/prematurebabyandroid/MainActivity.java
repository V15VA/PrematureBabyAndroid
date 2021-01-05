package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    EditText patientIDinput;
    Button searchButton;
    TextView searchedFor;

    PatientAPIInterface patientAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);


        patientIDinput = (EditText) findViewById(R.id.et_patient_id_input);
        searchButton = (Button) findViewById(R.id.bt_search);
        searchedFor = (TextView) findViewById(R.id.searched_for);

        patientAPIInterface = PatientAPIClient.getClient().create(PatientAPIInterface.class);

//        OLD_PatientController OLDPatientController = new OLD_PatientController();
//        OLDPatientController.Start();

    }

   // Called when the user taps the search button in view_home.xml

    public void searchId(View view) {

        // Do something in response to button

        Intent toFoundPatient = new Intent(getApplicationContext(), FoundPatientActivity.class);
        String patientID_string = patientIDinput.getText().toString();
        int patientID = Integer.parseInt(patientID_string);

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

        Call<String> call = patientAPIInterface.SendNewPatientData(sqlEditClinician);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    System.out.println("SUCCESS");
//                    System.out.println(response.body());

                    String resBody = response.body();

                    String patientString = resBody.substring(resBody.indexOf("}")+1);
                    patientString.trim();

                    Gson patientGson = new Gson();
                    Patient patient = patientGson.fromJson(patientString, Patient.class);

                    System.out.println(patient.getRow(0));
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
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });

        toFoundPatient.putExtra("EXTRA_PATIENT_ID", patientID);
//                        toFoundPatient.putExtra("EXTRA_PATIENT", (Parcelable) OLDC

    }
}