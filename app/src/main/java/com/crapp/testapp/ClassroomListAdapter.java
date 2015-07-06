package com.crapp.testapp;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClassroomListAdapter extends BaseAdapter {
    Context context;

    LayoutInflater layoutInflater;

    protected List<Classroom> classroomList;

    public ClassroomListAdapter(Context context,List<Classroom> classroomList){
        this.classroomList=classroomList;
        this.layoutInflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getCount() {
        return classroomList.size();
    }

    @Override
    public Object getItem(int position) {
        return classroomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return classroomList.get(position).getClassroomID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if (convertView == null){
            listViewHolder = new ViewHolder();
            convertView = this.layoutInflater.inflate(R.layout.listitem_classroom,parent,false);
            listViewHolder.classroom_name=(TextView)convertView.findViewById(R.id.classroom_name);
            listViewHolder.classroom_last_updated=(TextView)convertView.findViewById(R.id.last_updated);
            listViewHolder.classroom_image=(ImageView)convertView.findViewById(R.id.classroom_image);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        Classroom classroom = classroomList.get(position);
        listViewHolder.classroom_name.setText(classroomList.get(position).getClassroomName());
        listViewHolder.classroom_last_updated.setText(classroomList.get(position).getClassroomServerID());
        Bitmap bitmap = BitmapFactory.decodeFile(classroomList.get(position).getClassroomImagePath());
        listViewHolder.classroom_image.setImageBitmap(bitmap);

        return convertView;
    }

    static class ViewHolder{
        TextView classroom_name;
        ImageView classroom_image;
        TextView classroom_last_updated;

    }
}
