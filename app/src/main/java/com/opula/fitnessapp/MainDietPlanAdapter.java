package com.opula.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.opula.fitnessapp.POJOClasses.Foodlist.Info;

import java.util.List;

class MainDietPlanAdapter extends RecyclerView.Adapter<MainDietPlanAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Info> infodata ;

    public MainDietPlanAdapter(Context context, List<Info> infodata) {
        this.context = context;

        this.infodata = infodata;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {



        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
