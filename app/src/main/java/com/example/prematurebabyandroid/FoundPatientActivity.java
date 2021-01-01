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

    EditText patientIDinput;
    TextView searchedFor;
    TextView tv_ViewDiary;
    TextView tv_ViewSummary;
    TextView tv_EnterMeasurement;
    ImageView iv_Diary;
    ImageView iv_Summary;
    ImageView iv_Measurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found_patient);

        int patientID = getIntent().getIntExtra("EXTRA_PATIENT_ID",0);
        Character character = getIntent().getParcelableExtra("EXTRA_PATIENT");

        searchedFor = (TextView)findViewById(R.id.searched_for);

        tv_ViewDiary = (TextView)findViewById(R.id.tv_View_Diary);
        tv_ViewSummary = (TextView)findViewById(R.id.tv_View_Summary);
        tv_EnterMeasurement = (TextView)findViewById(R.id.tv_Enter_Measurement);

        iv_Diary = (ImageView) findViewById(R.id.iv_diary);
        iv_Summary = (ImageView) findViewById(R.id.iv_summary);
        iv_Measurement = (ImageView) findViewById(R.id.iv_measurement);

        String message = "Showing data for patient " + character.getName() + " with ID " + character.getID();
        searchedFor.setText(message);


        iv_Diary.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toDiary = new Intent(getApplicationContext(), DiaryActivity.class);
                        startActivity(toDiary);
                    }
                }
        );

        iv_Summary.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toSummary = new Intent(getApplicationContext(), SummaryActivity.class);
                        startActivity(toSummary);
                    }
                }
        );

        iv_Measurement.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toNewMeasurement = new Intent(getApplicationContext(), NewMeasurementActivity.class);
                        startActivity(toNewMeasurement);
                    }
                }
        );
    }
}