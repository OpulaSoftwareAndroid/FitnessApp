package com.opula.fitnessapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.opula.fitnessapp.Adapter.ViewPagerAdapter;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.P)


public class MainSignUp extends AppCompatActivity {



    ViewPager viewPager;
    LinearLayout SliderDots;
    private int dotscount;
    private ImageView[] dots;

    Button btnsign;
    TextView txtsign,txt;

    LinearLayout txtlinear;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);


        viewPager = (ViewPager)findViewById(R.id.viewPager);
        SliderDots = (LinearLayout)findViewById(R.id.SliderDots);

        btnsign = (Button) findViewById(R.id.btnsign);
        txtsign = (TextView) findViewById(R.id.txtsign);
        btnsign = (Button) findViewById(R.id.btnsign);
        txt = (TextView) findViewById(R.id.txt);




//
//        @SuppressLint("ResourceType") final Animation fade_in = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.animator.fade_in);
//        txt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                txt.setVisibility(View.VISIBLE);
//                txt.startAnimation(fade_in);
//                fade_in.getDuration();
//            }
//        });
//
//        @SuppressLint("ResourceType") final Animation fade_out = AnimationUtils.loadAnimation(getApplicationContext(),R.animator.fade_out);


        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {



            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            txt = (TextView)findViewById(R.id.txt);
            txt.setText(txt.getText());




            }

            @Override
            public void afterTextChanged(Editable s) {

                String text;
                text = txt.getText().toString();

            }
        });


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];


        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            SliderDots.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for(int i = 0; i< dotscount; i++){

                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




}










