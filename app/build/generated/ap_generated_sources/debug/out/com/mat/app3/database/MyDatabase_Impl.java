package com.mat.app3.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.mat.app3.database.Dao.ReportDao;
import com.mat.app3.database.Dao.ReportDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabase_Impl extends MyDatabase {
  private volatile ReportDao _reportDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `report` (`reportId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `ot` TEXT NOT NULL, `boss` TEXT NOT NULL, `opName` TEXT NOT NULL, `date` TEXT NOT NULL, `numEquipo` TEXT NOT NULL, `turn` TEXT NOT NULL, `Petroleum` REAL NOT NULL, `horometerStart` REAL NOT NULL, `horometerEnd` REAL NOT NULL, `trab1` TEXT NOT NULL, `trab1_hStart` TEXT NOT NULL, `trab1_hEnd` TEXT NOT NULL, `trab1_detail` TEXT NOT NULL, `trab2` TEXT NOT NULL, `trab2_hStart` TEXT NOT NULL, `trab2_hEnd` TEXT NOT NULL, `trab2_detail` TEXT NOT NULL, `trab3` TEXT NOT NULL, `trab3_hStart` TEXT NOT NULL, `trab3_hEnd` TEXT NOT NULL, `trab3_detail` TEXT NOT NULL, `trab4` TEXT NOT NULL, `trab4_hStart` TEXT NOT NULL, `trab4_hEnd` TEXT NOT NULL, `trab4_detail` TEXT NOT NULL, `trab5` TEXT NOT NULL, `trab5_hStart` TEXT NOT NULL, `trab5_hEnd` TEXT NOT NULL, `trab5_detail` TEXT NOT NULL, `trab6` TEXT NOT NULL, `trab6_hStart` TEXT NOT NULL, `trab6_hEnd` TEXT NOT NULL, `trab6_detail` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'bf686d4b27586126be064d2651c5a82a')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `report`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsReport = new HashMap<String, TableInfo.Column>(35);
        _columnsReport.put("reportId", new TableInfo.Column("reportId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("ot", new TableInfo.Column("ot", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("boss", new TableInfo.Column("boss", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("opName", new TableInfo.Column("opName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("numEquipo", new TableInfo.Column("numEquipo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("turn", new TableInfo.Column("turn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("Petroleum", new TableInfo.Column("Petroleum", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("horometerStart", new TableInfo.Column("horometerStart", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("horometerEnd", new TableInfo.Column("horometerEnd", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab1", new TableInfo.Column("trab1", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab1_hStart", new TableInfo.Column("trab1_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab1_hEnd", new TableInfo.Column("trab1_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab1_detail", new TableInfo.Column("trab1_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab2", new TableInfo.Column("trab2", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab2_hStart", new TableInfo.Column("trab2_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab2_hEnd", new TableInfo.Column("trab2_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab2_detail", new TableInfo.Column("trab2_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab3", new TableInfo.Column("trab3", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab3_hStart", new TableInfo.Column("trab3_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab3_hEnd", new TableInfo.Column("trab3_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab3_detail", new TableInfo.Column("trab3_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab4", new TableInfo.Column("trab4", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab4_hStart", new TableInfo.Column("trab4_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab4_hEnd", new TableInfo.Column("trab4_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab4_detail", new TableInfo.Column("trab4_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab5", new TableInfo.Column("trab5", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab5_hStart", new TableInfo.Column("trab5_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab5_hEnd", new TableInfo.Column("trab5_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab5_detail", new TableInfo.Column("trab5_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab6", new TableInfo.Column("trab6", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab6_hStart", new TableInfo.Column("trab6_hStart", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab6_hEnd", new TableInfo.Column("trab6_hEnd", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("trab6_detail", new TableInfo.Column("trab6_detail", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReport = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesReport = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoReport = new TableInfo("report", _columnsReport, _foreignKeysReport, _indicesReport);
        final TableInfo _existingReport = TableInfo.read(_db, "report");
        if (! _infoReport.equals(_existingReport)) {
          return new RoomOpenHelper.ValidationResult(false, "report(com.mat.app3.database.entities.Report).\n"
                  + " Expected:\n" + _infoReport + "\n"
                  + " Found:\n" + _existingReport);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "bf686d4b27586126be064d2651c5a82a", "c8e4fa62fb014e9e0ab0b981c29f44b8");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "report");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `report`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ReportDao reportDao() {
    if (_reportDao != null) {
      return _reportDao;
    } else {
      synchronized(this) {
        if(_reportDao == null) {
          _reportDao = new ReportDao_Impl(this);
        }
        return _reportDao;
      }
    }
  }
}
