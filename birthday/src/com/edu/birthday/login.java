package com.edu.birthday;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class login extends Activity {

	//view�ؼ�
	private Button login_back;
	private Button login_register;
	private Button login_loginbutton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		viewInit();
	}
	
	private void viewInit(){
		login_back = (Button) this.findViewById(R.id.login_back);
		login_back.setOnClickListener(onClickListener);
		login_register = (Button) this.findViewById(R.id.login_register);
		login_register.setOnClickListener(onClickListener);
		login_loginbutton = (Button) this.findViewById(R.id.login_loginbutton);
		login_loginbutton.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.login_back:
				login.this.finish();
				break;
			case R.id.login_register:
				Intent intent = new Intent(login.this, register.class);
				startActivity(intent);
				break;
			case R.id.login_loginbutton:
				InputMethodManager inputMethodManager = (InputMethodManager) getApplication().getSystemService(INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(login.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				break;
			}
		}
	};
}