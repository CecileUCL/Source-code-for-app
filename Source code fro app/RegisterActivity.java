package com.exam2;

import java.io.File;
import java.io.FileOutputStream;

import com.exam2.db.UserLoginDao;
import com.exam2.entity.UserLogin;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * */
public class RegisterActivity extends Activity {
	private EditText username;
	private EditText password;
	private Button register;
	private Intent intent;
	private String name;
	private String mima;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		//
		register = (Button) findViewById(R.id.register);
		register.setOnClickListener(ocl);
	}

	public void register(String username, String password) {
		UserLoginDao userLoginDao = new UserLoginDao(this);
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		userLoginDao.insert(userLogin);
	}

	//
	OnClickListener ocl = new OnClickListener() {
		public void onClick(View v) {

			username = (EditText) findViewById(R.id.username);
			password = (EditText) findViewById(R.id.password);

			name = username.getText().toString();
			mima = password.getText().toString();
			switch (v.getId()) {

			case R.id.register:
				register(name, mima);
				
				intent = new Intent();
				intent.setClass(RegisterActivity.this, LoginActivity.class);
				startActivity(intent);
			default:
				break;
			}
		}
	};

}
