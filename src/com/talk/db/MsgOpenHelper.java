package com.talk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MsgOpenHelper extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "talkIm";
	public static final String MSG_TABLE_NAME = "MESSAGE";
	public static final String FROM_COL = "FROM";
	public static final String MSG_COL = "MSG";
	private static final String MSG_TABLE_CREATE = "CREATE TABLE " + MSG_TABLE_NAME + FROM_COL +" TEXT, " + MSG_COL + " TEXT);";
	
	public MsgOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(MSG_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}
	
}
