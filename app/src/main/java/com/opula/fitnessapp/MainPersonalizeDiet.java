package com.opula.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainPersonalizeDiet extends AppCompatActivity {

    Button btnName;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_personalize_diet);


        image = (ImageView)findViewById(R.id.image);
        btnName = (Button)findViewById(R.id.btnName);




    }
}
