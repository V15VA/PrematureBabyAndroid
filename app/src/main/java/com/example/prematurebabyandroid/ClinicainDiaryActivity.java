package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ClinicainDiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_clinician_diary);
        init();
    }

    public void init() {

        TableLayout stk = (TableLayout) findViewById(R.id.table_main);

        //new row

        TableRow tbrow0 = new TableRow(this);

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

        stk.addView(tbrow0);

        for (int i = 0; i < 25; i++) {

            //new row

            TableRow tbrow = new TableRow(this);

            TextView t0v = new TextView(this);
            t0v.setText("" + i);
            t0v.setTextColor(Color.BLACK);
            t0v.setGravity(Gravity.CENTER);
            tbrow.addView(t0v);

            TextView t1v = new TextView(this);
            t1v.setText("Product " + i);
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);

            TextView t2v = new TextView(this);
            t2v.setText("Rs." + i);
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);

            TextView t3v = new TextView(this);
            t3v.setText("" + i * 15 / 32 * 10);
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);

            TextView t4v = new TextView(this);
            t4v.setText("" + i * 15 / 32 * 10);
            t4v.setTextColor(Color.BLACK);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);


            stk.addView(tbrow);
        }

    }



}