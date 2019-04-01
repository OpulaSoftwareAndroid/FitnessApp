package com.opula.fitnessapp.mentorListScreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.opula.fitnessapp.POJOClasses.MentorListModel.Info;
import com.opula.fitnessapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MentorListAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Info> data = new ArrayList<>(); //data source of the list adapter
    LayoutInflater inflater;

    //public constructor 
    public MentorListAdapter(Context context) {
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

        // inflate the layout for each list row
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_mentor, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        // get current item to be displayed
//        Item currentItem = (Item) getItem(position);

        // get the TextView for item name and item description
//        TextView textViewItemName = (TextView)
//                convertView.findViewById(R.id.text_view_item_name);
//        TextView textViewItemDescription = (TextView)
//                convertView.findViewById(R.id.text_view_item_description);

        //sets the text for item name and item description from the current item object
        mViewHolder.tvMentorName.setText(data.get(position).getName());
//        textViewItemDescription.setText(currentItem.getItemDescription());

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

        @BindView(R.id.tvMentorName)
        TextView tvMentorName;

        public MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}