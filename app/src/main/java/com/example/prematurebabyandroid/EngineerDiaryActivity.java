
package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.prematurebabyandroid.POJOs.Patient;

import java.util.ArrayList;


public class EngineerDiaryActivity extends AppCompatActivity {

    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_engineer_diary);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        patient = getIntent().getParcelableExtra("EXTRA_PATIENT");
        patient.setPatient_id((ArrayList<Integer>) getIntent().getSerializableExtra("patientID"));
        patient.setPotassium((ArrayList<Double>) getIntent().getSerializableExtra("potassium"));
        patient.setSodium((ArrayList<Double>) getIntent().getSerializableExtra("sodium"));
        patient.setLactate((ArrayList<Double>) getIntent().getSerializableExtra("lactate"));
        patient.setGlucose((ArrayList<Double>) getIntent().getSerializableExtra("glucose"));
        patient.setPotassium_input((ArrayList<Double>) getIntent().getSerializableExtra("potassium_input"));
        patient.setSodium_input((ArrayList<Double>) getIntent().getSerializableExtra("sodium_input"));
        patient.setLactate_input((ArrayList<Double>) getIntent().getSerializableExtra("lactate_input"));
        patient.setGlucose_input((ArrayList<Double>) getIntent().getSerializableExtra("glucose_input"));

        init();
    }

    //https://stackoverflow.com/questions/18207470/adding-table-rows-dynamically-in-android


    //Dynamically display data in table
    public void init() {

        //demo arrays, to be replaced with arrays retrieved from a Get request

        ArrayList<String> comment; //= new ArrayList <String>();
        ArrayList<String> event_type; //= new ArrayList <String>();
        ArrayList<String> time;


        ArrayList<Double> glucose;
        ArrayList<Double> lactate;
        ArrayList<Double> sodium;
        ArrayList<Double> potassium;

        //Patient(0, comment, glucose, lactate, sodium, potassium, event_type, time);

        comment = patient.getComments();
        event_type = patient.getEvent_type();
        time = patient.getTime();
        glucose = patient.getGlucose();
        lactate = patient.getLactate();
        sodium = patient.getSodium();
        potassium = patient.getPotassium();
//        System.out.println("READ");
//        System.out.println(glucose);
        //Demo values loaded into arrays



//        for (int i = 0; i < 100; i++) {
//            time.add(String.valueOf(i));
//            glucose.add((double) i);
//            lactate.add((double) i);
//            sodium.add((double) i);
//            potassium.add((double) i);
//        }


        TableLayout stk = (TableLayout) findViewById(R.id.table_main);

        //new row

        TableRow tbrow0 = new TableRow(this);

        //new columns

        TextView tv0 = new TextView(this);
        tv0.setText(" Time ");
        tv0.setTextColor(Color.BLACK);
        tbrow0.addView(tv0);

        TextView tv1 = new TextView(this);
        tv1.setText(" Sodium ");
        tv1.setTextColor(Color.BLACK);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(this);
        tv2.setText(" Potassium ");
        tv2.setTextColor(Color.BLACK);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(this);
        tv3.setText(" Lactate ");
        tv3.setTextColor(Color.BLACK);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(this);
        tv4.setText(" Glucose ");
        tv4.setTextColor(Color.BLACK);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(this);
        tv5.setText(" Event ");
        tv5.setTextColor(Color.BLACK);
        tbrow0.addView(tv5);


        TextView tv6 = new TextView(this);
        tv6.setText(" Notes ");
        tv6.setTextColor(Color.BLACK);
        tbrow0.addView(tv6);

        stk.addView(tbrow0);

        for (int i = 0; i < time.size(); i++) {

            //new row

            TableRow tbrow = new TableRow(this);

            //new columns displaying data stored in arrays

            TextView t0v = new TextView(this);
            t0v.setText("" + time.get(i));
            t0v.setTextColor(Color.BLACK);
            t0v.setGravity(Gravity.CENTER);
            tbrow.addView(t0v);

            TextView t1v = new TextView(this);
            t1v.setText("" + sodium.get(i) );
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText("" + potassium.get(i) );
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText("" + lactate.get(i) );
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText("" + glucose.get(i) );
            t4v.setTextColor(Color.BLACK);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);


            TextView t5v = new TextView(this);
            String temp = event_type.get(i);
            if(temp!=null) {
                t5v.setText("" + temp);
            }
            if(temp==null)
            {
                t5v.setText("-");
            }
            t5v.setTextColor(Color.BLACK);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);


            TextView t6v = new TextView(this);
            String temp2 = comment.get(i);
            if(temp2!=null) {
                t6v.setText("" + temp2);
            }
            if(temp2==null)
            {
                t6v.setText("-");
            }
            t6v.setTextColor(Color.BLACK);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);

            stk.addView(tbrow);
        }

    }



}