package com.crapp.testapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


public class DashboardActivity extends Activity {

    private ListView classroomListView;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.default_classroom_image);
        String imageDirectory = Environment.getExternalStorageDirectory().getPath() + "/TestApp";
        File directory = new File(imageDirectory);
        directory.mkdirs();
        File file = new File(imageDirectory,"defaultClassroomImage.png");
        if (!file.exists()){
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
                outputStream.flush();
                outputStream.close();
            }catch (Exception e){
                e.printStackTrace();
                Log.e("WTF", e.toString());
            }
        }
        classroomListView = (ListView) findViewById(R.id.classroom_listview);

        List<Classroom> classroomListItems = databaseHandler.getAllClassroom();

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
