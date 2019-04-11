package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.MentorSubTypeListAdapter;
import com.opula.fitnessapp.Adapter.PlanListAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.MentorTypeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorSubTypeListActivity extends AppCompatActivity {

    @BindView(R.id.lvMentorType)
    ListView lvMentorType;

    @BindView(R.id.tvHeaderTitle)
    TextView tvHeaderTitle;


    TextView txtbuy;
    ListView list;
    PlanListAdapter planListAdapter;
    TextView txtplanid,txtperiod,tvPrice,tvDate,tvName;



    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MentorSubTypeListActivity";

    MentorSubTypeListAdapter adapter;

    String mentorTypeID;
    String mentorName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_type_list);


        txtbuy = (TextView)findViewById(R.id.txtbuy);
        list = (ListView)findViewById(R.id.list);
        txtplanid = (TextView) findViewById(R.id.txtplanid);
        txtperiod = (TextView)findViewById(R.id.txtperiod);
        tvDate = (TextView)findViewById(R.id.tvDate);
        tvPrice = (TextView)findViewById(R.id.tvPrice);



        ListView plandata = (ListView)findViewById(R.id.list);







        try {
            ButterKnife.bind(this);
            mentorTypeID = getIntent().getStringExtra("mentorTypeID");
            mentorName = getIntent().getStringExtra("mentorName");

            sharedPreference = new SharedPreference();

            initView();





          callAPIGetMentorTypeList();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initView() {
        try {


            tvHeaderTitle.setText(mentorName);

            adapter = new MentorSubTypeListAdapter(this,mentorTypeID);
            lvMentorType.setAdapter(adapter);




        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void callAPIGetMentorTypeList() {



        strRegisterID = "85475825";

       if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_MENTOR_TYPE, mentorTypeID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getMentorTypeList(optioMap).enqueue(new Callback<MentorTypeList>() {
                @Override
                public void onResponse(Call<MentorTypeList> call, Response<MentorTypeList> response) {

                    if (response.body() != null) {

                        if (response.body().getStatus() == 1) {
                            adapter.addAll((ArrayList<Info>) response.body().getInfo());

                        }


                        Log.d(TAG, "data the response we get user detail by id  is " + new Gson().toJson(response));


                        if (response.body().getStatus() == 1) {
                            Toast.makeText(MentorSubTypeListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MentorTypeList> call, Throwable t) {


                }
            });
        }
    }
}
