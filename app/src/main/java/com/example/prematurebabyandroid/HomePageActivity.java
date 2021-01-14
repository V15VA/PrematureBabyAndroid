package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    Button clinicianButton;
    Button engineerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_homepage);

        clinicianButton = (Button) findViewById(R.id.clinican_btn);
        engineerButton = (Button) findViewById(R.id.engineer_btn);

        clinicianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toClinicianLandingActivity = new Intent(getApplicationContext(),
                        ClinicianLandingActivity.class);
                startActivity(toClinicianLandingActivity);
            }
        });

        engineerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEngineerLandingActivity = new Intent(getApplicationContext(),
                        EngineerLandingActivity.class);
                startActivity(toEngineerLandingActivity);
            }
        });
    }
}