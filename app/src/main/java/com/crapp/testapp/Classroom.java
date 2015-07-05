package com.crapp.testapp;

public class Classroom {
    private String classroomID;
    private String classroomName;
    private int classroomImageID;
    private String createdAt;
    private String lastUpdateAt;



    public Classroom(String classroomName){
        this.classroomName=classroomName;
    }

    public Classroom(String classroomName,int classroomImageID){
        this.classroomName=classroomName;
        this.classroomImageID=classroomImageID;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(String classroomID) {
        this.classroomID = classroomID;
    }

    public int getClassroomImageID() {
        return classroomImageID;
    }

    public void setClassroomImageID(int classroomImageID) {
        this.classroomImageID = classroomImageID;
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
