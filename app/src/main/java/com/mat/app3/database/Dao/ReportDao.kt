package com.mat.app3.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import androidx.room.OnConflictStrategy
import com.mat.app3.database.entities.Report


@Dao
interface ReportDao {
    @Insert
    fun insert(vararg report: Report)

    @Update
    fun update(vararg report: Report)

    @Delete
    fun delete(vararg report: Report)
}
