package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.opula.fitnessapp.POJOClasses.PlanScheduleListModel.Info;
import com.opula.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

class PlanListAdapter extends BaseAdapter {


    Context context;
    List<Info> plandata = new ArrayList<>();
    LayoutInflater inflater;
    String strRegisterID;

    String Price;
    String TAG = "MentorSubTypeListActivity";


    public PlanListAdapter(Context context, List<Info> plandata) {
        this.context = context;
        this.plandata = plandata;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return plandata.size();
    }

    @Override
    public Object getItem(int position) {
        return plandata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.plan_list, parent, false);

            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }


        mViewHolder.txtplanid.setText(plandata.get(position).getPlanScheduleID());
        mViewHolder.txtperiod.setText(plandata.get(position).getPeriod());



        return convertView;


    }

    public void addAll(ArrayList<Info> listData) {


        if (listData == null)
            return;


        plandata.clear();
        plandata.addAll(listData);

        notifyDataSetChanged();


    }

    class MyViewHolder {


        ListView list;
        TextView txtplanid,txtperiod;

        public MyViewHolder(View view) {

            list = (ListView)view.findViewById(R.id.list);
            txtplanid = (TextView)view.findViewById(R.id.txtplanid);
            txtperiod = (TextView)view.findViewById(R.id.txtperiod);

        }
    }
}