package com.opula.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainSelectMentor extends AppCompatActivity {

    Button trainer,btndie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_select_mentor);

        trainer = (Button)findViewById(R.id.trainer);
        btndie = (Button)findViewById(R.id.btndie);

    }
}
