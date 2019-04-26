package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info;
import com.opula.fitnessapp.R;

import java.util.List;

public class RecyclerPlanTypeAdapter extends RecyclerView.Adapter<RecyclerPlanTypeAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Info> infolist;

    public int mSelectedItem = -1;

    String TAG = "RecyclerPlanTypeAdapter";


    public RecyclerPlanTypeAdapter(Context context, List<Info> infolist) {

        this.context = context;
        this.infolist = infolist;

        Log.d(TAG, "jigar the info list have is the " + infolist.size());


    }

//    public RecyclerPlanTypeAdapter(List<Info> info) {
//
//        this.context = context;
//        this.infolist = info;
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_radiogroup_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {




        Log.v(TAG, "skajal the response periodnumber is" + infolist.get(position).getPeriod());
        final Info planlist = infolist.get(position);
        viewHolder.txtplanName.setText(planlist.getPeriod());

        viewHolder.radio.setChecked(true);


        viewHolder.radio.setChecked(position == mSelectedItem);


        String str = viewHolder.radio.getText().toString();
        Toast.makeText(context,"selected radio button " + str , Toast.LENGTH_LONG);



    }

    @Override
    public int getItemCount() {
        return infolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtplanName;
        RadioButton radio;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);


            txtplanName = (TextView) itemView.findViewById(R.id.txtplanName);

            radio = (RadioButton) itemView.findViewById(R.id.radio);


            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();

                    notifyDataSetChanged();
                }
            };
            itemView.setOnClickListener(clickListener);
            radio.setOnClickListener(clickListener);
        }
    }






}
