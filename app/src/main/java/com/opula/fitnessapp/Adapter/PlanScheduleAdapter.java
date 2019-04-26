package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;
import com.opula.fitnessapp.R;
import com.opula.fitnessapp.RadioAdapter;

import java.util.List;

public class PlanScheduleAdapter extends RecyclerView.Adapter<PlanScheduleAdapter.ViewHolder> {


    Context context;
    LayoutInflater inflater;
    List<Info> planlist;


    public PlanScheduleAdapter(Context context, List<Info> planlist) {
        this.context = context;
        this.planlist = planlist;



    }

    public PlanScheduleAdapter(List<Info> planlist) {


        this.planlist = planlist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_radiogroup_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Info plan = planlist.get(position);

        viewHolder.txtplanName.setText(plan.getPeriod());
        viewHolder.txtmonth.setText(plan.getPeriodNumber());



    }

    @Override
    public int getItemCount() {
        return planlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtplanName,txtmonth;
        RadioButton radio;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtplanName = (TextView) itemView.findViewById(R.id.txtplanName);
            txtmonth = (TextView) itemView.findViewById(R.id.txtmonth);

            radio = (RadioButton)itemView.findViewById(R.id.radio);



        }
    }
}
