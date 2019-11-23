package com.mat.app3.models;

import java.util.ArrayList;
import java.util.List;

public class ReportTestModel {

    private String email;
    private String ot;
    private String boss;
    private String opName;
    private String date;
    private String turn;
    private float Petroleum;
    private float horometerStart;
    private float horometerEnd;
    private List<Job> jobs;

    public ReportTestModel(){

        this.email="";
        this.ot="";
        this.boss="";
        this.opName="";
        this.date="";
        this.turn="";
        this.Petroleum=0f;
        this.horometerStart=0f;
        this.horometerEnd=0f;
        jobs = new ArrayList<>();

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOt() {
        return ot;
    }

    public void setOt(String ot) {
        this.ot = ot;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public float getPetroleum() {
        return Petroleum;
    }

    public void setPetroleum(float petroleum) {
        Petroleum = petroleum;
    }

    public float getHorometerStart() {
        return horometerStart;
    }

    public void setHorometerStart(float horometerStart) {
        this.horometerStart = horometerStart;
    }

    public float getHorometerEnd() {
        return horometerEnd;
    }

    public void setHorometerEnd(float horometerEnd) {
        this.horometerEnd = horometerEnd;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public class Job {
        private String activity;
        private String dateStart;
        private String dateEnd;
        private String timeStart;
        private String timeEnd;

        private String detail;

        public Job(String Activity){
            this.activity = Activity;
            dateStart ="";
            dateEnd ="";
            timeStart ="";
            timeEnd ="";
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getDateStart() {
            return dateStart;
        }

        public void setDateStart(String dateStart) {
            this.dateStart = dateStart;
        }

        public String getDateEnd() {
            return dateEnd;
        }

        public void setDateEnd(String dateEnd) {
            this.dateEnd = dateEnd;
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
    }

}
