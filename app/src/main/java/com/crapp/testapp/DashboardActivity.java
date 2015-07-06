package com.crapp.testapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


public class DashboardActivity extends Activity {

    private ListView classroomListView;

    private Button btnNewClassroom;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnNewClassroom=(Button)findViewById(R.id.add_classroom_button);
        btnNewClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this,AddClassroomActivity.class);
                startActivity(i);
            }
        });



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
        databaseHandler = new DatabaseHandler(DashboardActivity.this);
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

    @Override
    protected void onResume() {
        super.onResume();
    }
}
