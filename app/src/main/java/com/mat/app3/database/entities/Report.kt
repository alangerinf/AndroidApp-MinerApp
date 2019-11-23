package com.mat.app3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report")
data class Report(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "reportId")
    val id: Int ,
    val email: String,
    val ot: String,
    val boss: String,
    val opName: String,
    val date: String,
    val turn: String,
    val Petroleum: Float,
    val horometerStart: Float,
    val horometerEnd: Float

)