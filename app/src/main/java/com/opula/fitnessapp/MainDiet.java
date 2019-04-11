package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.DietPlanAdapter;
import com.opula.fitnessapp.Adapter.DietPlanVideoAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.DietPlanListModel.DietplanList;
import com.opula.fitnessapp.POJOClasses.DietPlanListModel.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainDiet extends AppCompatActivity {


    Button btndiet;
    ImageView video,img;
    TextView desc;

    SharedPreference sharedPreference;
    String TAG="MainDiet";


    RecyclerView recycler1,recycler2;
    DietPlanAdapter dietPlanAdapter;
    DietPlanVideoAdapter dietPlanVideoAdapter;

    List<Info> data = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diet);

        sharedPreference = new SharedPreference();

        btndiet = (Button)findViewById(R.id.btndiet);
        desc = (TextView)findViewById(R.id.desc);

        img = (ImageView)findViewById(R.id.img);
        video = (ImageView)findViewById(R.id.video);



        recycler1 = (RecyclerView)findViewById(R.id.recycler1);
        recycler2 = (RecyclerView)findViewById(R.id.recycler2);




         getDietplanList();




    }

    private void getDietplanList() {

     //   String strRegisterID = sharedPreference.getValue(MainDiet.this, Constants.STORED_REGISTER_ID);

        String strRegisterID ="85475825";


        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getDietplanList(optioMap).enqueue(new Callback<DietplanList>() {
                private Call<DietplanList> call;
                private Throwable t;

                @Override
                public void onResponse(Call<DietplanList> call, retrofit2.Response<DietplanList> response) {

                    if (response.body() != null) {

                        Log.d(TAG, "jigar the response we get user detail by id  is " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {



                            dietPlanAdapter = new DietPlanAdapter(MainDiet.this,response.body().getInfo());
                            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainDiet.this, LinearLayoutManager.VERTICAL, false);
                            recycler1.setLayoutManager(horizontalLayoutManager);
                            recycler1.setAdapter(dietPlanAdapter);


                            dietPlanVideoAdapter = new DietPlanVideoAdapter(MainDiet.this,response.body().getInfo());
                            LinearLayoutManager horizontal = new LinearLayoutManager(MainDiet.this, LinearLayoutManager.VERTICAL, false);
                            recycler2.setLayoutManager(horizontal);
                            recycler2.setAdapter(dietPlanVideoAdapter);






                            Log.d(TAG, "jigar the size we get user detail by id  is " + response.body().getInfo().size());

                            Toast.makeText(MainDiet.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();



                        }


                    }
                }

                @Override
                public void onFailure(Call<DietplanList> call, Throwable t) {

                    Log.d(TAG, "jigar the error on failure  response we get diet plan by id  is " + t.getMessage());


                }


            });


        }
    }

}
