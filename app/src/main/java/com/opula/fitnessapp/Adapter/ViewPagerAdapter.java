package com.opula.fitnessapp.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.opula.fitnessapp.R;

public class ViewPagerAdapter extends PagerAdapter {


    Context context;
    LayoutInflater inflater;
    private Integer [] images = {R.drawable.signup1, R.drawable.signup2, R.drawable.signup3};



    public ViewPagerAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.sliding_images, null);
        ImageView image = (ImageView) view.findViewById(R.id.image);
        image.setImageResource(images[position]);


        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);


    }
}


