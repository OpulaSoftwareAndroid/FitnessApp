package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.opula.fitnessapp.POJOClasses.Subscribe.Info;
import com.opula.fitnessapp.R;

import java.util.List;

public class DialogSubscribeAdapter extends RecyclerView.Adapter<DialogSubscribeAdapter.ViewHolder> {

    Context mContext;
    LayoutInflater inflater;
    List<Info> info ;


    public DialogSubscribeAdapter(Context mContext,  List<Info> info) {
        this.mContext = mContext;
        this.info = info;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = inflater.from(viewGroup.getContext()).inflate(R.layout.subscribe_list, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int position) {



        viewHolder.txtsubId.setText(info.get(position).getSubscribeID());
        viewHolder.txtname.setText(info.get(position).getName());
        viewHolder.txtplantype.setText(info.get(position).getPlanType());
        viewHolder.txtmembershipTypename.setText(info.get(position).getPlanTypeName());
        viewHolder.txtmembership.setText(info.get(position).getMembershipType());
        viewHolder.txtplantypename.setText(info.get(position).getPlanTypeName());
        viewHolder.txtprice.setText(info.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return info.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditText txtname, txtplantype, txtmembership, txtprice, txtplantypename, txtmembershipTypename,txtsubId;

        public ViewHolder( View itemView) {
            super(itemView);


             txtsubId = itemView.findViewById(R.id.textViewSubjectID);
              txtname = itemView.findViewById(R.id.txtname);
              txtplantype = itemView.findViewById(R.id.textViewPlanType);
              txtprice = itemView.findViewById(R.id.textViewPrice);
              txtmembership = itemView.findViewById(R.id.textViewMemberShipType);
              txtplantypename = itemView.findViewById(R.id.textViewPlanTypeName);
              txtmembershipTypename = itemView.findViewById(R.id.textViewMembershipTypeName);



        }
    }
}
