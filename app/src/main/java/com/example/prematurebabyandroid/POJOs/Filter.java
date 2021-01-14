package com.example.prematurebabyandroid.POJOs;

//https://www.geeksforgeeks.org/program-find-simple-moving-average/
// Java program to calculate
// Simple Moving Average

//Example output

//Input : { 1, 3, 5, 6, 8 }
//        Period = 3
//        Output :New number added is 1.0, SMA = 0.3333333333333333
//        New number added is 3.0, SMA = 1.3333333333333333
//        New number added is 5.0, SMA = 3.0
//        New number added is 6.0, SMA = 4.666666666666667
//        New number added is 8.0, SMA = 6.333333333333333

import java.util.*;

public class Filter {

    // queue used to store list so that we get the average
    private final Queue<Double> Dataset = new LinkedList<Double>();
    private final int period;
    private double sum;

    // constructor to initialize period
    public Filter(int period)
    {
        this.period = period;
    }

    // function to add new data in the
    // list and update the sum so that
    // we get the new mean
    public void addData(double num)
    {
        sum += num;
        Dataset.add(num);

        // Updating size so that length
        // of data set should be equal
        // to period as a normal mean has
        if (Dataset.size() > period)
        {
            sum -= Dataset.remove();
        }
    }

    // function to calculate mean
    public double getMean()
    {
        return sum / period;
    }

    public static void main(String[] args)
    {
        double[] input_data = { 1, 3, 5, 6, 8};
        int per = 3;

        Filter obj = new Filter(per);

        for (double x : input_data) {
            obj.addData(x);
            System.out.println("New number added is " +
                    x + ", SMA = " + obj.getMean());
        }

    }
}
