package com.wanadjanan.team9application;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160136;
import com.wanadjanan.team9application.PBMSService.PBMSService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity57160136 extends AppCompatActivity {

    private BarChart mybarchart;
    private PBMSService service;
    private PieChart chart;
    private Spinner dropdown;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_57160136);

        chart = (PieChart) findViewById(R.id.Chart57160136);
        dropdown = (Spinner)findViewById(R.id.Year57160136);
        txtView = (TextView) findViewById(R.id.txt1);

        String[] items = new String[]{"2560","2559","2558","2557","2556","2555"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Log.d("EIEI",dropdown.getSelectedItem().toString());
                final String year = dropdown.getSelectedItem().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.16.77.69/team9_2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                service = retrofit.create(PBMSService.class);
                service.sendData0136(year).enqueue(new Callback<work57160136>() {
                    @Override
                    public void onResponse(Call<work57160136> call, Response<work57160136> response) {
                        if (response.body().graphData.size() != 0) {
                            Log.d("EIEI", response.body().graphData.get(0).name);
                            ArrayList<PieEntry> entries= new ArrayList<PieEntry>();
                            for(int i=0;i<response.body().graphData.size();i++){
                                entries.add(new PieEntry(response.body().graphData.get(i).value
                                        ,response.body().graphData.get(i).name));
                            }
                            PieDataSet pieDataSet = new PieDataSet(entries,"");
                            pieDataSet.setColors(ColorTemplate.PASTEL_COLORS);
                            pieDataSet.setValueTextSize(16);
                            pieDataSet.setValueTextColor(Color.WHITE);
                            PieData pieData = new PieData(pieDataSet);
                            chart.setEntryLabelColor(Color.BLACK);
                            chart.setEntryLabelTextSize(12f);
                            chart.setData(pieData);

                            txtView.setText("จำนวนโครงการจำแนกตามพันธกิจ ประจำปีงบประมาณ "+year);
                            chart.notifyDataSetChanged();
                            chart.invalidate();
                        }else{
                            txtView.setText("ไม่มีข้อมูล");
                        }
                    }
                    @Override
                    public void onFailure(Call<work57160136> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
