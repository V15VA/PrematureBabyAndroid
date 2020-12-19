package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText patientIDinput;
    Button searchButton;
    TextView searchedFor;

//    private CharacterAPI characterAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);

        patientIDinput = (EditText)findViewById(R.id.et_patient_id_input);
        searchButton = (Button)findViewById(R.id.bt_search);
        searchedFor = (TextView)findViewById(R.id.searched_for);


        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toFoundPatient = new Intent(getApplicationContext(), FoundPatientActivity.class);
                        String patientID_string = patientIDinput.getText().toString();
                        int patientID = Integer.parseInt(patientID_string);
//                        String patientID = "Showing data for patient "+patientIDinput.getText().toString();
//                        searchedFor.setText(patientID);
                        CharacterController characterController = new CharacterController();
                        characterController.start(patientID_string);
                        toFoundPatient.putExtra("EXTRA_PATIENT_ID", patientID);
                        startActivity(toFoundPatient);

                    }
                }
        );
    }
}