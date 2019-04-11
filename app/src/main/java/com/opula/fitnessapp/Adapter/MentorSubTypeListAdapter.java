package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MentorSubTypeListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Info> data = new ArrayList<>();
    LayoutInflater inflater;

    String TAG = "MentorSubTypeListActivity";
    String strRegisterID;
    String strTrainerID;
    String strPlanType ;
    String Price;
    String MembershipType;

    PlanListAdapter planListAdapter;
    ListView list;
    List<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info> listPlanList;

    AlertDialog alertDialog;


    public MentorSubTypeListAdapter(Context context, String MembershipType) {
        this.context = context;
        this.data = (ArrayList<Info>) data;
        inflater = LayoutInflater.from(this.context);
        this.MembershipType=MembershipType;




    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public Info getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final MyViewHolder mViewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list_item_mentor_type, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }


        Picasso.with(context)
                .load(data.get(position).getImage())
                .into(mViewHolder.ivMentor);


        mViewHolder.tvName.setText(data.get(position).getName());
        mViewHolder.tvDate.setText(data.get(position).getDOB());
        mViewHolder.tvPrice.setText(context.getString(R.string.Rs) + data.get(position).getPrice());

        strTrainerID=data.get(position).getMentorTypeID();


        mViewHolder.txtbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                GetPlanScheduleList();
                 showDialog(context);


            }
        });




        return convertView;


    }



    private void showDialog(Context mContext) {




        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View dialogView = inflater.inflate(R.layout.dialog_plantype, null);
        alertDialogBuilder.setView(dialogView);
        alertDialogBuilder.setCancelable(true);


        alertDialog = alertDialogBuilder.create();


        list = (ListView) dialogView.findViewById(R.id.list);





        alertDialog.show();



    }



    private void GetPlanScheduleList() {


        strRegisterID = "85475825";


        if (AppGlobal.isNetwork(context)) {

            Map<String, String> optioMap = new HashMap<>();

            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            Log.d(TAG, "kajal  the response we get user detail by id  is " + optioMap.toString());


            new RestClient(context).getInstance().get().GetPlanSchedule(optioMap).enqueue(new Callback<PlanScheduleModel>(){
                @Override
                public void onResponse(Call<PlanScheduleModel> call, Response<PlanScheduleModel> response) {

                    if (response.body() != null) {


                        Log.d(TAG, "kajal the response we get user detail by id  is " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {


                            listPlanList=(ArrayList<com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info>) response.body().getInfo();


                            PlanListAdapter planListAdapter=new PlanListAdapter(context, listPlanList);
                            LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                            list.setAdapter(planListAdapter);



                        }

                        Toast.makeText(context, "" + response.body().getMsg(), Toast.LENGTH_SHORT).show();


                    }
                }

                @Override
                public void onFailure(Call<PlanScheduleModel> call, Throwable t) {


                }


            });
        }
    }





    public void addAll(ArrayList<Info> listData) {

        if (listData == null)
            return;


        data.clear();
        data.addAll(listData);

        notifyDataSetChanged();


    }

    class MyViewHolder {
        @BindView(R.id.ivMentor)
        RoundedImageView ivMentor;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.tvPrice)
        TextView tvPrice;

        @BindView(R.id.txtbuy)
        TextView txtbuy;

//        @BindView(R.id.list)
//        ListView list;

        public MyViewHolder(View view) {

            ButterKnife.bind(this, view);
        }
    }
}