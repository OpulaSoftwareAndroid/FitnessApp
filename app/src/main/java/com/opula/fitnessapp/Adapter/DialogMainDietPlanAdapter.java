package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.opula.fitnessapp.POJOClasses.Foodlist.AfternoonSnack;
import com.opula.fitnessapp.POJOClasses.Foodlist.Breakfast;
import com.opula.fitnessapp.POJOClasses.Foodlist.Dinner;
import com.opula.fitnessapp.POJOClasses.Foodlist.Foodlist;
import com.opula.fitnessapp.POJOClasses.Foodlist.Info;
import com.opula.fitnessapp.POJOClasses.Foodlist.Launch;
import com.opula.fitnessapp.POJOClasses.Foodlist.MorningSnack;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
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
    private  LinearLayout linearLayoutAddUpdateFood;
    private  String strFoodID;
    android.support.v7.app.AlertDialog alertDialog;
    Button btnSubmitDiet;
    private ArrayList <String> arrayListBreakFastSelected=new ArrayList<>();
    private ArrayList <String> arrayListMorningSnackSelected=new ArrayList<>();
    private ArrayList <String> arrayListLunchSelected=new ArrayList<>();
    private ArrayList <String> arrayListAfterNoonSnackSelected=new ArrayList<>();
    private ArrayList <String> arrayListDinnerSelected=new ArrayList<>();


    public DialogMainDietPlanAdapter(Context context, List<Info> listMainfoodlist
            , List<Foodlist> foodlist, String strFoodID, LinearLayout linearLayoutAddUpdateFood, Button btnSubmitDiet, AlertDialog alertDialog) {

        this.context = context;
        this.foodlist = foodlist;
        this.listMainfoodlist = listMainfoodlist;
        this.strFoodID = strFoodID;
        this.linearLayoutAddUpdateFood=linearLayoutAddUpdateFood;
        this.btnSubmitDiet=btnSubmitDiet;
        this.alertDialog=alertDialog;
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

        Log.d(TAG,"jigar the break fast in adapter we have is "+listMainfoodlist.size());

        Log.d(TAG,"jigar the food list in adapter we have is "+foodlist.size());


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


                holder.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (isChecked)
                        {
                            if(!arrayListBreakFastSelected.contains(info.getFoodDetailID())) {
                                arrayListBreakFastSelected.add(info.getFoodDetailID());
                                Toast.makeText(context, "jigar the selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                            }
                        }else
                        {
                            if(arrayListBreakFastSelected.contains(info.getFoodDetailID())) {
                                arrayListBreakFastSelected.remove(info.getFoodDetailID());
                                Toast.makeText(context, "jigar the un selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                });
          addFoodToMeal(arrayListBreakFastSelected);

        }
       else if(strFoodID.equals("2"))
        {
            final MorningSnack info = morningSnackList.get(position);


            Log.d(TAG,"jigar the morning snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the morning snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());


            holder.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked)
                    {
                        if(!arrayListMorningSnackSelected.contains(info.getFoodDetailID())) {
                            arrayListMorningSnackSelected.add(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }else
                    {
                        if(arrayListMorningSnackSelected.contains(info.getFoodDetailID())) {
                            arrayListMorningSnackSelected.remove(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the un selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

            });

            addFoodToMeal(arrayListMorningSnackSelected);

        }
        else if(strFoodID.equals("3"))
        {
            final Launch info = launchList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());


            holder.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked)
                    {
                        if(!arrayListLunchSelected.contains(info.getFoodDetailID())) {
                            arrayListLunchSelected.add(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }else
                    {
                        if(arrayListLunchSelected.contains(info.getFoodDetailID())) {
                            arrayListLunchSelected.remove(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the un selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

            });

            addFoodToMeal(arrayListLunchSelected);

        }

        else if(strFoodID.equals("4"))
        {
            final AfternoonSnack info = afternoonSnackList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
            holder.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked)
                    {
                        if(!arrayListAfterNoonSnackSelected.contains(info.getFoodDetailID())) {
                            arrayListAfterNoonSnackSelected.add(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }else
                    {
                        if(arrayListAfterNoonSnackSelected.contains(info.getFoodDetailID())) {
                            arrayListAfterNoonSnackSelected.remove(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the un selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

            });

            addFoodToMeal(arrayListAfterNoonSnackSelected);


        }
        else if(strFoodID.equals("5"))
        {
            final Dinner info = dinnerList.get(position);


            Log.d(TAG,"jigar the lunch snack list have is "+info.getFoodName());
            Log.d(TAG,"jigar the lunch snack name have is "+info.getFoodName());

            holder.txtFoodName.setText(info.getFoodName());
            holder.txtFoodNametwo.setText(info.getFoodCalories());
            holder.chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked)
                    {
                        if(!arrayListDinnerSelected.contains(info.getFoodDetailID())) {
                            arrayListDinnerSelected.add(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }else
                    {
                        if(arrayListDinnerSelected.contains(info.getFoodDetailID())) {
                            arrayListDinnerSelected.remove(info.getFoodDetailID());
                            Toast.makeText(context, "jigar the un selected is " + info.getFoodName(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

            });

            addFoodToMeal(arrayListDinnerSelected);
        }


        btnSubmitDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"hello i  m clicked from adapter",Toast.LENGTH_LONG).show();
                Log.d(TAG,"jigar the added break fast list we have is "+arrayListBreakFastSelected.toString());
                Log.d(TAG,"jigar the added morning snack have  have is "+arrayListMorningSnackSelected.toString());
                Log.d(TAG,"jigar the added lunch in list we have is "+arrayListLunchSelected.toString());
                Log.d(TAG,"jigar the added after noon in list we have is "+arrayListAfterNoonSnackSelected.toString());
                Log.d(TAG,"jigar the added dinner in list we have is "+arrayListDinnerSelected.toString());

            }
        });
    }

    public void addFoodToMeal(final ArrayList<String> arrayListFoodToMealList)
    {
        linearLayoutAddUpdateFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"jigar the added in list we have is "+arrayListFoodToMealList.toString());
                alertDialog.dismiss();

            }
        });
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
