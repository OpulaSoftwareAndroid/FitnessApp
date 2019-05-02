package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.AfternoonSnack;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.Breakfast;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.Dinner;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.Info;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.Lunch;
import com.opula.fitnessapp.POJOClasses.KnowYourDietPlanModel.MorningSnack;
import com.opula.fitnessapp.R;
import java.util.List;

public class KnowYourDietPlanAdapter extends RecyclerView.Adapter<KnowYourDietPlanAdapter.ViewHolder> {

    Context context;
    String TAG="KnowYourDietPlanAdapter";
    LayoutInflater inflater;
    List<Info> data;

    public KnowYourDietPlanAdapter(Context context, List<Info> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(
                R.layout.know_your_diet_detail_item
                , viewGroup, false);

        return new KnowYourDietPlanAdapter.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {

        Log.d(TAG,"jigar the data adapter we have is "+data.size());
                viewHolder.textViewMealName.setText("" + data.get(position).getName());
                if(position==0) {

                    List<Breakfast> breakfastList=data.get(position).getBreakfast();
                    String strBreakFastName="";

                    for(int i=0;i<breakfastList.size();i++) {
                        if(i==0) {
                            strBreakFastName = strBreakFastName + breakfastList.get(i).getBreakFastFoodName()
                                    +" "+breakfastList.get(i).getBreakFastFoodCalories() +" cal";
                        }else
                        {
                            strBreakFastName = strBreakFastName +"\n" + breakfastList.get(i).getBreakFastFoodName()
                                    +" "+breakfastList.get(i).getBreakFastFoodCalories()+" cal";

                        }
                    }
                    viewHolder.textViewFoodName.setText(strBreakFastName);

                }

        if(position==1) {

            List<MorningSnack> breakfastList=data.get(position).getMorningSnack();
            String strBreakFastName="";

            for(int i=0;i<breakfastList.size();i++) {
                if(i==0) {
                    strBreakFastName = strBreakFastName + breakfastList.get(i).getMorningSnackFoodName()
                            +" "+breakfastList.get(i).getMorningSnackFoodCalories() +" cal";
                }else
                {
                    strBreakFastName = strBreakFastName +"\n" + breakfastList.get(i).getMorningSnackFoodName()
                            +" "+breakfastList.get(i).getMorningSnackFoodCalories()+" cal";

                }
            }
            viewHolder.textViewFoodName.setText(strBreakFastName);
        }
        if(position==2) {

            List<Lunch> breakfastList=data.get(position).getLunch();
            String strBreakFastName="";

            for(int i=0;i<breakfastList.size();i++) {
                if(i==0) {
                    strBreakFastName = strBreakFastName + breakfastList.get(i).getLaunchFoodName()
                            +" "+breakfastList.get(i).getLaunchFoodCalories() +" cal";
                }else
                {
                    strBreakFastName = strBreakFastName +"\n" + breakfastList.get(i).getLaunchFoodName()
                            +" "+breakfastList.get(i).getLaunchFoodCalories()+" cal";

                }
            }
            viewHolder.textViewFoodName.setText(strBreakFastName);
        }
        if(position==3) {

            List<AfternoonSnack> breakfastList=data.get(position).getAfternoonSnack();
            String strBreakFastName="";

            for(int i=0;i<breakfastList.size();i++) {
                if(i==0) {
                    strBreakFastName = strBreakFastName + breakfastList.get(i).getAfternoonSnackFoodName()
                            +" "+breakfastList.get(i).getAfternoonSnackFoodCalories() +" cal";
                }else
                {
                    strBreakFastName = strBreakFastName +"\n" + breakfastList.get(i).getAfternoonSnackFoodName()
                            +" "+breakfastList.get(i).getAfternoonSnackFoodCalories()+" cal";

                }
            }
            viewHolder.textViewFoodName.setText(strBreakFastName);
        }
        if(position==4) {

            List<Dinner> breakfastList=data.get(position).getDinner();
            String strBreakFastName="";

            for(int i=0;i<breakfastList.size();i++) {
                if(i==0) {
                    strBreakFastName = strBreakFastName + breakfastList.get(i).getDinnerFoodName()
                            +" "+breakfastList.get(i).getDinnerFoodCalories() +" cal";
                }else
                {
                    strBreakFastName = strBreakFastName +"\n" + breakfastList.get(i).getDinnerFoodName()
                            +" "+breakfastList.get(i).getDinnerFoodCalories()+" cal";

                }
            }
            viewHolder.textViewFoodName.setText(strBreakFastName);
        }


        //           viewHolder.textViewMealName.getBackground().setAlpha(50);
//        viewHolder.btndiet.setText(data.get(position).getAfternoonSnack());

        //        Picasso.with(context)
//                .load(data.get(position).getImg())
//                .into(viewHolder.imageViewDietImage);
//
//
//        viewHolder.linearLayoutDietPlanList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, MainKnowYourDietPlanActivity.class);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewMealName,textViewFoodName;
        LinearLayout linearLayoutDietPlanList;





        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            textViewMealName=itemView.findViewById(R.id.textViewMealName);
            textViewFoodName=itemView.findViewById(R.id.textViewFoodName);



        }
    }
}
