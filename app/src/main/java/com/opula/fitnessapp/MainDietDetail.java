package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.MainDietDetailAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.DietPlanListModel.DietplanList;
import com.opula.fitnessapp.POJOClasses.Foodlist.Info;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainDietDetail extends AppCompatActivity {


    TextView txt1,diet1,diet2,diet3;

    List<Info> info;

    RecyclerView recycler;
    MainDietDetailAdapter adapter;

    SharedPreference sharedPreference;
    String TAG="MainDietDetail";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__dietdetail);


        txt1 = (TextView)findViewById(R.id.txt1);



        recycler = (RecyclerView)findViewById(R.id.recycler);


        adapter = new MainDietDetailAdapter(getApplicationContext(), info);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainDietDetail.this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(horizontalLayoutManager);
        recycler.setAdapter(adapter);

        getBreakfast();


    }
    private void getBreakfast() {

        String strRegisterID = "85475825";
      //  String strRegisterID = sharedPreference.getValue(MainDietDetail.this, Constants.STORED_REGISTER_ID);

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


                            adapter = new MainDietDetailAdapter(getApplicationContext(),info);
                            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainDietDetail.this, LinearLayoutManager.VERTICAL, false);
                            recycler.setLayoutManager(horizontalLayoutManager);
                            recycler.setAdapter(adapter);



                            Log.d(TAG, "jigar the size we get user detail by id  is " + response.body().getInfo().size());

                            Toast.makeText(MainDietDetail.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();



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
