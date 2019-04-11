package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.opula.fitnessapp.POJOClasses.subscribe.Info;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

 public class MainSubscribeAdapter extends RecyclerView.Adapter<MainSubscribeAdapter.ViewHolder> {


    Context mContext;
    LayoutInflater inflater;
    List<Info> info ;

    AlertDialog alertDialog;
    LinearLayout linear;
    RecyclerView recycler;


    public MainSubscribeAdapter(Context mContext, List<Info> info) {

        this.mContext = mContext;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.mainsubscribe_recycler, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, final int position) {

        viewHolder.sub1.setText(info.get(position).getName());

        Picasso.with(mContext)
                .load(R.drawable.subscribe)
                .into(viewHolder.imgsubscribe);


       viewHolder.sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "subscribe!",Toast.LENGTH_SHORT).show();

                showDialog(mContext);


            }
        });





    }


    private void showDialog(Context mContext) {


//        linear = (LinearLayout)alertDialog.findViewById(R.id.linear);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext);
        final LayoutInflater inflater = LayoutInflater.from(mContext);
        View dialogView = inflater.inflate(R.layout.dialog_subscribetype, null);
        alertDialogBuilder.setView(dialogView);
        alertDialogBuilder.setCancelable(true);


        alertDialog = alertDialogBuilder.create();


        recycler = (RecyclerView)dialogView.findViewById(R.id.recycler);

        DialogSubscribeAdapter dialogSubscribeAdapter=new DialogSubscribeAdapter(mContext,info);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(horizontalLayoutManager);
        recycler.setAdapter(dialogSubscribeAdapter);



    

        alertDialog.show();



    }

    @Override
    public int getItemCount() {

        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button sub1;
        ImageView imgsubscribe;
        LinearLayout linear;

        public ViewHolder(@NonNull View itemView) {


            super(itemView);

            sub1 = (Button)itemView.findViewById(R.id.sub1);
            imgsubscribe = (ImageView)itemView.findViewById(R.id.imgsubscribe);
            linear = (LinearLayout)itemView.findViewById(R.id.linear);
            recycler = (RecyclerView)itemView.findViewById(R.id.recycler);




        }
    }
}
