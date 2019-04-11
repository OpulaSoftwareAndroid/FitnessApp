package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.DietPlanListModel.Info;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DietPlanVideoAdapter extends RecyclerView.Adapter<DietPlanVideoAdapter.ViewHolder> {


    Context context;
    LayoutInflater inflater;
    List<Info> data ;



    public DietPlanVideoAdapter(Context context, List<Info> data) {
        this.context = context;
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int positon) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.diet_planlist2, viewGroup, false);
        return new ViewHolder(itemView);


    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.desc.setText(data.get(position).getDietPlanName());


        Picasso.with(context)
                .load(R.drawable.video)
                .into(viewHolder.video);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView video;
        TextView desc;


        public ViewHolder( View itemView) {

            super(itemView);

            desc = (TextView)itemView.findViewById(R.id.desc);

            video = (ImageView)itemView.findViewById(R.id.video);
        }

}

}
