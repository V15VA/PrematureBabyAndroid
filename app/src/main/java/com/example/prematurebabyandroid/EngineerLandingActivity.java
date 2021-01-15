package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EngineerLandingActivity extends AppCompatActivity {

    Button diaryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_engineer_landing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        diaryButton = (Button) findViewById(R.id.diary_btn);

        diaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toEngineerDiaryActivity = new Intent(getApplicationContext(),
                        EngineerDiaryActivity.class);
                startActivity(toEngineerDiaryActivity);
            }
        });
    }
}