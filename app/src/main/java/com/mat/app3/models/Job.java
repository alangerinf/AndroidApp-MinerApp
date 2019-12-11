package com.mat.app3.models;

public class Job {

    private int pos;
    private String activity;
    private String timeStart;
    private String timeEnd;
    private String detail;

    public Job(int position,String Activity){
        this.activity = Activity;
        timeStart ="";
        timeEnd ="";
        detail="";
        this.pos = position;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
