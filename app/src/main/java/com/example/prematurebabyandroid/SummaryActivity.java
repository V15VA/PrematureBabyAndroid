package com.example.prematurebabyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series, series2,series3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_clinician_view_summary);

/*
        //https://github.com/jjoe64/GraphView
        //example code so demonstrate use

        GraphView graph = (GraphView) findViewById(R.id.graph);

        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[] {

                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)

        });

        graph.addSeries(series1);

    }
*/

        //demo arrays, to be replaced with arrays retrieved from a Get request


        GraphView graph = (GraphView) findViewById(R.id.graph);

        series = new LineGraphSeries<DataPoint>();

        series2 = new LineGraphSeries<DataPoint>();
        series2.setColor(Color.BLACK);

        series3 = new LineGraphSeries<DataPoint>();
        series3.setDrawDataPoints(true);
        series3.setDataPointsRadius(10);
        series3.setThickness(8);
        series3.setColor(Color.RED);



        ArrayList<String> comment = new ArrayList <String>();
        ArrayList<String> event_type = new ArrayList <String>();
        ArrayList<String> time = new ArrayList <String>();
        ArrayList<Double> glucose = new ArrayList <Double>();
        ArrayList<Double> lactate = new ArrayList <Double>();
        ArrayList<Double> sodium = new ArrayList <Double>();
        ArrayList<Double> potassium = new ArrayList <Double>();

        //Demo values loaded into arrays and appended onto data series for plotting

        for (int i = 0; i < 500; i++) {

            time.add(String.valueOf(i));

            glucose.add((double) 1.5*i);
            series.appendData(new DataPoint(Double.parseDouble(time.get(i)),glucose.get(i)), true, 500);

            lactate.add((double) 2*i);
            series.appendData(new DataPoint(Double.parseDouble(time.get(i)),lactate.get(i)), true, 500);

            sodium.add((double) 2.5*i);

            potassium.add((double) 3*i);
        }


        //adds highlighted red data point, use for manually inputted blood values

            series3.appendData(new DataPoint(1,1), true, 500);

        graph.addSeries(series);
        graph.addSeries(series2);
        graph.addSeries(series3);


        // set manual X bounds
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(24.0);

        // set manual Y bounds
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(10);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);


        /*
        //getting GraphView instance for glucose graph
        GraphView biomarkerGraph = (GraphView) findViewById(R.id.glucose_graph);

        //data for glucose graph
        LineGraphSeries<DataPoint> glucoseSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                //glucose.appendData(new DataPoint());
                new DataPoint(0, 2),
                new DataPoint(1, 6),
                new DataPoint(2, 7),
                new DataPoint(3, 8),
                new DataPoint(4, 6)

        });
        biomarkerGraph.addSeries(glucoseSeries);
        //legend formatting

        //data for lactate graph
        LineGraphSeries<DataPoint> lactateSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                //glucose.appendData(new DataPoint());
                new DataPoint(0, 4),
                new DataPoint(1, 6),
                new DataPoint(2, 8),
                new DataPoint(3, 6),
                new DataPoint(4, 5)

        });
        biomarkerGraph.addSeries(lactateSeries);

        //data for potassium graph
        LineGraphSeries<DataPoint> potassiumSeries  = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 7),
                new DataPoint(3, 6),
                new DataPoint(4, 4)
        });
        biomarkerGraph.addSeries(potassiumSeries);

        //data for sodium graph
        LineGraphSeries<DataPoint> sodiumSeries = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 3),
                new DataPoint(1, 3),
                new DataPoint(2, 6),
                new DataPoint(3, 2),
                new DataPoint(4, 5)
        });
        biomarkerGraph.addSeries(sodiumSeries);

        //series colors
        glucoseSeries.setColor(Color.BLUE);
        lactateSeries.setColor(Color.GREEN);
        potassiumSeries.setColor(Color.RED);
        sodiumSeries.setColor(Color.YELLOW);

        //legends
        glucoseSeries.setTitle("Glucose");
        lactateSeries.setTitle("Lactate");
        potassiumSeries.setTitle("Potassium");
        sodiumSeries.setTitle("Sodium");
        biomarkerGraph.getLegendRenderer().setVisible(true);
        biomarkerGraph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);

        //setting graph title
        biomarkerGraph.setTitle("Biomarker Concentrations");
        biomarkerGraph.setTitleTextSize(60);
        biomarkerGraph.setTitleColor(Color.BLUE);

        //axis titles
        GridLabelRenderer gridlabel=biomarkerGraph.getGridLabelRenderer();
        gridlabel.setHorizontalAxisTitle("Time");
        gridlabel.setHorizontalAxisTitleTextSize(30);
        gridlabel.setVerticalAxisTitle("Concentration [mmol/L]");
        gridlabel.setVerticalAxisTitleTextSize(30);*/

    }
}