package com.mat.app3.Report

import android.content.Context
import android.util.Log
import com.mat.app3.database.MyDatabase
import com.mat.app3.database.entities.Report
import com.mat.app3.models.Job

import java.util.ArrayList

object parseToListJobs {

    fun parse(report: Report): List<Job> {
        val jobArrayList = ArrayList<Job>()

        if (!report.trab1.isEmpty()) {
            val temp = Job(1, report.trab1)

            temp.timeStart = report.trab1_hStart
            temp.timeEnd = report.trab1_hEnd
            temp.detail = report.trab1_detail

            jobArrayList.add(temp)
        }

        if (!report.trab2.isEmpty()) {
            val temp = Job(2, report.trab2)

            temp.timeStart = report.trab2_hStart
            temp.timeEnd = report.trab2_hEnd
            temp.detail = report.trab2_detail

            jobArrayList.add(temp)
        }

        if (!report.trab3.isEmpty()) {

            val temp = Job(3, report.trab3)


            temp.timeStart = report.trab3_hStart
            temp.timeEnd = report.trab3_hEnd
            temp.detail = report.trab3_detail


            jobArrayList.add(temp)
        }

        if (!report.trab4.isEmpty()) {

            val temp = Job(4, report.trab4)



            temp.timeStart = report.trab4_hStart
            temp.timeEnd = report.trab4_hEnd
            temp.detail = report.trab4_detail



            jobArrayList.add(temp)
        }

        if (!report.trab5.isEmpty()) {

            val temp = Job(5, report.trab5)

            temp.timeStart = report.trab5_hStart
            temp.timeEnd = report.trab5_hEnd
            temp.detail = report.trab5_detail

            jobArrayList.add(temp)
        }

        if (!report.trab6.isEmpty()) {

            val temp = Job(6, report.trab6)

            temp.timeStart = report.trab6_hStart
            temp.timeEnd = report.trab6_hEnd
            temp.detail = report.trab6_detail

            jobArrayList.add(temp)
        }

        return jobArrayList
    }


    fun guardar(ctx : Context, jobList: List<Job>) {


        val list = ArrayList<Int>()

        for( i in 0.. jobList.size-1){

            if(jobList.get(i).pos==1){
                list.add(1)
                    val temp = jobList.get(i)
                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)
                    report.trab1 = temp.activity
                    report.trab1_hStart = temp.timeStart
                    report.trab1_hEnd = temp.timeEnd
                    report.trab1_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())
                    db.reportDao().update(report)
            }

            if(jobList.get(i).pos==2){
                list.add(2)
                    val temp = jobList.get(i)

                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)
                    report.trab2 = temp.activity
                    report.trab2_hStart = temp.timeStart
                    report.trab2_hEnd = temp.timeEnd
                    report.trab2_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())
                    db.reportDao().update(report)

            }

            if(jobList.get(i).pos==3){
                list.add(3)
                    val temp = jobList.get(i)
                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)
                    report.trab3 = temp.activity
                    report.trab3_hStart = temp.timeStart
                    report.trab3_hEnd = temp.timeEnd
                    report.trab3_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())
                    db.reportDao().update(report)

            }


            if(jobList.get(i).pos==4){
                list.add(4)
                    val temp = jobList.get(i)
                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)
                    report.trab4 = temp.activity
                    report.trab4_hStart = temp.timeStart
                    report.trab4_hEnd = temp.timeEnd
                    report.trab4_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())
                    db.reportDao().update(report)
            }

            if(jobList.get(i).pos==5){
                list.add(5)
                    val temp = jobList.get(i)
                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)

                    report.trab5 = temp.activity
                    report.trab5_hStart = temp.timeStart
                    report.trab5_hEnd = temp.timeEnd
                    report.trab5_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())
                    db.reportDao().update(report)

            }
            if(jobList.get(i).pos==6){
                list.add(6)
                    val temp = jobList.get(i)
                    val db = MyDatabase.getInstance(ctx)
                    var report = db.reportDao().selectAll().get(0)
                    report.trab6 = temp.activity
                    report.trab6_hStart = temp.timeStart
                    report.trab6_hEnd = temp.timeEnd
                    report.trab6_detail = temp.detail
                    Log.i("asd",""+i+" "+report.toString())

                    db.reportDao().update(report)

            }
        }


        for(index in 1..6) {

            var flag = false// si no se encuentra

            for (i in 0..list.size - 1) {

                if (list.get(i) == index) {
                    flag = true//si esta
                    break
                }
            }

            if (!flag) { //so no esta

                Log.i("asd","no estubo"+index)
                if (index == 1) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab1 = ""
                        report.trab1_hStart = ""
                        report.trab1_hEnd = ""
                        report.trab1_detail = ""
                        db.reportDao().update(report)
                }
                if (index == 2) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab2 = ""
                        report.trab2_hStart = ""
                        report.trab2_hEnd = ""
                        report.trab2_detail = ""
                        db.reportDao().update(report)
                }
                if (index == 3) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab3 = ""
                        report.trab3_hStart = ""
                        report.trab3_hEnd = ""
                        report.trab3_detail = ""
                        db.reportDao().update(report)
                }

                if (index == 4) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab3 = ""
                        report.trab4_hStart = ""
                        report.trab4_hEnd = ""
                        report.trab4_detail = ""
                        db.reportDao().update(report)
                }

                if (index == 5) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab5 = ""
                        report.trab5_hStart = ""
                        report.trab5_hEnd = ""
                        report.trab5_detail = ""
                        db.reportDao().update(report)
                }

                if (index == 6) {
                        val db = MyDatabase.getInstance(ctx)
                        var report = db.reportDao().selectAll().get(0)
                        report.trab6 = ""
                        report.trab6_hStart = ""
                        report.trab6_hEnd = ""
                        report.trab6_detail = ""
                        db.reportDao().update(report)
                }
            }
        }
    }
}
