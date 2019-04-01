package com.opula.fitnessapp.mentorTypeList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.opula.fitnessapp.POJOClasses.MentorTypeListModel.Info;
import com.opula.fitnessapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MentorTypeListAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Info> data = new ArrayList<>(); //data source of the list adapter
    LayoutInflater inflater;

    //public constructor
    public MentorTypeListAdapter(Context context) {
        this.context = context;
//        this.data = items;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
//        return 10;
        return data.size(); //returns total of items in the list
    }

    @Override
    public Info getItem(int position) {
        return data.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        // inflate the layout for each list row
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_mentor_type, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Picasso.get().load(data.get(position).getImage()).into(mViewHolder.ivMentor);

        mViewHolder.tvName.setText(data.get(position).getName());
        mViewHolder.tvDate.setText(data.get(position).getDOB());
        mViewHolder.tvPrice.setText(context.getString(R.string.Rs) + data.get(position).getPrice());

        // returns the view for the current row
        return convertView;
    }

    public void addAll(ArrayList<Info> listData) {

        if (listData == null)
            return;


        data.clear();
        data.addAll(listData);

        notifyDataSetChanged();


    }

    class MyViewHolder {
        @BindView(R.id.ivMentor)
        RoundedImageView ivMentor;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.tvPrice)
        TextView tvPrice;

        public MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}