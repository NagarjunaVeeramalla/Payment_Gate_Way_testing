package com.payment_gate_way_testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by Nagarjuna on 3/23/2018.
 */

public class Bar_chart_Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_chart_activity);
        BarChart barChart = (BarChart) findViewById(R.id.barchart);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Bus");
        labels.add("Flight");
        labels.add("Hotel");
        labels.add("Holiday");
        labels.add("Recharges");
        labels.add("Cabs");
        labels.add("Bills");

        ArrayList<BarEntry> bargroup1 = new ArrayList<>();
        bargroup1.add(new BarEntry(10f, 0));
        bargroup1.add(new BarEntry(20f, 1));
        bargroup1.add(new BarEntry(30f, 2));
        bargroup1.add(new BarEntry(40f, 3));
        bargroup1.add(new BarEntry(50f, 4));
        bargroup1.add(new BarEntry(60f, 5));
        bargroup1.add(new BarEntry(70f, 6));



        BarDataSet bardataset = new BarDataSet(bargroup1, "Cells");
        barChart.setDescription("Set Bar Chart Description");
        BarData data = new BarData(labels, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);
        barChart.animateY(5000);
    }
}
