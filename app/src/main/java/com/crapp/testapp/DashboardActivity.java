package com.crapp.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DashboardActivity extends Activity {

    private ListView classroomListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        classroomListView = (ListView) findViewById(R.id.classroom_listview);

        List<Classroom> classroomListItems = new ArrayList<Classroom>();

        classroomListItems.add(new Classroom("Nigeria", R.drawable.default_classroom_image));
        classroomListItems.add(new Classroom("Ghana", R.drawable.default_classroom_image));
        classroomListItems.add(new Classroom("Senegal", R.drawable.default_classroom_image));
        classroomListItems.add(new Classroom("Togo", R.drawable.default_classroom_image));

        classroomListView.setAdapter(new ClassroomListAdapter(this, classroomListItems));
        classroomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // make Toast when click
                Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();

            }

        });
    }
}
