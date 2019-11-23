package com.mat.app3.database.Dao;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mat.app3.database.entities.Report;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ReportDao_Impl implements ReportDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Report> __insertionAdapterOfReport;

  private final EntityDeletionOrUpdateAdapter<Report> __deletionAdapterOfReport;

  private final EntityDeletionOrUpdateAdapter<Report> __updateAdapterOfReport;

  public ReportDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReport = new EntityInsertionAdapter<Report>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `report` (`reportId`,`email`,`ot`,`boss`,`opName`,`date`,`turn`,`Petroleum`,`horometerStart`,`horometerEnd`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Report value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getOt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOt());
        }
        if (value.getBoss() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBoss());
        }
        if (value.getOpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOpName());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        if (value.getTurn() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTurn());
        }
        stmt.bindDouble(8, value.getPetroleum());
        stmt.bindDouble(9, value.getHorometerStart());
        stmt.bindDouble(10, value.getHorometerEnd());
      }
    };
    this.__deletionAdapterOfReport = new EntityDeletionOrUpdateAdapter<Report>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `report` WHERE `reportId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Report value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfReport = new EntityDeletionOrUpdateAdapter<Report>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `report` SET `reportId` = ?,`email` = ?,`ot` = ?,`boss` = ?,`opName` = ?,`date` = ?,`turn` = ?,`Petroleum` = ?,`horometerStart` = ?,`horometerEnd` = ? WHERE `reportId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Report value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        if (value.getOt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOt());
        }
        if (value.getBoss() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBoss());
        }
        if (value.getOpName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOpName());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        if (value.getTurn() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTurn());
        }
        stmt.bindDouble(8, value.getPetroleum());
        stmt.bindDouble(9, value.getHorometerStart());
        stmt.bindDouble(10, value.getHorometerEnd());
        stmt.bindLong(11, value.getId());
      }
    };
  }

  @Override
  public void insert(final Report... arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReport.insert(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Report... arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfReport.handleMultiple(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Report... arg0) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfReport.handleMultiple(arg0);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
