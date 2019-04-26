package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.opula.fitnessapp.Crude.AppGlobal;
import com.opula.fitnessapp.Crude.Constants;
import com.opula.fitnessapp.Crude.RestClient;
import com.opula.fitnessapp.DialogSubscribeType;
import com.opula.fitnessapp.POJOClasses.BuySubcribePlanModel.BuySubscribePlan;
import com.opula.fitnessapp.POJOClasses.Subscribe.Info;
import com.opula.fitnessapp.POJOClasses.Subscribe.Subscribe;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class MainSubscribeAdapter extends RecyclerView.Adapter<MainSubscribeAdapter.ViewHolder> {


    Context mContext;
    LayoutInflater inflater;
    List<Info> info ;
    String TAG="MainSubscribeAdapter";
    AlertDialog alertDialog;
    LinearLayout linear;
    RecyclerView recycler;


    public MainSubscribeAdapter(Context mContext, List<Info> info) {

        this.mContext = mContext;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.mainsubscribe_recycler, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {

        viewHolder.sub1.setText(info.get(position).getName());

        Picasso.with(mContext)
                .load(R.drawable.subscribe)
                .into(viewHolder.imgsubscribe);


       viewHolder.sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(mContext, "subscribe!",Toast.LENGTH_SHORT).show();

                showDialog(mContext,info.get(position));

            }
        });

    }

    private void showDialog(Context mContext, final Info info ) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View dialogView = inflater.inflate(R.layout.dialog_subscribetype, null);
        alertDialogBuilder.setView(dialogView);
        alertDialogBuilder.setCancelable(true);

        TextView textViewSubjectID,textViewSubscriptionPlanName,textViewPlanType,textViewPrice,
                textViewMemberShipType,textViewPlanTypeName,textViewMembershipTypeName;
        Button btnBuyPlan;
        textViewSubjectID = dialogView.findViewById(R.id.textViewSubjectID);
        textViewPlanType = dialogView.findViewById(R.id.textViewPlanType);
        textViewPrice = dialogView.findViewById(R.id.textViewPrice);
        textViewMemberShipType = dialogView.findViewById(R.id.textViewMemberShipType);
        textViewPlanTypeName = dialogView.findViewById(R.id.textViewPlanTypeName);
        textViewMembershipTypeName = dialogView.findViewById(R.id.textViewMembershipTypeName);
        textViewSubscriptionPlanName= dialogView.findViewById(R.id.textViewSubscriptionPlanName);
        btnBuyPlan=dialogView.findViewById(R.id.btnBuyPlan);
        btnBuyPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBuySubscribePlan(info.getPlanType());
            }
        });
        alertDialog = alertDialogBuilder.create();


        textViewSubjectID.setText(info.getSubscribeID());
        textViewSubscriptionPlanName.setText(info.getName());
        textViewPlanType.setText(info.getPlanType());
        textViewMembershipTypeName.setText(info.getPlanTypeName());
        textViewMemberShipType.setText(info.getMembershipType());
        textViewPlanTypeName.setText(info.getPlanTypeName());
        textViewPrice.setText(info.getPrice());


//        DialogSubscribeAdapter dialogSubscribeAdapter=new DialogSubscribeAdapter(mContext,info);
//        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
//        recycler.setLayoutManager(horizontalLayoutManager);
//        recycler.setAdapter(dialogSubscribeAdapter);
//


    

        alertDialog.show();



    }
    public void setBuySubscribePlan(String strPlanType)
    {
        String strRegisterID ="85475825";


        if (AppGlobal.isNetwork(mContext)) {

            Map<String, String> optioMap = new HashMap<>();
            optioMap.put(Constants.TAG_REGISTER_ID, strRegisterID);
            optioMap.put(Constants.TAG_PLAN_ID, strPlanType);
            optioMap.put(Constants.TAG_VALID_DATA, Constants.STATIC_VALID_DATA);
            optioMap.put(Constants.TAG_TYPE, "1");

            new RestClient(mContext).getInstance().get().setBuySubscribePlan(optioMap).enqueue(new Callback<BuySubscribePlan>() {
                @Override
                public void onResponse(Call<BuySubscribePlan> call, retrofit2.Response<BuySubscribePlan> response) {

                    if (response.body() != null) {
                        Log.d(TAG, "jigar the response we get user detail by id  is  " + new Gson().toJson(response));

                        if (response.body().getStatus() == 1) {
                            Toast.makeText(mContext,response.body().getMsg(),Toast.LENGTH_LONG).show();
                            alertDialog.dismiss();

                        }
                    }
                }

                @Override
                public void onFailure(Call<BuySubscribePlan> call, Throwable t) {
                }
            });
        }


}

    @Override
    public int getItemCount() {

        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button sub1;
        ImageView imgsubscribe;
        LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            sub1 = (Button)itemView.findViewById(R.id.sub1);
            imgsubscribe = (ImageView)itemView.findViewById(R.id.imgsubscribe);
            linear = (LinearLayout)itemView.findViewById(R.id.linear);
            recycler = (RecyclerView)itemView.findViewById(R.id.recycler);

        }
    }
}
