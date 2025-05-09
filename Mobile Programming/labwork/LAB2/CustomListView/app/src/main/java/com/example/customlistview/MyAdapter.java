package com.example.customlistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter extends ArrayAdapter<String> {
    Activity context;
    String [] names;
    String[] prices;
    int[] imgs;
    public  MyAdapter (Activity context,String [] names,String[] prices, int[] imgs){
        super(context, R.layout.list_item, names);
        this.context = context;
        this.names= names;
        this.prices= prices;
        this.imgs = imgs;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.list_item, null, true);
        TextView name = v.findViewById(R.id.name);
        TextView price = v.findViewById(R.id.price);
        ImageView img = v.findViewById(R.id.img);
        name.setText(names[position]);
        price.setText(prices[position]);
        img.setImageResource(imgs[position]);
        return v;
    }
}

