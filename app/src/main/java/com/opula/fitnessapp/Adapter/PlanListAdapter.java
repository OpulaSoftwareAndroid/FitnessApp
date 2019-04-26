package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.opula.fitnessapp.MentorSubTypeListActivity;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class PlanListAdapter extends RecyclerView.Adapter<PlanListAdapter.ViewHolder> {


    Context context;
    List<Info> listPlanList = new ArrayList<>();
    LayoutInflater inflater;
    String strRegisterID;

    String Price;
    String TAG = "MentorSubTypeListActivity";


    public PlanListAdapter(Context context, List<Info> listPlanList) {
        this.context = context;
        this.listPlanList = listPlanList;
        this.inflater = LayoutInflater.from(context);

        Log.v(TAG,"data the response");

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plan_list, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {


        Info info = listPlanList.get(position);

        viewHolder.SchedulePlanName.setText(info.getPeriodNumber());
        viewHolder.TextViewPeriod.setText(info.getPeriod());



        viewHolder.chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               viewHolder.chk.isSelected();



            }
        });









    }

    public PlanListAdapter(List<Info> listPlanList) {

        this.listPlanList = listPlanList;
    }




    @Override
    public int getItemCount() {
        return listPlanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView SchedulePlanName,TextViewPeriod;
        CheckBox chk;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            SchedulePlanName = (TextView)itemView.findViewById(R.id.SchedulePlanName);
          //  TextViewPeriod = (TextView)itemView.findViewById(R.id.TextViewPeriod);





        }
    }
}