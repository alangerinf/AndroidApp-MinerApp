package com.mat.app3.database.Dao

import androidx.room.*
import com.mat.app3.database.entities.Report


@Dao
interface ReportDao {
    @Insert
    fun insert(vararg report: Report)

    @Update
    fun update(vararg report: Report)



    @Delete
    fun delete(vararg report: Report)


    @Query( "SELECT * FROM Report")
    fun selectAll() : List<Report>
}
