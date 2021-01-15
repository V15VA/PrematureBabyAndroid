package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.prematurebabyandroid.POJOs.Filter;
import com.example.prematurebabyandroid.POJOs.Patient;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class SummaryActivity extends AppCompatActivity {


    Patient patient;
    LineGraphSeries<DataPoint> glucoseSeries, lactateSeries, sodiumSeries, potassiumSeries;
    PointsGraphSeries<DataPoint> glucoseManualSeries, lactateManualSeries, sodiumManualSeries, potassiumManualSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_clinician_view_summary);
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



    public void init() {


        //demo arrays, to be replaced with arrays retrieved from a Get request

        ArrayList<String> comment = new ArrayList <String>();
        ArrayList<String> event_type = new ArrayList <String>();
        ArrayList<String> time;


        ArrayList<Double> glucose;
        ArrayList<Double> lactate;
        ArrayList<Double> sodium;
        ArrayList<Double> potassium;

        ArrayList<Double> glucoseManual;
        ArrayList<Double> lactateManual;
        ArrayList<Double> sodiumManual;
        ArrayList<Double> potassiumManual;




        //Patient(0, comment, glucose, lactate, sodium, potassium, event_type, time);

        comment = patient.getComments();
        event_type = patient.getEvent_type();
        time = patient.getTime();
        glucose = patient.getGlucose();
        lactate = patient.getLactate();
        sodium = patient.getSodium();
        potassium = patient.getPotassium();

        glucoseManual = patient.getGlucose_input();
        lactateManual = patient.getLactate_input();
        sodiumManual = patient.getSodium_input();
        potassiumManual = patient.getPotassium_input();

        System.out.println("READ");
        System.out.println(glucose);



        GraphView graph = (GraphView) findViewById(R.id.graph);
        glucoseSeries = new LineGraphSeries<DataPoint>();
        lactateSeries = new LineGraphSeries<DataPoint>();
        sodiumSeries = new LineGraphSeries<DataPoint>();
        potassiumSeries = new LineGraphSeries<DataPoint>();


        glucoseManualSeries = new PointsGraphSeries<DataPoint>();
        lactateManualSeries = new PointsGraphSeries<DataPoint>();
        sodiumManualSeries = new PointsGraphSeries<DataPoint>();
        potassiumManualSeries = new PointsGraphSeries<DataPoint>();


        for(int i = 0; i<glucose.size(); i++) {
            glucoseSeries.appendData(new DataPoint(i, glucose.get(i)), true, 100000);
            lactateSeries.appendData(new DataPoint(i, lactate.get(i)), true, 100000);
            sodiumSeries.appendData(new DataPoint(i, sodium.get(i)), true, 100000);
            potassiumSeries.appendData(new DataPoint(i, potassium.get(i)), true, 100000);

            Double temp = glucoseManual.get(i);
            if(temp!=null) {
                glucoseManualSeries.appendData(new DataPoint(i, temp), true, 100000);
            }
            temp = lactateManual.get(i);
            if(temp!=null) {
                lactateManualSeries.appendData(new DataPoint(i, temp), true, 100000);
            }
            temp = sodiumManual.get(i);
            if(temp!=null) {
                sodiumManualSeries.appendData(new DataPoint(i, temp), true, 100000);
            }
            temp = potassiumManual.get(i);
            if(temp!=null) {
                potassiumManualSeries.appendData(new DataPoint(i, temp), true, 100000);
            }
        }








        //series colors
        glucoseSeries.setColor(Color.BLACK);
        glucoseSeries.setThickness(1);

        lactateSeries.setColor(Color.RED);
        lactateSeries.setThickness(1);

        sodiumSeries.setColor(Color.BLUE);
        sodiumSeries.setThickness(1);

        potassiumSeries.setColor(Color.CYAN);
        potassiumSeries.setThickness(1);

        glucoseManualSeries.setColor(Color.BLACK);
        glucoseManualSeries.setSize(8);

        lactateManualSeries.setColor(Color.RED);
        lactateManualSeries.setSize(8);

        sodiumManualSeries.setColor(Color.BLUE);
        sodiumManualSeries.setSize(8);

        potassiumManualSeries.setColor(Color.CYAN);
        potassiumManualSeries.setSize(8);

        graph.addSeries(glucoseSeries);
        graph.addSeries(lactateSeries);
        graph.addSeries(sodiumSeries);
        graph.addSeries(potassiumSeries);

        graph.addSeries(glucoseManualSeries);
        graph.addSeries(lactateManualSeries);
        graph.addSeries(sodiumManualSeries);
        graph.addSeries(potassiumManualSeries);


        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(1500);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(150);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);


        //legends
        glucoseSeries.setTitle("Glucose");
        lactateSeries.setTitle("Lactate");
        sodiumSeries.setTitle("Sodium");
        potassiumSeries.setTitle("Potassium");

        glucoseManualSeries.setTitle("Glucose manual input");
        lactateManualSeries.setTitle("Lactate manual input");
        sodiumManualSeries.setTitle("Sodium manual input");
        potassiumManualSeries.setTitle("Potassium manual input");

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);

        //setting graph title
        graph.setTitle("Biomarker Concentrations");
        graph.setTitleTextSize(50);
        graph.setTitleColor(Color.BLACK);

        //axis titles
        GridLabelRenderer gridlabel=graph.getGridLabelRenderer();
        gridlabel.setHorizontalAxisTitle("Time / minutes");
        gridlabel.setHorizontalAxisTitleTextSize(30);
        gridlabel.setVerticalAxisTitle("Concentration / mmol/L");
        gridlabel.setVerticalAxisTitleTextSize(30);



    }






}