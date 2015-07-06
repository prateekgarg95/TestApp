package com.crapp.testapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Classroom {
    private int classroomID;
    private String classroomServerID;
    private String classroomName;
    private String classroomImagePath;
    private String createdAt;
    private String lastUpdateAt;

    public Classroom(){

    }

    public Classroom(int classroomID,String classroomServerID,String classroomName,String classroomImagePath,
                     String createdAt,String lastUpdateAt){
        this.classroomID = classroomID;
        this.classroomServerID = classroomServerID;
        this.classroomName = classroomName;
        this.classroomImagePath = classroomImagePath;
        this.createdAt = createdAt;
        this.lastUpdateAt = lastUpdateAt;
    }

    public Classroom(String classroomName){
        this.classroomName=classroomName;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(calendar.getTime());
        this.createdAt=formattedDate;
        this.lastUpdateAt=formattedDate;
        this.classroomImagePath = Environment.getExternalStorageDirectory().getPath() + "/TestApp/defaultClassroomImage.png";
        this.classroomServerID = randomString(7);
    }

    public String randomString(int length){
        String characters = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i < length; i++ )
            sb.append( characters.charAt( random.nextInt(characters.length()) ) );
        return sb.toString();
    }

    public int getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
    }

    public String getClassroomServerID() {
        return classroomServerID;
    }

    public void setClassroomServerID(String classroomServerID) {
        this.classroomServerID = classroomServerID;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomImagePath() {
        return classroomImagePath;
    }

    public void setClassroomImagePath(String classroomImagePath) {
        this.classroomImagePath = classroomImagePath;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(String lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }
}
