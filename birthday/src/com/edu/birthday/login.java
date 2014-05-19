package com.edu.birthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.edu.util.Encrypt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends Activity {

	//view控件
	private Button login_back;
	private Button login_register;
	private Button login_loginbutton;
	private EditText login_user;
	private EditText login_password;
	
	private LoginTask loginTask;
	private String user;
	private String password;
	private Boolean haveLogin;
	
	//常量
	public static final int LOGIN_FOR_REGISTER = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		viewInit();
		dataInit();
	}
	
	private void viewInit(){
		login_back = (Button) this.findViewById(R.id.login_back);
		login_back.setOnClickListener(onClickListener);
		login_register = (Button) this.findViewById(R.id.login_register);
		login_register.setOnClickListener(onClickListener);
		login_loginbutton = (Button) this.findViewById(R.id.login_loginbutton);
		login_loginbutton.setOnClickListener(onClickListener);
		login_user = (EditText) this.findViewById(R.id.login_user);
		login_password = (EditText) this.findViewById(R.id.login_password);
	}
	
	private void dataInit(){
		haveLogin = false;
		if(getSharedPrefrences("account", "haveSaved", false)){
			login_user.setText(Encrypt.decodeBase64(getSharedPrefrences("account", "user", "")));
			login_password.setText(Encrypt.decodeBase64(getSharedPrefrences("account", "password", "")));
			login_loginbutton.setText("注销");
		}
		return;
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.login_back:
				if(haveLogin){
					Intent intent = new Intent(login.this,center.class);
					setResult(center.CENTER_TO_LOGIN, intent);
					login.this.finish();
				}else{
					login.this.finish();
				}
				break;
			case R.id.login_register:
				Intent intent = new Intent(login.this, register.class);
				startActivityForResult(intent, LOGIN_FOR_REGISTER);
				break;
			case R.id.login_loginbutton:
				InputMethodManager inputMethodManager = (InputMethodManager) getApplication().getSystemService(INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(login.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				if(login_loginbutton.getText().equals("登陆")){
					if((loginTask == null || loginTask.getStatus() == Status.FINISHED) && getScreenInput()){
						loginTask = new LoginTask();
						loginTask.execute();
					}
				}else if (login_loginbutton.getText().equals("注销")){
					login_loginbutton.setText("登陆");
				}
				break;
			}
		}
	};
	
	private boolean getScreenInput(){
		user = login_user.getText().toString();
		password = login_password.getText().toString();
		if(user.equals("") || password.equals("")){
			Toast.makeText(getApplicationContext(), "请填写账号密码", Toast.LENGTH_SHORT).show();
			return false;
		}else{
			user = Encrypt.encrpyMD5(user);
			password = Encrypt.encrpyMD5(password);
		}
		return true;
	}
	
	private class LoginTask extends AsyncTask<Void, Integer, Void>{
		private String httpurl = "http://pickingstone.sinaapp.com/api/login.php?";
		private String content = "";

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			publishProgress(0);
			try {
				URL url = new URL(httpurl + "user=" + user + "&password=" + password + "&action=login");
				HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
				InputStreamReader isr = new InputStreamReader(httpURLConnection.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				String stringline = "";
				while((stringline = br.readLine()) != null){
					content += stringline + "\n";
				}
				System.out.println(content);
				if(content.equals("成功\n")){
					publishProgress(1);
				}else if(content.equals("失败1\n")){
					publishProgress(2);
				}else if(content.equals("失败2\n")){
					publishProgress(3);
				}
				br.close();
				isr.close();
				httpURLConnection.disconnect();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			switch(values[0]){
			case 0:
				login_loginbutton.setText("正在登陆");
				break;
			case 1:
				login_loginbutton.setText("注销");
				haveLogin = true;
				break;
			case 2:
				Toast.makeText(getApplicationContext(), "用户名错误", Toast.LENGTH_SHORT).show();
				login_loginbutton.setText("登陆");
				break;
			case 3:
				Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
				login_loginbutton.setText("登陆");
				break;
			}
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(data == null){
			return;
		}
		switch(requestCode){
		case LOGIN_FOR_REGISTER:
			dataInit();
			haveLogin = true;
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	//table为SharedPrefrences的文件名，s为键，data为值
	private void saveToSharedPrefrences(String table, String s,String data){
		SharedPreferences sharedPreferences = getSharedPreferences(table, 0);
		Editor editor = sharedPreferences.edit();
		editor.putString(s, data);
		editor.commit();
	}
	
	//table为SharedPrefrences的文件名，s为键，data为值
	//account --->haveSaved表代表着是否已经保存着账号密码
	private void saveToSharedPrefrences(String table,String s,Boolean data){
		SharedPreferences sharedPreferences = getSharedPreferences(table, 0);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(s, data);
		editor.commit();
	}
	
	//table为SharedPrefrences的文件名，s为键，s1表示类型
	private String getSharedPrefrences(String table,String s,String s1){
		SharedPreferences sharedPreferences = getSharedPreferences(table, 0);
		String result = sharedPreferences.getString(s, "");
		return result;
	}
	
	//table为SharedPrefrences的文件名，s为键，s1位类型
	private Boolean getSharedPrefrences(String table,String s,Boolean s1){
		SharedPreferences sharedPreferences = getSharedPreferences(table, 0);
		Boolean result = sharedPreferences.getBoolean(s, false);
		return result;
	}
}
