package com.exam2.db;


import com.exam2.constant.Constant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	private static final int VERSION=1;
	public static final String DBNAME = "question.db";
	public DataBaseHelper (Context context){
		super(context,DBNAME,null,VERSION);
	}
	
	public DataBaseHelper (Context context,int version){
		super(context,DBNAME,null,version);
	}
	/**
	 *
	 * SQLiteDatabase
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Constant.TABLE_INFO);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
