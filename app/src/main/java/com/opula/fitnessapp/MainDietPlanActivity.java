package com.opula.fitnessapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.SharedPreference;

public class MainDietPlanActivity extends AppCompatActivity {


    String TAG="MainLoginActivity";

    Button btnSubmit;
    SharedPreference sharedPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diet_plan);
        sharedPreference = new SharedPreference();

        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppGlobal.showProgressDialog(MainDietPlanActivity.this);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something after 100ms

                        Toast.makeText(MainDietPlanActivity.this,"Thank You, Diet plan will be assign 24 hours",Toast.LENGTH_LONG).show();

                        AppGlobal.hideProgressDialog(MainDietPlanActivity.this);

                    }
                }, 3000);

            }
        });
    }

}
