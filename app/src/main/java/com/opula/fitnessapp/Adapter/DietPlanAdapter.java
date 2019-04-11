package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.opula.fitnessapp.POJOClasses.DietPlanListModel.Info;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DietPlanAdapter extends RecyclerView.Adapter<DietPlanAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Info> data;



    public DietPlanAdapter(Context context,  List<Info> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.diet_planlist, viewGroup, false);

        return new DietPlanAdapter.ViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {

        viewHolder.btndiet.setText(data.get(position).getDietPlanName());


        Picasso.with(context)
                .load(data.get(position).getImg())
                .into(viewHolder.img);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btndiet;
        ImageView img;



        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            btndiet = (Button)itemView.findViewById(R.id.btndiet);
            img = (ImageView)itemView.findViewById(R.id.img);

        }
    }
}
