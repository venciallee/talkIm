package com.talk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DBMsgService {

	private MsgOpenHelper db_msg = null;

	private SQLiteDatabase db_writer = null;
	private SQLiteDatabase db_reader = null;

	public DBMsgService(Context context) {

		try {
			db_writer = SQLiteDatabase.openDatabase(
					MsgOpenHelper.DATABASE_NAME, null,
					SQLiteDatabase.OPEN_READWRITE);
			db_reader = SQLiteDatabase.openDatabase(
					MsgOpenHelper.DATABASE_NAME, null,
					SQLiteDatabase.OPEN_READONLY);
		} catch (SQLiteException e) {
			db_msg = new MsgOpenHelper(context);
			db_writer = db_msg.getWritableDatabase();
			db_reader = db_msg.getReadableDatabase();
		}
	}

	public boolean insertMsg(String userName, String msg) {

		boolean flag = false;
		try {
			ContentValues contentValues = new ContentValues();
			contentValues.put(userName, msg);
			if (null != db_writer) {
				db_writer.insertWithOnConflict(MsgOpenHelper.MSG_TABLE_NAME,
						null, contentValues, SQLiteDatabase.CONFLICT_ROLLBACK);
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public Cursor queryMsg(String userName) {

		Cursor cursor = null;

		if(null != db_reader) {
			cursor = db_reader.query(MsgOpenHelper.MSG_TABLE_NAME, null,
					MsgOpenHelper.FROM_COL, new String[] { userName }, null, null,
					null);
		}

		return cursor;
	};

}
