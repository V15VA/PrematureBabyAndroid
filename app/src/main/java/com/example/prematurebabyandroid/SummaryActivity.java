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
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SummaryActivity extends AppCompatActivity {


    Patient patient;
    LineGraphSeries<DataPoint> glucoseSeries, lactateSeries, sodiumSeries, potassiumSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_clinician_view_summary);

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

        //Patient(0, comment, glucose, lactate, sodium, potassium, event_type, time);

        comment = patient.getComments();
        event_type = patient.getEvent_type();
        time = patient.getTime();
        glucose = patient.getGlucose();
        lactate = patient.getLactate();
        sodium = patient.getSodium();
        potassium = patient.getPotassium();

        System.out.println("READ");
        System.out.println(glucose);
        //Demo values loaded into arrays



        GraphView graph = (GraphView) findViewById(R.id.graph);
        glucoseSeries = new LineGraphSeries<DataPoint>();
        lactateSeries = new LineGraphSeries<DataPoint>();
        sodiumSeries = new LineGraphSeries<DataPoint>();
        potassiumSeries = new LineGraphSeries<DataPoint>();

        for(int i = 0; i<glucose.size(); i++) {

            glucoseSeries.appendData(new DataPoint(i, glucose.get(i)), true, 100000);
            lactateSeries.appendData(new DataPoint(i, lactate.get(i)), true, 100000);
            sodiumSeries.appendData(new DataPoint(i, sodium.get(i)), true, 100000);
            potassiumSeries.appendData(new DataPoint(i, potassium.get(i)), true, 100000);
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

        graph.addSeries(glucoseSeries);
        graph.addSeries(lactateSeries);
        graph.addSeries(sodiumSeries);
        graph.addSeries(potassiumSeries);

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

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);

        //setting graph title
        graph.setTitle("Biomarker Concentrations");
        graph.setTitleTextSize(50);
        graph.setTitleColor(Color.BLACK);

        //axis titles
        GridLabelRenderer gridlabel=graph.getGridLabelRenderer();
        gridlabel.setHorizontalAxisTitle("Time");
        gridlabel.setHorizontalAxisTitleTextSize(30);
        gridlabel.setVerticalAxisTitle("Concentration [mmol/L]");
        gridlabel.setVerticalAxisTitleTextSize(30);



    }






}