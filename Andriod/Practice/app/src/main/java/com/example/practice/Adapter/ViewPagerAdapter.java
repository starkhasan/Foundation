package com.example.practice.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.practice.R;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<Integer> listImage;
    public ViewPagerAdapter(Context context, ArrayList<Integer> listImage) {
        this.context=context;
        this.listImage=listImage;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_viewpager,container,false);
        ImageView imageView;
        LinearLayout layout;
        imageView=view.findViewById(R.id.imageAdapter);
        imageView.setImageResource(listImage.get(position));
        container.addView(view, 0);
        return view;
    }


    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
