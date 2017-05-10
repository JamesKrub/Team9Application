package com.wanadjanan.team9application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160280;
import com.wanadjanan.team9application.PBMSService.PBMSService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wanadjanan.team9application.R.id.test;

public class Activity57160280 extends AppCompatActivity {

    private ArrayList<String> annoDomini = new ArrayList<String>();
    private Spinner Year;
    private TextView Test;
    private BarChart mybarchart;
    private PBMSService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_57160280);

        Test = (TextView)findViewById(test);

        // Dropdown List
        Year = (Spinner) findViewById(R.id.Year57160280);
        createAnnoDomini();
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, annoDomini);
        adapterThai.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Year.setAdapter(adapterThai);

        // Start Chart
        mybarchart = (BarChart)findViewById(R.id.Chart57160280);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.16.77.69/team9_2/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PBMSService.class);

        Year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner value = (Spinner) findViewById(R.id.Year57160280);
                String text = value.getSelectedItem().toString();
                Test.setText(text);
                service.sendData0280(text).enqueue(new Callback<work57160280>() {
                    @Override
                    public void onResponse(Call<work57160280> call, Response<work57160280> response) {
                        Log.d("RESPONSE","SUCCESS");
                        if(response.isSuccessful()){
                            //List<Entry> entries = new ArrayList<Entry>(); // Line Chart
                            ArrayList<BarEntry> entries = new ArrayList<>();
                            for(int i=0; i<response.body().graphData.size(); i++){
                                entries.add(new BarEntry(i,response.body().graphData.get(i).second));
                            }
                            BarDataSet bardataset = new BarDataSet(entries,"Result of Data");
                            bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
                            //XAxis xAxis = mybarchart.getXAxis();
                            YAxis left = mybarchart.getAxisLeft();
                            left.setLabelCount(4,true);
                            left.setValueFormatter(new Format57160280());
                            left.setGranularity(1f);
                            BarData bardata = new BarData(bardataset);
                            mybarchart.setData(bardata);
                            mybarchart.invalidate(); // refresh after setting data
                        }else{
                            Log.d("RESPONSE","service error");
                        }
                    }

                    @Override
                    public void onFailure(Call<work57160280> call, Throwable t) {
                        Log.d("RESPONSE","service error");
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void createAnnoDomini() {
        annoDomini.add("2560");
        annoDomini.add("2559");
        annoDomini.add("2558");
        annoDomini.add("2557");
        annoDomini.add("2556");
        annoDomini.add("2555");
    }
}
