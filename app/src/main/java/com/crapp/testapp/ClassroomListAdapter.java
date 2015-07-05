package com.crapp.testapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClassroomListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;

    private List<Classroom> classroomList;

    public ClassroomListAdapter(Context context,List<Classroom> classrooms){
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        classroomList = classrooms;
    }

    @Override
    public int getCount() {
        return classroomList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if (convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.listitem_classroom,parent,false);
            listViewHolder.textInListView=(TextView)convertView.findViewById(R.id.classroom_name);
            listViewHolder.imageInListView=(ImageView)convertView.findViewById(R.id.classroom_image);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(classroomList.get(position).getClassroomName());

        return null;
    }

    static class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;

    }
}
