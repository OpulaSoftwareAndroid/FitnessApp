package com.opula.fitnessapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.DialogMainDietPlanAdapter;
import com.opula.fitnessapp.Adapter.MealTypeListAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.Foodlist.Foodlist;
import com.opula.fitnessapp.POJOClasses.Foodlist.Info;
import com.opula.fitnessapp.POJOClasses.SelectedFood.SelectedFood;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainMealTypeListActivity extends AppCompatActivity {


    AlertDialog alertDialog;
    RecyclerView recycler_dialog,dialog_diet_recycler;
    DialogMainDietPlanAdapter dialogMainDietPlanAdapter;



    String DinnerSnackID  ;
    String AfternoonSnackID  ;
    String MorningSnackID  ;
    String LunchID  ;
    String strRegisterID;
    String BreakfastID  ;


    String type;


    TextView txtFoodName,txtFoodNametwo;
    CheckBox chk1;
    Button btnSubmit,btnFood;


    RecyclerView diet_recycler;
    MealTypeListAdapter mainDietPlanAdapter;


    ArrayList<Info> listfoodlist = new ArrayList<>();

    String TAG = "MainMealTypeListActivity";

    SharedPreference sharedPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diet_plan);


        txtFoodName = (TextView) findViewById(R.id.txtFoodName);
        txtFoodNametwo = (TextView) findViewById(R.id.txtFoodNametwo);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        btnFood = (Button) findViewById(R.id.btnFood);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);


        diet_recycler = (RecyclerView) findViewById(R.id.recylerViewMealType);
        recycler_dialog = (RecyclerView)findViewById(R.id.recycler_dialog);
        dialog_diet_recycler = (RecyclerView)findViewById(R.id.recylerViewDietFoodTypeList);






        getMealTypeList();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetSelectedFood();

            }
        });



    }

    private void buildDialog(int dialogTheme, String s) {
        int animationSource = 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Animation Dialog");
        builder.setMessage(type);
        builder.setNegativeButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }
    


    private void getMealTypeList() {

        String strRegisterID ="85475825";

        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getFoodlist(optioMap).enqueue(new Callback<Foodlist>() {
                private Call<Foodlist> call;
                private Throwable t;

                @Override
                public void onResponse(Call<Foodlist> call, retrofit2.Response<Foodlist> response) {

                    if (response.body() != null) {

                        Log.d(TAG, "kajal the response we get food detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {

                        mainDietPlanAdapter = new MealTypeListAdapter(MainMealTypeListActivity.this,response.body().getInfo());
                        LinearLayoutManager horizontal = new LinearLayoutManager(MainMealTypeListActivity.this,LinearLayoutManager.VERTICAL,false);
                        diet_recycler.setLayoutManager(horizontal);
                        diet_recycler.setAdapter(mainDietPlanAdapter);




                            Log.d(TAG, "kajal the size we get diet  by id  is " + response.body().getInfo().size());

                            Toast.makeText(MainMealTypeListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();



                        }


                    }
                }

                @Override
                public void onFailure(Call<Foodlist> call, Throwable t) {

                    Log.d(TAG, "kajal the error on failure  response we get diet plan by id  is " + t.getMessage());


                }


            });

        }
    }


    private void GetSelectedFood() {


        String strRegisterID ="85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_BREAKFAST_ID,BreakfastID);
            optioMap.put(Constants.TAG_LUNCH_ID,LunchID);
            optioMap.put(Constants.TAG_MORNINGSNACK_ID,MorningSnackID);
            optioMap.put(Constants.TAG_AFTERNOONSNACK_ID,AfternoonSnackID);
            optioMap.put(Constants.TAG_DINNERSNACK_ID,DinnerSnackID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");




            new RestClient(this).getInstance().get().getSelectedFood(optioMap).enqueue(new Callback<SelectedFood>() {
                private Call<SelectedFood> call;
                private Throwable t;

                @Override
                public void onResponse(Call<SelectedFood> call, retrofit2.Response<SelectedFood> response) {

                    if (response.body() != null) {

                        Log.d(TAG, "skajal the response we get food detail by id  is " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {

                            Log.d(TAG, "kajal the size we get food detail by id  is " + response.body().getInfo());


                        }


                    }
                }

                @Override
                public void onFailure(Call<SelectedFood> call, Throwable t) {

                    Log.d(TAG, "kajal the error on failure  response we get selected food by id  is " + t.getMessage());


                }


            });

        }

    }



}
