package com.opula.fitnessapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.KnowYourDietPlanAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.Info;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.KnowYourDietModel;
import com.opula.fitnessapp.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainKnowYourDietPlanActivity extends AppCompatActivity
{
    RecyclerView recyclerViewKnowYourDietPlanList;
    String TAG="MainKnowYourDietPlanActivity";
    KnowYourDietPlanAdapter knowYourDietPlanAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_know_your_diet_plan);

        recyclerViewKnowYourDietPlanList=findViewById(R.id.recyclerViewKnowYourDietPlanList);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainKnowYourDietPlanActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewKnowYourDietPlanList.setLayoutManager(horizontalLayoutManager);
        recyclerViewKnowYourDietPlanList.setAdapter(knowYourDietPlanAdapter);
        getKnowYourDietPlan();

    }

    public void getKnowYourDietPlan() {
        String strRegisterID = "37396918";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_PLAN_ID, "1");  //static for testing--------------------------------------
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");


            new RestClient(this).getInstance().get().getKnowYourDietPlanList(optioMap).enqueue(new Callback<KnowYourDietModel>() {
                @Override
                public void onResponse(Call<KnowYourDietModel> call, Response<KnowYourDietModel> response) {

                    if (response.body() != null) {

                        Log.d(TAG, "jigar the response we get diet detail by id  is " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {

                            List<Info> data=response.body().getInfo().get(0);

                            knowYourDietPlanAdapter = new KnowYourDietPlanAdapter(MainKnowYourDietPlanActivity.this,   data);
                            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainKnowYourDietPlanActivity.this, LinearLayoutManager.VERTICAL, false);
                            recyclerViewKnowYourDietPlanList.setLayoutManager(horizontalLayoutManager);
                            recyclerViewKnowYourDietPlanList.setAdapter(knowYourDietPlanAdapter);

                            Log.d(TAG, "jigar the size we get user detail by id  is " + response.body().getInfo().size());

                            Toast.makeText(MainKnowYourDietPlanActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<KnowYourDietModel> call, Throwable t) {
                    Log.d(TAG, "jigar the error on failure  response we get diet plan by id  is " + t.getMessage());
                }
            });

        }

    }
}
