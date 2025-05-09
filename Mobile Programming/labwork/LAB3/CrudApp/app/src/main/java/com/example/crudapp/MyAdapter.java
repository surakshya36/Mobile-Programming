package com.example.crudapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
public class MyAdapter extends ArrayAdapter<Student> {
    private final Context context;
    private final List<Student> arrayListStudent;
    public MyAdapter(@NonNull Context context, List<Student> arrayListStudent) {
        super(context, R.layout.display_list, arrayListStudent);
        this.context = context;
        this.arrayListStudent = arrayListStudent;
    }
    private static class ViewHolder {
        TextView stu_id;
        TextView Name;
        TextView Roll;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.display_list, parent, false);
            holder = new ViewHolder();
            holder.stu_id = convertView.findViewById(R.id.stu_id);
            holder.Name = convertView.findViewById(R.id.Name);
            holder.Roll = convertView.findViewById(R.id.Roll);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Student student = arrayListStudent.get(position);
        holder.stu_id.setText(student.getId());
        holder.Name.setText(student.getName());
        holder.Roll.setText(student.getRoll());
        return convertView;
    }
}
