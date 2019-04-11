package com.opula.fitnessapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

class UltimateAdapter extends RecyclerView.Adapter<UltimateAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Ultimatedata> ultimatedata;

    public UltimateAdapter(Context context, List<Ultimatedata> ultimatedata) {
        this.context = context;
        this.ultimatedata = ultimatedata;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.ultimate_layout, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {


        viewHolder.rate.setText(ultimatedata.get(i).getRate());
        Picasso.with(context)
                .load(ultimatedata.get(i).img)
                .into(viewHolder.img);



    }

    @Override
    public int getItemCount() {
        return ultimatedata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView rate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            img = (ImageView)itemView.findViewById(R.id.img);
            rate = (TextView)itemView.findViewById(R.id.rate);
        }
    }
}
