package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.Foodlist.Breakfast;
import com.opula.fitnessapp.POJOClasses.Foodlist.MorningSnack;
import com.opula.fitnessapp.R;

import java.util.List;

 class MorningsnackAdapter extends RecyclerView.Adapter<MorningsnackAdapter.ViewHolder> {


      List<MorningSnack> morninglist;
     String TAG ="MorningsnackAdapter" ;
    Context context;
    LayoutInflater inflater;



    MorningsnackAdapter(Context context, List<MorningSnack> morninglist) {


        this.context = context;
        this.morninglist = morninglist;


        Log.d(TAG,"kajal the morningsnack list in adapter we have is "+morninglist.size());

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = inflater.from(parent.getContext()).inflate(R.layout.dialog_foodlist, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {


            MorningSnack morningSnack = morninglist.get(position);

            viewHolder.txtFoodName.setText(morningSnack.getFoodName());
            viewHolder.txtFoodNametwo.setText(morningSnack.getFoodCalories());

    }

    @Override
    public int getItemCount() {
        return morninglist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtFoodName,txtFoodNametwo;
        CheckBox chk1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtFoodName = (TextView)itemView.findViewById(R.id.txtFoodName);
            txtFoodNametwo = (TextView)itemView.findViewById(R.id.txtFoodNametwo);
            chk1 = (CheckBox)itemView.findViewById(R.id.chk1);
        }
    }
}
