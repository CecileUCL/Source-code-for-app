package com.exam2;

import com.exam2.R;
import com.exam2.util.FileUtil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * hewang
 */
public abstract class BaseActivity extends Activity {
	private FileUtil fu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// get rid of title on pictures
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// set background
		this.getWindow().setBackgroundDrawableResource(R.drawable.bg_base);
	}

	public void toBack(View view) {
		finish();
	}

}
