package com.crapp.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddClassroomActivity extends Activity {

    private EditText etClassroomName;
    private Button btnAddClassroom;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_classroom);

        etClassroomName=(EditText)findViewById(R.id.classroom_name);
        btnAddClassroom=(Button)findViewById(R.id.add_classroom_button);

        databaseHandler = new DatabaseHandler(AddClassroomActivity.this);

        btnAddClassroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHandler.addClassroom(new Classroom(etClassroomName.getText().toString()));
            }
        });


    }
}
