package com.opula.fitnessapp.Adapter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.google.gson.Gson;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.POJOClasses.BuyPlan.Buyplan;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.R;


import com.opula.fitnessapp.RadioAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorSubTypeListAdapter extends RecyclerView.Adapter<MentorSubTypeListAdapter.MyViewHolder> {


    SharedPreference sharedPreference;

    double total = 0;

    ArrayList <String> arrayListPlanScheduleNameList;
    ArrayList <String> arrayListPlanScheduleIDList;

    String Price  ;
    String MembershipType  ;
    String PlanType  ;

    String Planschedule  ;

    private List<Info> mentorTypeList;

    // for planschedule

    String TAG = "MentorSubTypeListActivity";
    String strRegisterID;
    String strTrainerID;
    String strPlanType ;
    Context context;
    Double doubleTotalAmount;
    TextView totalAmount;
    String mentorTypeID;

    List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> infolist;
    List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> listPlanDetailList;

    EditText txtMRP,txtMonth;
    RadioAdapter radioAdapter;
    RecyclerPlanTypeAdapter recyclerPlanTypeAdapter;
    EditText editText;


    public MentorSubTypeListAdapter(List<Info> mentorTypeList) {
        this.mentorTypeList = mentorTypeList;
    }

    public MentorSubTypeListAdapter(Context context,List<Info> mentorTypeList
            ,List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> listPlanDetailList,String mentorTypeID) {
        this.context = context;
        this.mentorTypeList = mentorTypeList;
        this.listPlanDetailList = listPlanDetailList;
        this.mentorTypeID=mentorTypeID;
        arrayListPlanScheduleNameList =new ArrayList<>();
        arrayListPlanScheduleIDList =new ArrayList<>();
        strRegisterID=sharedPreference.getValue(context,Constants.STORED_REGISTER_ID);
    }

    @NonNull
    @Override
    public MentorSubTypeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_mentor_type, viewGroup, false);
        LocalBroadcastManager.getInstance(context).registerReceiver(mMessageReceiver,
                new IntentFilter("selected_radio"));
        return new MyViewHolder(itemView);

    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String ItemName = intent.getStringExtra(Constants.TAG_PERIOD_NUMBER);
            Toast.makeText(context,ItemName +" " ,Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    public void onBindViewHolder(@NonNull final MentorSubTypeListAdapter.MyViewHolder holder, final int position) {

        final Info info = mentorTypeList.get(position);

        Picasso.with(context)
                .load(info.getImage())
                .into(holder.ivMentor);

        holder.textViewMentorName.setText(info.getName());
        holder.readMoreTextViewDesc.setText(info.getMessage());
        holder.MentorBOD.setText(info.getDOB());
        //  holder.textViewMRP.setText(info.getPrice());
        strTrainerID = info.getMentorTypeID();

        arrayListPlanScheduleNameList.clear();
        for(int i=0;i<listPlanDetailList.size();i++)
        {
            arrayListPlanScheduleNameList.add(listPlanDetailList.get(i).getPeriod());
            arrayListPlanScheduleIDList.add(listPlanDetailList.get(i).getPeriodNumber());
        }
        ArrayAdapter aa = new ArrayAdapter(context,android.R.layout.simple_spinner_item, arrayListPlanScheduleNameList);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        holder.spinnerPeriodNumber.setAdapter(aa);
        holder.textViewMRP.setText(info.getPrice());
        holder.spinnerPeriodNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context,"selected item is "+arrayListPlanScheduleNameList.get(position),Toast.LENGTH_LONG).show();
                holder.textViewMonth.setText(arrayListPlanScheduleIDList.get(position));
                doubleTotalAmount=Double.parseDouble(info.getPrice())*Double.parseDouble(arrayListPlanScheduleIDList.get(position));
                holder.textViewTotalAmount.setText(""+doubleTotalAmount);

                strPlanType=listPlanDetailList.get(position).getPlanScheduleID();
                MembershipType=mentorTypeID;
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        holder.btnTextViewBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GetBuyplan();

            }
        });
  //       GetPlanScheduleModel(position);
    }


    private void GetBuyplan() {


    //    strRegisterID = "85475825";


        if (AppGlobal.isNetwork(context)) {

            AppGlobal.showProgressDialog(context);
            Map<String, String> optioMap = new HashMap<>();

            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_PLAN_TYPE, strPlanType);
            optioMap.put(Constants.TAG_MEMBERSHIP_TYPE,MembershipType);
            optioMap.put(Constants.TAG_PRICE, String.valueOf(doubleTotalAmount));
            optioMap.put(Constants.TAG_TRAINER_ID, strTrainerID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");


            Log.d(TAG, "jigar the sending option params are " + optioMap.toString());


            new RestClient(context).getInstance().get().GetBuyplan(optioMap).enqueue(new Callback<Buyplan>(){
                @Override
                public void onResponse(Call<Buyplan> call, Response<Buyplan> response) {

                    Log.d(TAG,"jigar the buy plan json response we have is "+new Gson().toJson(response));
                    if (response.body() != null) {


                        if (response.body().getStatus() == 1) {
                            AppGlobal.hideProgressDialog(context);

                            Log.d(TAG, "jigar the response we get user detail by id  is " + response.body().getMsg());
                            Toast.makeText(context,response.body().getMsg(),Toast.LENGTH_LONG).show();

                        }

                        //                        if (response.body().getStatus() == 1) {
//
//                            Toast.makeText(context, " " + response.body().getMsg(), Toast.LENGTH_SHORT).show();
//                        }

                    }
                }



                @Override
                public void onFailure(Call<Buyplan> call, Throwable t) {
                    AppGlobal.hideProgressDialog(context);

                }


            });
        }
    }



    @Override
    public int getItemCount() {
        return mentorTypeList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewMentorName,MentorBOD,txtamount, textViewMRP,textViewMonth,textViewTotalAmount;

        ReadMoreTextView readMoreTextViewDesc;
        CircleImageView ivMentor;

        Spinner spinnerPeriodNumber;
        RecyclerView recycler_radio;

        //for planschedule

        TextView btnTextViewBuy,txtplanName;



        public MyViewHolder(View view) {
            super(view);
            textViewMentorName = (TextView) view.findViewById(R.id.textViewMentorName);

            textViewTotalAmount = (TextView) view.findViewById(R.id.textViewTotalAmount);
            textViewMRP = (TextView) view.findViewById(R.id.textViewMRP);
            textViewMonth = (TextView) view.findViewById(R.id.textViewMonth);
            MentorBOD = (TextView) view.findViewById(R.id.MentorBOD);
            readMoreTextViewDesc = (ReadMoreTextView)view.findViewById(R.id.readMoreTextViewDesc);
            ivMentor = (CircleImageView) view.findViewById(R.id.ivMentor);


            btnTextViewBuy = (TextView)view.findViewById(R.id.textViewBuy);
            txtplanName = (TextView)view.findViewById(R.id.txtplanName);
            spinnerPeriodNumber =  view.findViewById(R.id.spinnerPeriodNumber);


        }
    }



}
