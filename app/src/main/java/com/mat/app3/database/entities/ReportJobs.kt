package com.mat.app3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "reportJobs")
data class ReportJobs(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "jobId")
    val id: Int ,
    val activity: String,
    val dateStart: String,
    val dateEnd: String,
    val timeStart: String,
    val timeEnd: String,
    val reportId:String
)