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

public class MainActivity extends AppCompatActivity {

    EditText patientIDinput;
    Button searchButton;
    TextView searchedFor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);

        patientIDinput = (EditText)findViewById(R.id.et_patient_id_input);
        searchButton = (Button)findViewById(R.id.bt_search);
        searchedFor = (TextView)findViewById(R.id.searched_for);

        PatientController patientController = new PatientController();
        patientController.Start();


        searchButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toFoundPatient = new Intent(getApplicationContext(), FoundPatientActivity.class);
                        String patientID_string = patientIDinput.getText().toString();
                        int patientID = Integer.parseInt(patientID_string);
                        CharacterController characterController = new CharacterController();
                        Character character = new Character();
                        CharacterCallback characterCallback = new CharacterCallback() {
                            @Override
                            public void onSuccess(Character characterCalled) {
                                character.setID(characterCalled.getID());
                                character.setName(characterCalled.getName());
                                System.out.println("Name: " + character.getName() + " ID: " + character.getID());
                                startActivity(toFoundPatient);
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }
                        };
                        characterController.Start(patientID_string, characterCallback);
                        toFoundPatient.putExtra("EXTRA_PATIENT_ID", patientID);
                        toFoundPatient.putExtra("EXTRA_PATIENT", (Parcelable) character);


                    }
                }
        );
    }
}