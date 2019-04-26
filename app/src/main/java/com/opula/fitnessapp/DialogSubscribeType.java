package com.opula.fitnessapp;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.DialogSubscribeAdapter;
import com.opula.fitnessapp.Adapter.MainSubscribeAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.Subscribe.Info;
import com.opula.fitnessapp.POJOClasses.Subscribe.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.RequiresApi;
import retrofit2.Call;
import retrofit2.Callback;

public class DialogSubscribeType extends AppCompatActivity {


    Button  sub1;
    RecyclerView mainrecycler;
    MainSubscribeAdapter mainSubscribeAdapter;
    ImageView imgsubscribe;




    SharedPreference sharedPreference;
    String TAG="DialogSubscribeType";
    private String strStoredata;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_list);

        sharedPreference = new SharedPreference();
        String strRegisterID = "85475825";


        sub1 = (Button) findViewById(R.id.sub1);
        imgsubscribe = (ImageView)findViewById(R.id.imgsubscribe);
        mainrecycler = (RecyclerView)findViewById(R.id.mainrecycler);


        getSubscribe();

    }




    private void getSubscribe() {

        String strRegisterID ="85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getSubscribe(optioMap).enqueue(new Callback<Subscribe>() {
                @Override
                public void onResponse(Call<Subscribe> call, retrofit2.Response<Subscribe> response) {

                    if (response.body() != null) {
                        Log.d(TAG, "jigar the response we get user detail by id  is  " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {

                            mainSubscribeAdapter = new MainSubscribeAdapter(DialogSubscribeType.this,response.body().getInfo());
                            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(DialogSubscribeType.this, LinearLayoutManager.VERTICAL, false);
                            mainrecycler.setLayoutManager(horizontalLayoutManager);
                            mainrecycler.setAdapter(mainSubscribeAdapter);

                        }
                    }
                }

                @Override
                public void onFailure(Call<Subscribe> call, Throwable t) {
                }
            });
        }
    }

}

