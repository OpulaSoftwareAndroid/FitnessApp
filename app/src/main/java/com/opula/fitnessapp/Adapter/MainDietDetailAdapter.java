package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.Foodlist.Info;
import com.opula.fitnessapp.R;

import java.util.List;

public class MainDietDetailAdapter extends RecyclerView.Adapter<MainDietDetailAdapter.ViewHolder> {

    private static final String TAG = "MainDietDetailAdapter" ;
    Context context;
    LayoutInflater inflater;

    List<Info> info;

    public MainDietDetailAdapter(Context context, List<Info> info) {
        this.context = context;
        this.info = info;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int position) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.know_your_diet_detail_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {



        holder.txt1.setText(info.get(position).getBreakfast().toString());
        holder.txt1.setText(info.get(position).getMorningSnack().toString());
        holder.diet2.setText(info.get(position).getLaunch().toString());
        holder.diet1.setText(info.get(position).getAfternoonSnack().toString());
        holder.diet3.setText(info.get(position).getDinner().toString());



    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt1,diet1,diet2,diet3;

        public ViewHolder( View itemView) {
            super(itemView);

            txt1 = (TextView)itemView.findViewById(R.id.txt1);


        }
    }
}
