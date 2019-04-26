package com.opula.fitnessapp.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.Foodlist.AfternoonSnack;
import com.opula.fitnessapp.POJOClasses.Foodlist.Breakfast;
import com.opula.fitnessapp.POJOClasses.Foodlist.Dinner;
import com.opula.fitnessapp.POJOClasses.Foodlist.Foodlist;
import com.opula.fitnessapp.POJOClasses.Foodlist.Info;
import com.opula.fitnessapp.POJOClasses.Foodlist.Launch;
import com.opula.fitnessapp.POJOClasses.Foodlist.MorningSnack;
import com.opula.fitnessapp.R;

import java.util.List;


public  class DialogMainDietPlanAdapter extends RecyclerView.Adapter<DialogMainDietPlanAdapter.ViewHolder> {

   private String TAG ="DialogMainDietPlanAdapter" ;
    Context context;
    LayoutInflater inflater;

    private  List<Foodlist> foodlist;
    private List<Info> listMainfoodlist;

    private      List<Breakfast> breaklist ;
    private    List<AfternoonSnack> afternoonSnackList;
    private    List<Dinner> dinnerList;
    private   List<MorningSnack> morningSnackList ;
    private List<Launch> launchList ;
    private  String strFoodID;
    AlertDialog alertDialog;


    public DialogMainDietPlanAdapter(Context context, List<Info> listMainfoodlist, List<Foodlist> foodlist,String strFoodID) {


        this.context = context;
        this.foodlist = foodlist;
        this.listMainfoodlist = listMainfoodlist;
        this.strFoodID = strFoodID;

        if(strFoodID.equalsIgnoreCase("1"))
        {
            breaklist=listMainfoodlist.get(0).getBreakfast();
        }else if(strFoodID.equalsIgnoreCase("2"))
        {
            morningSnackList=listMainfoodlist.get(1).getMorningSnack();
        }

        else if(strFoodID.equalsIgnoreCase("3"))
        {
            launchList=listMainfoodlist.get(2).getLaunch();
        }
        else if(strFoodID.equalsIgnoreCase("4"))
        {
            afternoonSnackList=listMainfoodlist.get(3).getAfternoonSnack();
        }
        else if(strFoodID.equalsIgnoreCase("5"))
        {
            dinnerList=listMainfoodlist.get(4).getDinner();
        }

        Log.d(TAG,"kajal the break fast in adapter we have is "+listMainfoodlist.size());

        Log.d(TAG,"kajal the food list in adapter we have is "+foodlist.size());


    }


    @NonNull
    @Override

    public ViewHolder onCreateViewHolder( ViewGroup parent, int position) {



        View itemView = inflater.from(parent.getContext()).inflate(R.layout.dialog_foodlist, parent, false);

        return new ViewHolder(itemView);



    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position ){


        Log.d(TAG,"jigar the clicked food id is "+strFoodID);



        if(strFoodID.equals("1"))
        {
            final Breakfast info = breaklist.get(position);


                Log.d(TAG,"jigar the break fast list have is "+info.getFoodName());
                Log.d(TAG,"jigar the break fast name have is "+info.getFoodName());
                holder.txtFoodName.setText(info.getFoodName());
                holder.txtFoodNametwo.setText(info.getFoodCalories());
        }
       else if(strFoodID.equals("2"))
        {
            final MorningSnack info = morningSnackList.get(position);


            Log.d(TAG,"jigar the morning snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the morning snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
        }
        else if(strFoodID.equals("3"))
        {
            final Launch info = launchList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
        }
        else if(strFoodID.equals("4"))
        {
            final AfternoonSnack info = afternoonSnackList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
        }
        else if(strFoodID.equals("5"))
        {
            final Dinner info = dinnerList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
        }


    }

    @Override
    public int getItemCount() {
        if(strFoodID.equalsIgnoreCase("1"))
        {
           return breaklist.size();
        }else if(strFoodID.equalsIgnoreCase("2"))
        {
            return morningSnackList.size();
        }
        else if(strFoodID.equalsIgnoreCase("3"))
        {
            return launchList.size();
        }
        else if(strFoodID.equalsIgnoreCase("4"))
        {
            return afternoonSnackList.size();
        }
        else if(strFoodID.equalsIgnoreCase("5"))
        {
            return dinnerList.size();
        }

        return 0;
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
