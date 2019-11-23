package com.mat.app3.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mat.app3.database.Dao.ReportDao;
import com.mat.app3.database.entities.Report;
import com.mat.app3.database.entities.ReportJobs;

@Database(
        entities = {
                Report.class
                    }
        ,version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static volatile MyDatabase INSTANCE;

    public abstract ReportDao reportDao();

    public static MyDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyDatabase.class, "database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
