package com.exam2.db;

import java.util.ArrayList;
import java.util.List;

import com.exam2.entity.UserLogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserLoginDao {
	private DataBaseHelper helper = null;

	public UserLoginDao(Context context) {
		// TODO Auto-generated constructor stub
		helper = new DataBaseHelper(context);
	}
	/**
	 *
	 * user login
	 */
	public void insert(UserLogin userLogin){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", userLogin.getUsername());
		values.put("password", userLogin.getPassword());
		db.insert("USER_LOGIN", null, values);
		db.close();
	}
	
	/*
	 *
	 */
	public List<UserLogin> query(String uname, String pwd) throws Exception {
			List<UserLogin> userLoginList = new ArrayList<UserLogin>();
			SQLiteDatabase db = helper.getReadableDatabase();
			Cursor cursor = db.query("USER_LOGIN", null, " username = '" + uname + "' and password = '" + pwd + "' ", null, null, null, "id desc");
			while (cursor.moveToNext()) {
				UserLogin userLogin = new UserLogin();
				String username = cursor.getString(cursor
						.getColumnIndex("username"));
				String password = cursor.getString(cursor
						.getColumnIndex("password"));
				int id = cursor.getInt(cursor.getColumnIndex("id"));

				userLogin.setUsername(username);
				userLogin.setPassword(password);
				userLogin.setId(id);
				
				userLoginList.add(userLogin);
			}
			cursor.close();
			db.close();
			return userLoginList;

	}
	
}
