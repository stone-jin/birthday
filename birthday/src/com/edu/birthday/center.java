package com.edu.birthday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class center extends Activity {
	
	//view¿Ø¼þ
	private Button center_login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.center);
		viewInit();
	}
	
	private void viewInit(){
		center_login = (Button) this.findViewById(R.id.center_login);
		center_login.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.center_login:
				Intent intent = new Intent(center.this,login.class);
				startActivity(intent);
				break;
			}
		}
		
	};
}
