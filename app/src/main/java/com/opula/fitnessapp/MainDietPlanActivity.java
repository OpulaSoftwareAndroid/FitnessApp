package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainDietPlanActivity  extends AppCompatActivity {



    TextView txtshup1,txtshup2;
    CheckBox chk1,chk2;

    EditText txtsnack;
    RecyclerView diet_recycler;
    MainDietPlanAdapter mainDietPlanAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diet_plan);



        txtshup1 = (TextView)findViewById(R.id.txtshup1);
        txtshup2 = (TextView)findViewById(R.id.txtshup2);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);

        diet_recycler = (RecyclerView)findViewById(R.id.diet_recycler);






//
//        adapter1  = new RecyclarAdapter1(getApplicationContext(), diet1);
//        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainDietPlan.this, LinearLayoutManager.VERTICAL, false);
//        recycler1.setLayoutManager(horizontalLayoutManager);
//        recycler1.setAdapter(adapter1);

//
//        adapter2  = new RecyclerAdapter2(getApplicationContext(), diet2);
//        horizontalLayoutManager = new LinearLayoutManager(MainDietPlan.this, LinearLayoutManager.VERTICAL, false);
//        recycler2.setLayoutManager(horizontalLayoutManager);
//        recycler2.setAdapter(adapter2);


    }


}
