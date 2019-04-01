package com.opula.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.iwgang.countdownview.CountdownView;

public class MainCountDownTimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_count_down_timer);

        CountdownView mCvCountdownView = (CountdownView)findViewById(R.id.cv_countdownViewTest1);
        mCvCountdownView.start(995550000); // Millisecond

// or
        for (int time=0; time<1000; time++) {
            mCvCountdownView.updateShow(time);
        }
    }
}
