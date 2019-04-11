package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.opula.fitnessapp.POJOClasses.MentorListModel.Info;
import com.opula.fitnessapp.R;
import com.opula.fitnessapp.MentorSubTypeListActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class
MentorTypeListAdapter extends BaseAdapter {


    private Context context; //context
    private ArrayList<Info> data = new ArrayList<>();
    LayoutInflater inflater;

    ProgressBar progressBar;



    //public constructor
    public MentorTypeListAdapter(Context context) {
        this.context = context;
//        this.data = items;
        inflater = LayoutInflater.from(this.context);

    }
    @Override
    public int getCount() {
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


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_mentor, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }


        mViewHolder.tvMentorName.setText(data.get(position).getName());




        Picasso.with(context)
                .load(R.drawable.persnoltrainer)
                .into(mViewHolder.ivMentor);


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

        @BindView(R.id.tvMentorName)
        TextView tvMentorName;



        public MyViewHolder(final View view) {

            ButterKnife.bind(this, view);

            tvMentorName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//
//                    progressBar = (ProgressBar)view.findViewById(R.id.progressBar);
//                    progressBar.setVisibility(View.VISIBLE);
//




                    Intent intent = new Intent(context, MentorSubTypeListActivity.class);
                    intent.putExtra("mentorTypeID", data.get(0).getMentorID());
                    intent.putExtra("mentorName", data.get(0).getName());
                    context.startActivity(intent);




                }
            });
        }
    }

}