package com.exam2.util;

import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

public class DBUtil {
	private Context context;
	private final int BUFFER_SIZE = 1024;
	private static final String DB_NAME ="data.db"; 
	private final String PACKAGE_NAME;
	private final String DB_PATH; 

	public DBUtil(Context context) {
		this.context = context;
		PACKAGE_NAME = PackageUtil.getAppInfo(context).getAsString(
				"packageName");
		DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath()
				+ "/" + PACKAGE_NAME + "/databases/"; 
	}

	public void openDatabase() {
		File dir = new File(DB_PATH);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File db_file = new File(DB_PATH, DB_NAME);
		if (!db_file.exists()) {
			AssetManager am = context.getAssets();
			try {
				InputStream is = am.open(DB_NAME);
				FileOutputStream fos = new FileOutputStream(db_file);
				byte[] buffer = new byte[BUFFER_SIZE];
				int count = 0;
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
