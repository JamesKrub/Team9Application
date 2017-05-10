package com.wanadjanan.team9application;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.wanadjanan.team9application.PBMSService.PBMSDAO.work57160092;
import com.wanadjanan.team9application.PBMSService.PBMSService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.wanadjanan.team9application.R.id.test;

public class Activity57160092 extends AppCompatActivity {

    private ArrayList<String> annoDomini = new ArrayList<String>();
    private Spinner Year;
    private PieChart mypiechart;
    private PBMSService service;
    private TextView Test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_57160092);

        Test = (TextView)findViewById(test);

        // Dropdown List
        Year = (Spinner) findViewById(R.id.Year57160092);
        createAnnoDomini();
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, annoDomini);
        adapterThai.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        Year.setAdapter(adapterThai);

        // Start Chart
        mypiechart = (PieChart)findViewById(R.id.Chart57160092);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.16.77.69/team9_2/index.php/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(PBMSService.class);

        Year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner value = (Spinner) findViewById(R.id.Year57160092);
                String text = value.getSelectedItem().toString();
                Test.setText("จำนวนโครงการจำแนกตามหน่วยงานที่รับผิดชอบ ประจำปีงบประมาณ "+text);
                service.sendData0092(text).enqueue(new Callback<work57160092>() {
                    @Override
                    public void onResponse(Call<work57160092> call, Response<work57160092> response) {
                        Log.d("RESPONSE","SUCCESS");
                        if(response.isSuccessful()){
                            //List<Entry> entries = new ArrayList<Entry>(); // Line Chart
                            ArrayList<PieEntry> entries = new ArrayList<>();
                            for(int i=0; i<response.body().graphData.size(); i++){
                                entries.add(new PieEntry(response.body().graphData.get(i).second, response.body().graphData.get(i).phaseName));
                            }
                            PieDataSet piedataset = new PieDataSet(entries,"Result of Data");
                            piedataset.setColors(ColorTemplate.COLORFUL_COLORS);
                            //XAxis xAxis = mybarchart.getXAxis();
                            /*YAxis left = mypiechart.getAxisLeft();
                            left.setLabelCount(4,true);
                            left.setValueFormatter(new Formatter());
                            left.setGranularity(1f);*/
                            PieData piedata = new PieData(piedataset);
                            mypiechart.setData(piedata);
                            mypiechart.invalidate(); // refresh after setting data

                        }else{
                            Log.d("RESPONSE","service error");
                        }
                    }

                    @Override
                    public void onFailure(Call<work57160092> call, Throwable t) {
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
