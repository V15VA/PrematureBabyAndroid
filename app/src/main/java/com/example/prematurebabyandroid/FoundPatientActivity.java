package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;





public class FoundPatientActivity extends AppCompatActivity {


    TextView searchedFor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found_patient);


        //not sure what this does?

        int patientID = getIntent().getIntExtra("EXTRA_PATIENT_ID", 0);
        Character character = getIntent().getParcelableExtra("EXTRA_PATIENT");



        searchedFor = (TextView) findViewById(R.id.searched_for);
        String message = "Showing data for patient " + character.getName() + " with ID " + character.getID();
        searchedFor.setText(message);

    }




                    // Called when the user taps the View Diary button in found_patient.xml

                    public void enterDiary(View view) {

                        // Do something in response to button

                        Intent toDiary = new Intent(getApplicationContext(), DiaryActivity.class);
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

                        Intent toNewMeasurement = new Intent(getApplicationContext(), NewMeasurementActivity.class);
                        startActivity(toNewMeasurement);
                    }




}