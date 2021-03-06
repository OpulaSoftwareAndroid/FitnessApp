package com.opula.fitnessapp.Adapter;

import android.app.ActionBar;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import java.util.Objects;

public class MealTypeListAdapter extends RecyclerView.Adapter<MealTypeListAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<Info> listfoodlist ;

    ArrayList <String>arrayListFoodID;
    String type;


    AlertDialog alertDialog;
    RecyclerView  recylerViewDietFoodTypeList;


    List<Foodlist> foodlist = new ArrayList<>();

    List<Breakfast> breaklist = new ArrayList<>();
    List<AfternoonSnack> afterlist = new ArrayList<>();
    List<Dinner> dinnerList = new ArrayList<>();
    List<MorningSnack> morningSnackList = new ArrayList<>();
    List<Launch> launchList = new ArrayList<>();
    String TAG = "MealTypeListAdapter";
    private int animationSource;
    Button btnSubmitDiet;


    public MealTypeListAdapter(Context context, List<Info> listfoodlist,Button btnSubmitDiet) {

        this.context = context;
        this.listfoodlist = listfoodlist;
        arrayListFoodID=new ArrayList<>();
        this.btnSubmitDiet=btnSubmitDiet;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {


        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_dietplan, viewGroup, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final Info info = listfoodlist.get(position);

        viewHolder.btnFood.setText(info.getName());

        if(!arrayListFoodID.contains(info.getFoodID()))
        {
            arrayListFoodID.add(info.getFoodID());
        }

        viewHolder.btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG,"jigar the clickes item is "+ info.getFoodID());
                showDialog(context,listfoodlist,foodlist,info.getFoodID(),btnSubmitDiet);

            }
        });

    }



    private void showDialog(Context context, List<Info> listfoodlist ,List<Foodlist> foodlist,String strFoodID,Button btnSubmitDiet) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        final LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.dialog_dietplan_recycler, null);
        alertDialogBuilder.setView(dialogView);
        alertDialogBuilder.setCancelable(true);

        alertDialog = alertDialogBuilder.create();

        recylerViewDietFoodTypeList = (RecyclerView) dialogView.findViewById(R.id.recylerViewDietFoodTypeList);
        LinearLayout linearLayoutAddUpdateFood=dialogView.findViewById(R.id.linearLayoutAddUpdateFood);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(context).getApplicationContext());

        linearLayoutManager.setStackFromEnd(true);
        recylerViewDietFoodTypeList.setLayoutManager(linearLayoutManager);

        DialogMainDietPlanAdapter dialogMainDietPlanAdapter = new DialogMainDietPlanAdapter(context, listfoodlist
                , foodlist,strFoodID,linearLayoutAddUpdateFood,btnSubmitDiet,alertDialog);
        recylerViewDietFoodTypeList.setAdapter(dialogMainDietPlanAdapter);

        dialogMainDietPlanAdapter.notifyDataSetChanged();

        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams param = window.getAttributes();
        param.gravity = Gravity.CENTER;
        param.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;

        alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        window.setAttributes(param);
        window.setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(animationSource);

        alertDialog.show();


    }


    @Override
    public int getItemCount() {

        return listfoodlist.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {



        TextView txtFoodName,txtFoodNametwo,txtname;
        CheckBox chk1 ;
        Button btnFood ;
        Button btnSubmit;
        RecyclerView diet_recycler,recycler_dialog,dialog_diet_recycler;

        public ViewHolder(@NonNull View itemView)  {
            super(itemView);


            txtFoodName = (TextView)itemView.findViewById(R.id.txtFoodName);
            txtFoodNametwo = (TextView)itemView.findViewById(R.id.txtFoodNametwo);
            txtname = (TextView)itemView.findViewById(R.id.txtname);
            chk1 = (CheckBox)itemView.findViewById(R.id.chk1);

            btnFood = (Button) itemView.findViewById(R.id.btnFood );
            btnSubmit = (Button)itemView.findViewById(R.id.btnSubmit);

            diet_recycler = (RecyclerView)itemView.findViewById(R.id.recylerViewMealType);
            recycler_dialog = (RecyclerView)itemView.findViewById(R.id.recycler_dialog);
            dialog_diet_recycler = (RecyclerView)itemView.findViewById(R.id.recylerViewDietFoodTypeList);







        }


    }
}
