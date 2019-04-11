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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;

    List<Info> data;

    public RecyclerAdapter(Context context, List<Info> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int position) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.diet_detail_layout, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {



        holder.txt1.setText(data.get(position).getBreakfast().toString());
        holder.txt1.setText(data.get(position).getMorningSnack().toString());
        holder.diet2.setText(data.get(position).getLaunch().toString());
        holder.diet1.setText(data.get(position).getAfternoonSnack().toString());
        holder.diet3.setText(data.get(position).getDinner().toString());



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt1,diet1,diet2,diet3;

        public ViewHolder( View itemView) {
            super(itemView);

            txt1 = (TextView)itemView.findViewById(R.id.txt1);
            diet1 = (TextView)itemView.findViewById(R.id.diet1);
            diet2 = (TextView)itemView.findViewById(R.id.diet2);
            diet3 = (TextView)itemView.findViewById(R.id.diet3);


        }
    }
}
