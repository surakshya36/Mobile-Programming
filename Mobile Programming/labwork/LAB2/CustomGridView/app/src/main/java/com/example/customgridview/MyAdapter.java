package com.example.customgridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyAdapter  extends ArrayAdapter<String> {
    Activity context;
    String[] names;
    String[] prices;
    int[] imgs;
    public MyAdapter(Activity context, String[] names, String[] prices, int[] imgs) {
        super(context, R.layout.list_item, names);
        this.context = context;
        this.names = names;
        this.prices = prices;
        this.imgs = imgs;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.name);
            holder.price = convertView.findViewById(R.id.price);
            holder.img = convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(names[position]);
        holder.price.setText(prices[position]);
        holder.img.setImageResource(imgs[position]);
        return convertView;
    }
    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView img;
    }
}
