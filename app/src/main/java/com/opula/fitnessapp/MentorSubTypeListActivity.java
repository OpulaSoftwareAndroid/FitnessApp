package com.opula.fitnessapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;

import com.google.gson.Gson;
import com.opula.fitnessapp.Adapter.MentorSubTypeListAdapter;

import com.opula.fitnessapp.Adapter.RecyclerPlanTypeAdapter;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.MentorTypeList;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorSubTypeListActivity extends AppCompatActivity {


    @BindView(R.id.mentor_recycler)
    RecyclerView mentor_recycler;

    @BindView(R.id.tvHeaderTitle)
    TextView tvHeaderTitle;

    CircleImageView ivMentor;
    TextView txtplanid, txtperiod, tvPrice, MentorBOD, toAmount, txtMonth, txtMRP, txtbuy,totalAmount,txtamount;
    MentorSubTypeListAdapter mentorSubTypeListAdapter;
    List<Info> listMentorTypeList = new ArrayList<>();
    String mentorTypeID;
    String mentorName;
    ReadMoreTextView readMoreTextViewDesc;
    String PlanType;
    String MembershipType;
    String Price;
    String strTrainerID;
    SharedPreference sharedPreference;
    String strRegisterID;
    String TAG = "MentorSubTypeListActivity";
    String Dob;
    String Message;
    TextView SchedulePlanName, TextViewPeriod;
    RadioButton radio;
    TextView txtplanName,txtname;
    RecyclerView recycler_radio;
    RadioAdapter radioAdapter;

    RecyclerPlanTypeAdapter recyclerPlanTypeAdapter;

    // PlanScheduleAdapter planScheduleAdapter;

    List<Info> info = new ArrayList<>();
    List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> planlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_type_list);


        //recycler_radio = (RecyclerView)findViewById(R.id.recycler_radio);

        radio = (RadioButton)findViewById(R.id.radio);



        txtbuy = (TextView)findViewById(R.id.textViewBuy);
        MentorBOD = (TextView)findViewById(R.id.MentorBOD);

        totalAmount = (TextView) findViewById(R.id.textViewTotalAmount);
        txtMRP = (TextView) findViewById(R.id.textViewMRP);
        txtMonth = (TextView) findViewById(R.id.textViewMonth);

        ivMentor = (CircleImageView)findViewById(R.id.ivMentor);


        ListView plandata = (ListView)findViewById(R.id.list);
        readMoreTextViewDesc = (ReadMoreTextView)findViewById(R.id.readMoreTextViewDesc);

        txtplanName = (TextView)findViewById(R.id.txtplanName);
        txtname = (TextView)findViewById(R.id.txtname);





        try {
            ButterKnife.bind(this);


            mentorTypeID = getIntent().getStringExtra("mentorTypeID");
            mentorName = getIntent().getStringExtra("mentorName");

            sharedPreference = new SharedPreference();

            initView();
            strRegisterID = "85475825";



            getPlanDetailsPeriod();


        } catch (Exception e) {
            e.printStackTrace();
        }




    }




    private void initView() {
        try {


            tvHeaderTitle.setText(mentorName);
            mentor_recycler.setAdapter(mentorSubTypeListAdapter);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void getPlanDetailsPeriod() {
        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_TYPE, "1");
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);


            new RestClient(this).getInstance().get().GetPlanScheduleModel(optioMap).enqueue(new Callback<PlanScheduleModel>() {
                @Override
                public void onResponse(Call<PlanScheduleModel> call, Response<PlanScheduleModel> response) {
                    Log.d(TAG,"jigar the plan schedule list have is "+new Gson().toJson(response) );

                    if(response.body().getStatus()==1) {
                        List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> listPlanDetailList=response.body().getInfo();
                        callAPIGetMentorTypeList(listPlanDetailList);
                    }
                }

                @Override
                public void onFailure(Call<PlanScheduleModel> call, Throwable t) {

                }
            });
        }
    }
    private void callAPIGetMentorTypeList(final List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> listPlanDetailList) {



        if (AppGlobal.isNetwork(this)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_MENTOR_TYPE, mentorTypeID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_DOB,Dob);
            optioMap.put(Constants.TAG_MESSAGE,Message);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(this).getInstance().get().getMentorTypeList(optioMap).enqueue(new Callback<MentorTypeList>() {
                @Override
                public void onResponse(Call<MentorTypeList> call, Response<MentorTypeList> response) {



                    if (response.body() != null) {

                        if (response.body().getStatus() == 1) {


                            listMentorTypeList= response.body().getInfo();

                            Log.d(TAG, "kajal the data the response we get user detail by id  is " + listMentorTypeList.get(0).getMentorTypeID());


                            mentorSubTypeListAdapter = new MentorSubTypeListAdapter(MentorSubTypeListActivity.this
                                    ,listMentorTypeList,listPlanDetailList,mentorTypeID);
                            mentor_recycler.setLayoutManager(new LinearLayoutManager(MentorSubTypeListActivity.this));
                            mentor_recycler.setAdapter(mentorSubTypeListAdapter);
                            mentorSubTypeListAdapter.notifyDataSetChanged();



                        }

//                        if (response.body().getStatus() == 1) {
//                            Toast.makeText(MentorSubTypeListActivity.this, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();
//                        }
                    }



                }

                @Override
                public void onFailure(Call<MentorTypeList> call, Throwable t) {


                }
            });
        }
    }







}
