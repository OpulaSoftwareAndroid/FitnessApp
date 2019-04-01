package com.opula.fitnessapp;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainSubscriptionType extends AppCompatActivity  {

    ImageView date;
    PopupWindow popupWindow;
    Button closePopupBtn,showPopupBtn,sub2,sub3;
    LinearLayout linearLayout1;

    View customView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diet_time);


        showPopupBtn = (Button) findViewById(R.id.showPopupBtn);
        date = (ImageView)findViewById(R.id.date);
        sub2= (Button) findViewById(R.id.sub2);
        sub3 = (Button) findViewById(R.id.sub3);

        linearLayout1 = (LinearLayout)findViewById(R.id.linearLayout1);


        showPopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                LayoutInflater layoutInflater = (LayoutInflater) MainSubscriptionType.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.popup,null);

                closePopupBtn = (Button) customView.findViewById(R.id.closePopupBtn);
                popupWindow = new PopupWindow(customView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


                popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 20, 20);

                closePopupBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });






    }




}
