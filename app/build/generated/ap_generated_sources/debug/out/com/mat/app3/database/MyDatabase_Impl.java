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
        _db.execSQL("CREATE TABLE IF NOT EXISTS `report` (`reportId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `ot` TEXT NOT NULL, `boss` TEXT NOT NULL, `opName` TEXT NOT NULL, `date` TEXT NOT NULL, `turn` TEXT NOT NULL, `Petroleum` REAL NOT NULL, `horometerStart` REAL NOT NULL, `horometerEnd` REAL NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2dbc83bf74869d1227a167da15e2b401')");
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
        final HashMap<String, TableInfo.Column> _columnsReport = new HashMap<String, TableInfo.Column>(10);
        _columnsReport.put("reportId", new TableInfo.Column("reportId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("ot", new TableInfo.Column("ot", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("boss", new TableInfo.Column("boss", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("opName", new TableInfo.Column("opName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("turn", new TableInfo.Column("turn", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("Petroleum", new TableInfo.Column("Petroleum", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("horometerStart", new TableInfo.Column("horometerStart", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReport.put("horometerEnd", new TableInfo.Column("horometerEnd", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
    }, "2dbc83bf74869d1227a167da15e2b401", "fbc757bf372a90738cc5686c53884d0c");
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
