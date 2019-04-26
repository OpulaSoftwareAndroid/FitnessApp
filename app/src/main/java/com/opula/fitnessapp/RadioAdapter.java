package com.opula.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info;
import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.PlanScheduleModel;

import java.util.List;

public class RadioAdapter extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Info> planlist;

    public int mSelectedItem = -1;


    public RadioAdapter(Context context, List<Info> planlist) {
        this.context = context;
        this.planlist = planlist;


        //  Log.v("TAG","kajal the response is" + planlist.size());

    }


    public RadioAdapter(MentorSubTypeListActivity context, List<Info> planlist) {

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
    public void onBindViewHolder( ViewHolder viewHolder, int position) {

       Info info = planlist.get(position);

       viewHolder.txtplanName.setText(info.getPeriod());






    }

    @Override
    public int getItemCount() {

        return planlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RadioButton radio;
        TextView txtplanName;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            radio = (RadioButton) itemView.findViewById(R.id.radio);
            txtplanName = (TextView) itemView.findViewById(R.id.txtplanName);


//            View.OnClickListener clickListener = new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    mSelectedItem = getAdapterPosition();
//                    notifyDataSetChanged();
//
//                }
//
//
//            };
//
//            itemView.setOnClickListener(clickListener);
//            radio.setOnClickListener(clickListener);
        }
    }


}
