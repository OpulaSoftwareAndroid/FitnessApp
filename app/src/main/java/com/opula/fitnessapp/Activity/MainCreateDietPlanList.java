package com.opula.fitnessapp.Activity;

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
import com.opula.fitnessapp.POJOClasses.FitnessVideoListModel.FitnessVideoModel;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.github.ybq.android.spinkit.animation.AnimationUtils.start;

public class MainCreateDietPlanList extends AppCompatActivity {


    Button btndiet;
    ImageView video,img;
   // VideoView videoView;
    TextView desc;

    SharedPreference sharedPreference;
    String TAG="MainCreateDietPlanList";


    RecyclerView recycler1, recyclerViewVideoList;
    DietPlanAdapter dietPlanAdapter;
    DietPlanVideoAdapter dietPlanVideoAdapter;

    List<Info> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create_diet_plan_list);

        sharedPreference = new SharedPreference();

        btndiet = (Button)findViewById(R.id.btndiet);
        desc = (TextView)findViewById(R.id.desc);

        video = (ImageView) findViewById(R.id.video);
        img = (ImageView)findViewById(R.id.img);
//        videoView = (VideoView)findViewById(R.id.videoView);


        recycler1 = (RecyclerView)findViewById(R.id.recycler1);
        recyclerViewVideoList = (RecyclerView)findViewById(R.id.recyclerViewVideoList);

        getDietPlanList();

        setDietVideoList();


    }

    private void getDietPlanList() {

    //    String strRegisterID = sharedPreference.getValue(MainCreateDietPlanList.this, Constants.STORED_REGISTER_ID);

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

                                    Log.d(TAG, "jigar the response we get diet detail by id  is " + new Gson().toJson(response));

                                    if (response.body().getStatus() == 1) {



                                        dietPlanAdapter = new DietPlanAdapter(MainCreateDietPlanList.this,response.body().getInfo());
                                        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainCreateDietPlanList.this, LinearLayoutManager.VERTICAL, false);
                                        recycler1.setLayoutManager(horizontalLayoutManager);
                                        recycler1.setAdapter(dietPlanAdapter);




                                        Log.d(TAG, "jigar the size we get user detail by id  is " + response.body().getInfo().size());

                                        Toast.makeText(MainCreateDietPlanList.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();



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

    public void setDietVideoList() {
        String strRegisterID = sharedPreference.getValue(MainCreateDietPlanList.this, Constants.STORED_REGISTER_ID);

         strRegisterID ="85475825";

        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getFitnessVideoList(optioMap)
                    .enqueue(new Callback<FitnessVideoModel>() {
                @Override
                public void onResponse(Call<FitnessVideoModel> call, Response<FitnessVideoModel> response) {

                    Log.d(TAG, "jigar the response we get diet video list by id  is " + new Gson().toJson(response));
                    dietPlanVideoAdapter = new DietPlanVideoAdapter(MainCreateDietPlanList.this,response.body().getInfo());
                    LinearLayoutManager horizontal = new LinearLayoutManager(MainCreateDietPlanList.this, LinearLayoutManager.VERTICAL, false);
                    recyclerViewVideoList.setLayoutManager(horizontal);
                    recyclerViewVideoList.setAdapter(dietPlanVideoAdapter);

                }

                @Override
                public void onFailure(Call<FitnessVideoModel> call, Throwable t) {

                }
            });
        }
    }
}
