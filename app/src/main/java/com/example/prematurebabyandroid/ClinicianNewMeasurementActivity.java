package com.example.prematurebabyandroid;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Parcelable;
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
public class ClinicianNewMeasurementActivity extends AppCompatActivity {


private int patientID;
PatientAPIInterface patientAPIInterface;

//Post request fields entered by user

    float potassium_Value;
    EditText potassium_Input;

    float sodium_Value;
    EditText sodium_Input;

    float lactate_Value;
    EditText lactate_Input;

    float glucose_Value;
    EditText glucose_Input;

    String time_Value;
    EditText time_Input;

    String notes_Value;
    EditText notes_Input;

    String event_Value;
    EditText event_Input;

    Time time_Value_Sql;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_clinician_enter_measurement);

        patientID = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);

        time_Input = (EditText) findViewById(R.id.editTextTime);
        potassium_Input = (EditText) findViewById(R.id.editTextSodiumDecimal);
        sodium_Input = (EditText) findViewById(R.id.editTextPotassiumDecimal);
        lactate_Input = (EditText) findViewById(R.id.editTextLactateDecimal);
        glucose_Input = (EditText) findViewById(R.id.editTextGlucoseDecimal);
        notes_Input = (EditText) findViewById(R.id.editTextTextNotes);
        event_Input = (EditText) findViewById(R.id.editTextTextEvent);

//        Creates a new instance of the patientAPIInterface interface, and in turn a new Retrofit2
//        instance for communicating with the server
        patientAPIInterface = PatientAPIClient.getClient().create(PatientAPIInterface.class);
    }

    // Called when the user taps the submit button in enter_measurement.xml

    public void sendPostRequest(View view) {




        //unit testing

         validate(event_Input.getText().toString(),notes_Input.getText().toString(),
                 time_Input.getText().toString(), Float.valueOf(glucose_Input.getText().toString()),
                 Float.valueOf(lactate_Input.getText().toString()), Float.valueOf(sodium_Input.getText().toString()),
                 Float.valueOf(potassium_Input.getText().toString()));



        // Do something in response to button

        time_Value = time_Input.getText().toString();
        System.out.println(time_Value);

        time_Value_Sql = Time.valueOf(time_Value);

        potassium_Value = Float.valueOf(potassium_Input.getText().toString());
        System.out.println(potassium_Value);

        sodium_Value = Float.valueOf(sodium_Input.getText().toString());
        System.out.println(sodium_Value);

        lactate_Value = Float.valueOf(lactate_Input.getText().toString());
        System.out.println(lactate_Value);

        glucose_Value = Float.valueOf(glucose_Input.getText().toString());
        System.out.println(glucose_Value);

        notes_Value = notes_Input.getText().toString();
        System.out.println(notes_Value);

        event_Value = event_Input.getText().toString();
        System.out.println(event_Value);




        SQLEditClinician postPatient = new SQLEditClinician(patientID, notes_Value, glucose_Value,
                lactate_Value, sodium_Value, potassium_Value, event_Value, time_Value_Sql);

//        Creates an intent to move to the FoundPatient activity
        Intent toFoundPatient = new Intent(getApplicationContext(), ClinicianFoundPatientActivity.class);

//        Creates a new POST request of the from SendNewPatientData and queues it to be sent
        Call<String> call = patientAPIInterface.SendNewPatientData(postPatient);

//        Callback functions which activate if a response is received from the server
//        onResponse is called when the server responds, onFailure if there is no response
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {

//                  If the server reports a successful response, do the following

                    System.out.println("SUCCESS");
//                    System.out.println(response.body());

                    String resBody = response.body();

                    String patientString = resBody.substring(resBody.indexOf("}")+1);
                    patientString.trim();

                    Gson patientGson = new Gson();
                    Patient patient = patientGson.fromJson(patientString, Patient.class);

                    if (patient.getLen() != 0) {
//                        Displays a Toast notification to the user showing that the patient ID is
//                        valid
                        Toast.makeText(ClinicianNewMeasurementActivity.this, "Patient Found!",
                                Toast.LENGTH_LONG).show();

                        System.out.println(patient.getRow(0));

//                        Send the patient ID and the patient class to the next activity
                        toFoundPatient.putExtra("EXTRA_PATIENT_ID", patientID);
                        toFoundPatient.putExtra("EXTRA_PATIENT", (Parcelable) patient);

//                        Starts the next activity
                        startActivity(toFoundPatient);
                    }

                    else{
//                        Displays a Toast notification to the user showing that the patient ID is
//                        not valid
                        Toast.makeText(ClinicianNewMeasurementActivity.this,
                                "Patient not found in Database!",
                                Toast.LENGTH_LONG).show();
                    }

                }
                else {

//                  If the server reports an unsuccessful response, print the error as a string
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
//              If the connection to the server fails, print the error
                t.printStackTrace();
                System.out.println("CONNECTION FAIL");
            }
        });

    }






    //unit testing

    public ClinicianNewMeasurementActivity(Context context){

    }

    public String validate(String event_Input, String notes_Input, String time_Input,
                           float glucose_Input, float lactate_Input, float sodium_Input,float potassium_Input )
    {
        if(event_Input.equals("event") && notes_Input.equals("notes") && time_Input.equals("00:00:00") && glucose_Input==0 && lactate_Input==0 && sodium_Input==0 && potassium_Input==0)

        {
            return "Entry was successful";
        } else
            return "Invalid entry!";
    }



}


