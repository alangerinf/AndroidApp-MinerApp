package com.mat.app3.database.Dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mat.app3.database.entities.Report;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

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
        return "INSERT OR ABORT INTO `report` (`reportId`,`email`,`ot`,`boss`,`opName`,`date`,`numEquipo`,`turn`,`Petroleum`,`horometerStart`,`horometerEnd`,`trab1`,`trab1_hStart`,`trab1_hEnd`,`trab1_detail`,`trab2`,`trab2_hStart`,`trab2_hEnd`,`trab2_detail`,`trab3`,`trab3_hStart`,`trab3_hEnd`,`trab3_detail`,`trab4`,`trab4_hStart`,`trab4_hEnd`,`trab4_detail`,`trab5`,`trab5_hStart`,`trab5_hEnd`,`trab5_detail`,`trab6`,`trab6_hStart`,`trab6_hEnd`,`trab6_detail`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
        if (value.getNumEquipo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumEquipo());
        }
        if (value.getTurn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTurn());
        }
        stmt.bindDouble(9, value.getPetroleum());
        stmt.bindDouble(10, value.getHorometerStart());
        stmt.bindDouble(11, value.getHorometerEnd());
        if (value.getTrab1() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTrab1());
        }
        if (value.getTrab1_hStart() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTrab1_hStart());
        }
        if (value.getTrab1_hEnd() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTrab1_hEnd());
        }
        if (value.getTrab1_detail() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTrab1_detail());
        }
        if (value.getTrab2() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTrab2());
        }
        if (value.getTrab2_hStart() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTrab2_hStart());
        }
        if (value.getTrab2_hEnd() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTrab2_hEnd());
        }
        if (value.getTrab2_detail() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTrab2_detail());
        }
        if (value.getTrab3() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTrab3());
        }
        if (value.getTrab3_hStart() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTrab3_hStart());
        }
        if (value.getTrab3_hEnd() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTrab3_hEnd());
        }
        if (value.getTrab3_detail() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTrab3_detail());
        }
        if (value.getTrab4() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getTrab4());
        }
        if (value.getTrab4_hStart() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getTrab4_hStart());
        }
        if (value.getTrab4_hEnd() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTrab4_hEnd());
        }
        if (value.getTrab4_detail() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getTrab4_detail());
        }
        if (value.getTrab5() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTrab5());
        }
        if (value.getTrab5_hStart() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTrab5_hStart());
        }
        if (value.getTrab5_hEnd() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getTrab5_hEnd());
        }
        if (value.getTrab5_detail() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTrab5_detail());
        }
        if (value.getTrab6() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTrab6());
        }
        if (value.getTrab6_hStart() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTrab6_hStart());
        }
        if (value.getTrab6_hEnd() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTrab6_hEnd());
        }
        if (value.getTrab6_detail() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getTrab6_detail());
        }
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
        return "UPDATE OR ABORT `report` SET `reportId` = ?,`email` = ?,`ot` = ?,`boss` = ?,`opName` = ?,`date` = ?,`numEquipo` = ?,`turn` = ?,`Petroleum` = ?,`horometerStart` = ?,`horometerEnd` = ?,`trab1` = ?,`trab1_hStart` = ?,`trab1_hEnd` = ?,`trab1_detail` = ?,`trab2` = ?,`trab2_hStart` = ?,`trab2_hEnd` = ?,`trab2_detail` = ?,`trab3` = ?,`trab3_hStart` = ?,`trab3_hEnd` = ?,`trab3_detail` = ?,`trab4` = ?,`trab4_hStart` = ?,`trab4_hEnd` = ?,`trab4_detail` = ?,`trab5` = ?,`trab5_hStart` = ?,`trab5_hEnd` = ?,`trab5_detail` = ?,`trab6` = ?,`trab6_hStart` = ?,`trab6_hEnd` = ?,`trab6_detail` = ? WHERE `reportId` = ?";
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
        if (value.getNumEquipo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getNumEquipo());
        }
        if (value.getTurn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTurn());
        }
        stmt.bindDouble(9, value.getPetroleum());
        stmt.bindDouble(10, value.getHorometerStart());
        stmt.bindDouble(11, value.getHorometerEnd());
        if (value.getTrab1() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTrab1());
        }
        if (value.getTrab1_hStart() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTrab1_hStart());
        }
        if (value.getTrab1_hEnd() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTrab1_hEnd());
        }
        if (value.getTrab1_detail() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTrab1_detail());
        }
        if (value.getTrab2() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTrab2());
        }
        if (value.getTrab2_hStart() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTrab2_hStart());
        }
        if (value.getTrab2_hEnd() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTrab2_hEnd());
        }
        if (value.getTrab2_detail() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTrab2_detail());
        }
        if (value.getTrab3() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTrab3());
        }
        if (value.getTrab3_hStart() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTrab3_hStart());
        }
        if (value.getTrab3_hEnd() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTrab3_hEnd());
        }
        if (value.getTrab3_detail() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTrab3_detail());
        }
        if (value.getTrab4() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getTrab4());
        }
        if (value.getTrab4_hStart() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getTrab4_hStart());
        }
        if (value.getTrab4_hEnd() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTrab4_hEnd());
        }
        if (value.getTrab4_detail() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getTrab4_detail());
        }
        if (value.getTrab5() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTrab5());
        }
        if (value.getTrab5_hStart() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTrab5_hStart());
        }
        if (value.getTrab5_hEnd() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getTrab5_hEnd());
        }
        if (value.getTrab5_detail() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTrab5_detail());
        }
        if (value.getTrab6() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTrab6());
        }
        if (value.getTrab6_hStart() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTrab6_hStart());
        }
        if (value.getTrab6_hEnd() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTrab6_hEnd());
        }
        if (value.getTrab6_detail() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getTrab6_detail());
        }
        stmt.bindLong(36, value.getId());
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

  @Override
  public List<Report> selectAll() {
    final String _sql = "SELECT `report`.`reportId` AS `reportId`, `report`.`email` AS `email`, `report`.`ot` AS `ot`, `report`.`boss` AS `boss`, `report`.`opName` AS `opName`, `report`.`date` AS `date`, `report`.`numEquipo` AS `numEquipo`, `report`.`turn` AS `turn`, `report`.`Petroleum` AS `Petroleum`, `report`.`horometerStart` AS `horometerStart`, `report`.`horometerEnd` AS `horometerEnd`, `report`.`trab1` AS `trab1`, `report`.`trab1_hStart` AS `trab1_hStart`, `report`.`trab1_hEnd` AS `trab1_hEnd`, `report`.`trab1_detail` AS `trab1_detail`, `report`.`trab2` AS `trab2`, `report`.`trab2_hStart` AS `trab2_hStart`, `report`.`trab2_hEnd` AS `trab2_hEnd`, `report`.`trab2_detail` AS `trab2_detail`, `report`.`trab3` AS `trab3`, `report`.`trab3_hStart` AS `trab3_hStart`, `report`.`trab3_hEnd` AS `trab3_hEnd`, `report`.`trab3_detail` AS `trab3_detail`, `report`.`trab4` AS `trab4`, `report`.`trab4_hStart` AS `trab4_hStart`, `report`.`trab4_hEnd` AS `trab4_hEnd`, `report`.`trab4_detail` AS `trab4_detail`, `report`.`trab5` AS `trab5`, `report`.`trab5_hStart` AS `trab5_hStart`, `report`.`trab5_hEnd` AS `trab5_hEnd`, `report`.`trab5_detail` AS `trab5_detail`, `report`.`trab6` AS `trab6`, `report`.`trab6_hStart` AS `trab6_hStart`, `report`.`trab6_hEnd` AS `trab6_hEnd`, `report`.`trab6_detail` AS `trab6_detail` FROM Report";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "reportId");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfOt = CursorUtil.getColumnIndexOrThrow(_cursor, "ot");
      final int _cursorIndexOfBoss = CursorUtil.getColumnIndexOrThrow(_cursor, "boss");
      final int _cursorIndexOfOpName = CursorUtil.getColumnIndexOrThrow(_cursor, "opName");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfNumEquipo = CursorUtil.getColumnIndexOrThrow(_cursor, "numEquipo");
      final int _cursorIndexOfTurn = CursorUtil.getColumnIndexOrThrow(_cursor, "turn");
      final int _cursorIndexOfPetroleum = CursorUtil.getColumnIndexOrThrow(_cursor, "Petroleum");
      final int _cursorIndexOfHorometerStart = CursorUtil.getColumnIndexOrThrow(_cursor, "horometerStart");
      final int _cursorIndexOfHorometerEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "horometerEnd");
      final int _cursorIndexOfTrab1 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab1");
      final int _cursorIndexOfTrab1HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab1_hStart");
      final int _cursorIndexOfTrab1HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab1_hEnd");
      final int _cursorIndexOfTrab1Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab1_detail");
      final int _cursorIndexOfTrab2 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab2");
      final int _cursorIndexOfTrab2HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab2_hStart");
      final int _cursorIndexOfTrab2HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab2_hEnd");
      final int _cursorIndexOfTrab2Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab2_detail");
      final int _cursorIndexOfTrab3 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab3");
      final int _cursorIndexOfTrab3HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab3_hStart");
      final int _cursorIndexOfTrab3HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab3_hEnd");
      final int _cursorIndexOfTrab3Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab3_detail");
      final int _cursorIndexOfTrab4 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab4");
      final int _cursorIndexOfTrab4HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab4_hStart");
      final int _cursorIndexOfTrab4HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab4_hEnd");
      final int _cursorIndexOfTrab4Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab4_detail");
      final int _cursorIndexOfTrab5 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab5");
      final int _cursorIndexOfTrab5HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab5_hStart");
      final int _cursorIndexOfTrab5HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab5_hEnd");
      final int _cursorIndexOfTrab5Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab5_detail");
      final int _cursorIndexOfTrab6 = CursorUtil.getColumnIndexOrThrow(_cursor, "trab6");
      final int _cursorIndexOfTrab6HStart = CursorUtil.getColumnIndexOrThrow(_cursor, "trab6_hStart");
      final int _cursorIndexOfTrab6HEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "trab6_hEnd");
      final int _cursorIndexOfTrab6Detail = CursorUtil.getColumnIndexOrThrow(_cursor, "trab6_detail");
      final List<Report> _result = new ArrayList<Report>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Report _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpEmail;
        _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        final String _tmpOt;
        _tmpOt = _cursor.getString(_cursorIndexOfOt);
        final String _tmpBoss;
        _tmpBoss = _cursor.getString(_cursorIndexOfBoss);
        final String _tmpOpName;
        _tmpOpName = _cursor.getString(_cursorIndexOfOpName);
        final String _tmpDate;
        _tmpDate = _cursor.getString(_cursorIndexOfDate);
        final String _tmpNumEquipo;
        _tmpNumEquipo = _cursor.getString(_cursorIndexOfNumEquipo);
        final String _tmpTurn;
        _tmpTurn = _cursor.getString(_cursorIndexOfTurn);
        final float _tmpPetroleum;
        _tmpPetroleum = _cursor.getFloat(_cursorIndexOfPetroleum);
        final float _tmpHorometerStart;
        _tmpHorometerStart = _cursor.getFloat(_cursorIndexOfHorometerStart);
        final float _tmpHorometerEnd;
        _tmpHorometerEnd = _cursor.getFloat(_cursorIndexOfHorometerEnd);
        final String _tmpTrab1;
        _tmpTrab1 = _cursor.getString(_cursorIndexOfTrab1);
        final String _tmpTrab1_hStart;
        _tmpTrab1_hStart = _cursor.getString(_cursorIndexOfTrab1HStart);
        final String _tmpTrab1_hEnd;
        _tmpTrab1_hEnd = _cursor.getString(_cursorIndexOfTrab1HEnd);
        final String _tmpTrab1_detail;
        _tmpTrab1_detail = _cursor.getString(_cursorIndexOfTrab1Detail);
        final String _tmpTrab2;
        _tmpTrab2 = _cursor.getString(_cursorIndexOfTrab2);
        final String _tmpTrab2_hStart;
        _tmpTrab2_hStart = _cursor.getString(_cursorIndexOfTrab2HStart);
        final String _tmpTrab2_hEnd;
        _tmpTrab2_hEnd = _cursor.getString(_cursorIndexOfTrab2HEnd);
        final String _tmpTrab2_detail;
        _tmpTrab2_detail = _cursor.getString(_cursorIndexOfTrab2Detail);
        final String _tmpTrab3;
        _tmpTrab3 = _cursor.getString(_cursorIndexOfTrab3);
        final String _tmpTrab3_hStart;
        _tmpTrab3_hStart = _cursor.getString(_cursorIndexOfTrab3HStart);
        final String _tmpTrab3_hEnd;
        _tmpTrab3_hEnd = _cursor.getString(_cursorIndexOfTrab3HEnd);
        final String _tmpTrab3_detail;
        _tmpTrab3_detail = _cursor.getString(_cursorIndexOfTrab3Detail);
        final String _tmpTrab4;
        _tmpTrab4 = _cursor.getString(_cursorIndexOfTrab4);
        final String _tmpTrab4_hStart;
        _tmpTrab4_hStart = _cursor.getString(_cursorIndexOfTrab4HStart);
        final String _tmpTrab4_hEnd;
        _tmpTrab4_hEnd = _cursor.getString(_cursorIndexOfTrab4HEnd);
        final String _tmpTrab4_detail;
        _tmpTrab4_detail = _cursor.getString(_cursorIndexOfTrab4Detail);
        final String _tmpTrab5;
        _tmpTrab5 = _cursor.getString(_cursorIndexOfTrab5);
        final String _tmpTrab5_hStart;
        _tmpTrab5_hStart = _cursor.getString(_cursorIndexOfTrab5HStart);
        final String _tmpTrab5_hEnd;
        _tmpTrab5_hEnd = _cursor.getString(_cursorIndexOfTrab5HEnd);
        final String _tmpTrab5_detail;
        _tmpTrab5_detail = _cursor.getString(_cursorIndexOfTrab5Detail);
        final String _tmpTrab6;
        _tmpTrab6 = _cursor.getString(_cursorIndexOfTrab6);
        final String _tmpTrab6_hStart;
        _tmpTrab6_hStart = _cursor.getString(_cursorIndexOfTrab6HStart);
        final String _tmpTrab6_hEnd;
        _tmpTrab6_hEnd = _cursor.getString(_cursorIndexOfTrab6HEnd);
        final String _tmpTrab6_detail;
        _tmpTrab6_detail = _cursor.getString(_cursorIndexOfTrab6Detail);
        _item = new Report(_tmpId,_tmpEmail,_tmpOt,_tmpBoss,_tmpOpName,_tmpDate,_tmpNumEquipo,_tmpTurn,_tmpPetroleum,_tmpHorometerStart,_tmpHorometerEnd,_tmpTrab1,_tmpTrab1_hStart,_tmpTrab1_hEnd,_tmpTrab1_detail,_tmpTrab2,_tmpTrab2_hStart,_tmpTrab2_hEnd,_tmpTrab2_detail,_tmpTrab3,_tmpTrab3_hStart,_tmpTrab3_hEnd,_tmpTrab3_detail,_tmpTrab4,_tmpTrab4_hStart,_tmpTrab4_hEnd,_tmpTrab4_detail,_tmpTrab5,_tmpTrab5_hStart,_tmpTrab5_hEnd,_tmpTrab5_detail,_tmpTrab6,_tmpTrab6_hStart,_tmpTrab6_hEnd,_tmpTrab6_detail);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
