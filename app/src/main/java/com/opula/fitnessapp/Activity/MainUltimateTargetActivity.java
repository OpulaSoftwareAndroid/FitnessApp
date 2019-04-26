package com.opula.fitnessapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.opula.fitnessapp.R;
import com.opula.fitnessapp.UltimateAdapter;
import com.opula.fitnessapp.Ultimatedata;

import java.util.ArrayList;
import java.util.List;

public class MainUltimateTargetActivity extends AppCompatActivity {

    ImageView img,imgdown;
    TextView rate;
    Button target;

    RecyclerView recycler;
    UltimateAdapter ultimateAdapter;
    List<Ultimatedata> ultimatedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ultimate_target);

        img = (ImageView)findViewById(R.id.img);
        rate = (TextView)findViewById(R.id.rate);

        ultimatedata = fill_with_ultimatedata();

        recycler = (RecyclerView)findViewById(R.id.recycler);
        ultimateAdapter  = new UltimateAdapter(getApplicationContext(), ultimatedata);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainUltimateTargetActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(horizontalLayoutManager);
        recycler.setAdapter(ultimateAdapter);


    }

    private List<Ultimatedata> fill_with_ultimatedata() {



        List<Ultimatedata> ultimatedata = new ArrayList<>();

        ultimatedata.add(new Ultimatedata(R.drawable.bmr,"Basal Metabolic Rate"));
        ultimatedata.add(new Ultimatedata(R.drawable.ibw,"Ideal Body Weight"));
        ultimatedata.add(new Ultimatedata(R.drawable.percentage,"Body Fate Percentage"));




        return  ultimatedata;
    }
}
