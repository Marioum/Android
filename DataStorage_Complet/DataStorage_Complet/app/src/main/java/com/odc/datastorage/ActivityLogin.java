package com.odc.datastorage;

import com.odc.datastorage.utils.MyApp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends Activity implements OnClickListener {

	EditText editTextLogin,editTextPassword;
	Button btnConnect,btnDontConnect;
	MyApp app;
	

	public static String PREFERENCE_FILENAME = "reporting_app";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);

		editTextLogin = (EditText) findViewById(R.id.et_login);
		editTextPassword = (EditText) findViewById(R.id.et_password);
		btnConnect = (Button) findViewById(R.id.btn_connect);
		btnDontConnect = (Button) findViewById(R.id.btn_dont_connect);
		
		SharedPreferences reportingPref = getSharedPreferences(PREFERENCE_FILENAME, MODE_PRIVATE);
		String login = reportingPref.getString("login","");
		String password = reportingPref.getString("password","");
		
		editTextLogin.setText(login);
		editTextPassword.setText(password);

		app = (MyApp) getApplication();
		
		btnConnect.setOnClickListener(this);
		btnDontConnect.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_connect:
			String login = editTextLogin.getText().toString();
			String password = editTextPassword.getText().toString();
			if (!login.equals("") && !password.equals("")) {
				app.setConnected(true);
				
				SharedPreferences reportingPref = getSharedPreferences(PREFERENCE_FILENAME, MODE_PRIVATE);  
				SharedPreferences.Editor prefEditor = reportingPref.edit(); 
				prefEditor.putString("login",editTextLogin.getText().toString()); 
				prefEditor.putString("password",editTextPassword.getText().toString()); 
				prefEditor.commit();
				
				startActivity(new Intent(ActivityLogin.this,ActivityAddArticle.class));
			}
			else {
				Toast.makeText(getApplicationContext(), "please, tap login and password ", Toast.LENGTH_SHORT ).show();
			}
			
			break;

		case R.id.btn_dont_connect:
			app.setConnected(false);
			startActivity(new Intent(ActivityLogin.this,ActivityAddArticle.class));
			break;
		}
		
	}


}
