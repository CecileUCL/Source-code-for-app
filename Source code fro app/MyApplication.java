package com.exam2;

import android.app.Application;

public class MyApplication extends Application {
	
	private String username;

	@Override
    public void onCreate() {
		super.onCreate();
		setUsername(username); //
    }
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
