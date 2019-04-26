package com.opula.fitnessapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.google.gson.Gson;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.Crude.SharedPreference;
import com.opula.fitnessapp.MentorSubTypeListActivity;
import com.opula.fitnessapp.MoneyValueFilter;
import com.opula.fitnessapp.POJOClasses.BuyPlan.Buyplan;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;
import com.opula.fitnessapp.POJOClasses.BuyPlan.Buyplan;
import com.opula.fitnessapp.R;


import com.opula.fitnessapp.RadioAdapter;
import com.opula.fitnessapp.CustomClass.RoundedImageView;
import com.squareup.picasso.Picasso;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorSubTypeListAdapter extends RecyclerView.Adapter<MentorSubTypeListAdapter.MyViewHolder> {


    SharedPreference sharedPreference;

    double total = 0;


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

    TextView totalAmount;

    List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> infolist;


    EditText txtMRP,txtMonth;
    RadioAdapter radioAdapter;
    RecyclerPlanTypeAdapter recyclerPlanTypeAdapter;
    EditText editText;


    public MentorSubTypeListAdapter(List<Info> mentorTypeList) {
        this.mentorTypeList = mentorTypeList;
    }

    public MentorSubTypeListAdapter(Context context,List<Info> mentorTypeList) {
        this.context = context;
        this.mentorTypeList = mentorTypeList;
    }

    @NonNull
    @Override
    public MentorSubTypeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_mentor_type, viewGroup, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MentorSubTypeListAdapter.MyViewHolder holder, final int position) {

        final Info info = mentorTypeList.get(position);

        Picasso.with(context)
                .load(info.getImage())
                .into(holder.ivMentor);

        holder.textViewMentorName.setText(info.getName());
        holder.readMoreTextViewDesc.setText(info.getMessage());
        holder.MentorBOD.setText(info.getDOB());
        //  holder.txtMRP.setText(info.getPrice());
        strTrainerID = info.getMentorTypeID();




        holder.txtbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetBuyplan();

            }
        });





        GetPlanScheduleModel(holder.recycler_radio);


    }

//    private int getDecimalFormattedString(String str) {
//
//        String value = null;
//
//
//        if (value != null && !value.equalsIgnoreCase("")) {
//            StringTokenizer lst = new StringTokenizer(value, ".");
//            String str1 = value;
//            String str2 = "";
//            if (lst.countTokens() > 1) {
//                str1 = lst.nextToken();
//                str2 = lst.nextToken();
//            }
//            String str3 = "";
//            int i = 0;
//            int j = -1 + str1.length();
//            if (str1.charAt(-1 + str1.length()) == '.') {
//                j--;
//                str3 = ".";
//
//
//            }
//            for (int k = j; ; k--) {
//                if (k < 0) {
//                    if (str2.length() > 0)
//                        str3 = str3 + "." + str2;
//
//                }
//                str3 = str1.charAt(k) + str3;
//                i++;
//            }
//        }
//
//        return 0;
//    }


    private void GetPlanScheduleModel(final RecyclerView recycler_radio) {


        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(context)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_PLANSCHEDULE_ID, Planschedule);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(context).getInstance().get().GetPlanScheduleModel(optioMap).enqueue(new Callback<PlanScheduleModel>(){
                @Override
                public void onResponse(Call<PlanScheduleModel> call, Response<PlanScheduleModel> response) {

                    if (response.body() != null) {


                        if (response.body().getStatus() == 1) {


                            infolist=response.body().getInfo();


                        }


                        Log.d(TAG, "jigar the android the response we get user detail by id  is " + infolist.get(0).getPeriod());


                        RecyclerPlanTypeAdapter recyclerPlanTypeAdapter = new RecyclerPlanTypeAdapter(context,infolist);
                        recycler_radio.setLayoutManager(new LinearLayoutManager(context));
                        recycler_radio.setAdapter(recyclerPlanTypeAdapter);
                        recyclerPlanTypeAdapter.notifyDataSetChanged();




                    }
                }




                @Override
                public void onFailure(Call<PlanScheduleModel> call, Throwable t) {

                }
//
            });

        }

    }

    private void GetBuyplan() {


        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(context)) {

            Map<String, String> optioMap = new HashMap<>();

            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_PLAN_TYPE, PlanType);
            optioMap.put(Constants.TAG_MEMBERSHIP_TYPE,MembershipType);
            optioMap.put(Constants.TAG_PRICE, Price);
            optioMap.put(Constants.TAG_TRAINER_ID, strTrainerID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            Log.d(TAG, "kajal  the response we get user detail by id  is " + optioMap.toString());


            new RestClient(context).getInstance().get().GetBuyplan(optioMap).enqueue(new Callback<Buyplan>(){
                @Override
                public void onResponse(Call<Buyplan> call, Response<Buyplan> response) {

                    if (response.body() != null) {


                        if (response.body().getStatus() == 1) {


                            Log.d(TAG, "kajal the response we get user detail by id  is " + response.body().getInfo());


                        }if (response.body().getStatus() == 1) {

                            Toast.makeText(context, " " + response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        }




                    }
                }



                @Override
                public void onFailure(Call<Buyplan> call, Throwable t) {

                }


            });
        }
    }



    @Override
    public int getItemCount() {
        return mentorTypeList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView textViewMentorName,MentorBOD,txtamount,txtMRP,txtMonth,totalAmount;

        ReadMoreTextView readMoreTextViewDesc;
        CircleImageView ivMentor;
        RadioButton radio;

        RecyclerView recycler_radio;

        //for planschedule

        TextView txtbuy,txtplanName;



        public MyViewHolder(View view) {
            super(view);
            textViewMentorName = (TextView) view.findViewById(R.id.textViewMentorName);

            txtamount = (TextView) view.findViewById(R.id.txtamount);
            totalAmount = (TextView) view.findViewById(R.id.totalAmount);
            txtMRP = (TextView) view.findViewById(R.id.txtMRP);
            txtMonth = (TextView) view.findViewById(R.id.txtMonth);
            MentorBOD = (TextView) view.findViewById(R.id.MentorBOD);
            readMoreTextViewDesc = (ReadMoreTextView)view.findViewById(R.id.readMoreTextViewDesc);
            ivMentor = (CircleImageView) view.findViewById(R.id.ivMentor);

            radio = (RadioButton)view.findViewById(R.id.radio);

            txtbuy = (TextView)view.findViewById(R.id.txtbuy);
            txtplanName = (TextView)view.findViewById(R.id.txtplanName);
            recycler_radio = (RecyclerView) view.findViewById(R.id.recycler_radio);









        }
    }



}
