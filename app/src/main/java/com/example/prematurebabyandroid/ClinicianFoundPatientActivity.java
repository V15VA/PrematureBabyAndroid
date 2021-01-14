package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.prematurebabyandroid.POJOs.Patient;

public class ClinicianFoundPatientActivity extends AppCompatActivity {

    EditText patientIDinput;
    TextView searchedFor;
    private int patientID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_clinician_found_patient);

        patientID = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
//        OLD_Character OLDCharacter = getIntent().getParcelableExtra("EXTRA_PATIENT");
        Patient patient = getIntent().getParcelableExtra("EXTRA_PATIENT");



        searchedFor = (TextView) findViewById(R.id.searched_for);
//        String message = "Showing data for patient " + OLDCharacter.getName() + " with ID " + OLDCharacter.getID();
//        searchedFor.setText(message);

    }


    // Called when the user taps the View Diary button in found_patient.xml

    public void enterDiary(View view) {

        // Do something in response to button

        Intent toDiary = new Intent(getApplicationContext(), ClinicainDiaryActivity.class);
        startActivity(toDiary);
    }


    // Called when the user taps the View Summary button in found_patient.xml

    public void enterSummary(View view) {

        // Do something in response to button

        Intent toSummary = new Intent(getApplicationContext(), SummaryActivity.class);
        startActivity(toSummary);
    }


    // Called when the user taps the Enter Measurement button in found_patient.xml

    public void enterMeasurement(View view) {

        // Do something in response to button

        Intent toNewMeasurement = new Intent(getApplicationContext(), ClinicianNewMeasurementActivity.class);
//      Send the patient ID to the next activity
        toNewMeasurement.putExtra("EXTRA_PATIENT_ID", patientID);
        startActivity(toNewMeasurement);
    }




}