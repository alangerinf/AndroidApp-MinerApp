package com.mat.app3.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "report")
data class Report(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "reportId")
    var id: Int =0,
    var email: String = "",
    var ot: String = "",
    var boss: String ="",
    var opName: String = "",
    var date: String = "",
    var numEquipo: String = "",
    var turn: String = "",
    var Petroleum: Float = 0f,
    var horometerStart: Float = 0f,
    var horometerEnd: Float = 0f,

    var trab1: String = "",
    var trab1_hStart: String = "",
    var trab1_hEnd: String = "",
    var trab1_detail: String = "",

    var trab2: String = "",
    var trab2_hStart: String = "",
    var trab2_hEnd: String = "",
    var trab2_detail: String = "",


    var trab3: String = "",
    var trab3_hStart: String = "",
    var trab3_hEnd: String = "",
    var trab3_detail: String = "",

    var trab4: String = "",
    var trab4_hStart: String = "",
    var trab4_hEnd: String = "",
    var trab4_detail: String= "",

    var trab5: String= "",
    var trab5_hStart: String= "",
    var trab5_hEnd: String= "",
    var trab5_detail: String= "",

    var trab6: String= "",
    var trab6_hStart: String= "",
    var trab6_hEnd: String= "",
    var trab6_detail: String= ""

)