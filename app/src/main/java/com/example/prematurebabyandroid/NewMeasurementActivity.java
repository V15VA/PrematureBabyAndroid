package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewMeasurementActivity extends AppCompatActivity {



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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_measurement);



        time_Input = (EditText) findViewById(R.id.editTextTime);
        potassium_Input = (EditText) findViewById(R.id.editTextSodiumDecimal);
        sodium_Input = (EditText) findViewById(R.id.editTextPotassiumDecimal);
        lactate_Input = (EditText) findViewById(R.id.editTextLactateDecimal);
        glucose_Input = (EditText) findViewById(R.id.editTextGlucoseDecimal);
        notes_Input = (EditText) findViewById(R.id.editTextTextNotes);




    }

    // Called when the user taps the submit button in enter_measurement.xml

    public void sendPostRequest(View view) {

        // Do something in response to button


        time_Value = time_Input.getText().toString();
        System.out.println(time_Value);

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





    }
}