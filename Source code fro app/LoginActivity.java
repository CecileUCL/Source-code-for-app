package com.exam2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.exam2.db.UserLoginDao;
import com.exam2.entity.UserLogin;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**/
public class LoginActivity extends Activity {
	private EditText username;
	private EditText password;
	private Button login;
	private Button register;
	private Intent intent;
	private MyApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		app = (MyApplication) getApplication();
		//
		login = (Button) findViewById(R.id.userlogin);
		register = (Button) findViewById(R.id.register);
		login.setOnClickListener(ocl);
		register.setOnClickListener(ocl);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	public boolean login(String username, String password) throws Exception {
		UserLoginDao userLoginDao = new UserLoginDao(this);
		List<UserLogin> list = userLoginDao.query(username, password);
		if (list.size() > 0) {
			app.setUsername(username);
			return true;
		} else {
			return false;
		}
	}
	
	//
	OnClickListener ocl = new OnClickListener() {
		public void onClick(View v) {

			username = (EditText) findViewById(R.id.username);
			password = (EditText) findViewById(R.id.password);

			switch (v.getId()) {
			case R.id.userlogin:
				try {
					if (login(username.getText().toString(), password.getText().toString())) {
						intent = new Intent(LoginActivity.this, WelcomeActivity.class);
			  		  	startActivity(intent);// Activity
				  		Toast.makeText(LoginActivity.this,"login succeed",Toast.LENGTH_SHORT).show();
					} else {
						Toast.makeText(LoginActivity.this,"login failed",Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case R.id.register:
				intent = new Intent(LoginActivity.this, RegisterActivity.class);
				// Activity
				startActivity(intent);

			default:
				break;
			}

		}
	};

}
