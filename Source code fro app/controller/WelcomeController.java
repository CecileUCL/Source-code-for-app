package com.exam2.controller;

import com.exam2.util.DBUtil;

import android.content.Context;

public class WelcomeController {
	public void init(Context context) {
		new DBUtil(context).openDatabase();
	}
}
