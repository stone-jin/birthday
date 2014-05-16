package com.edu.birthday;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class register extends Activity {
	
	//view�ؼ�
	private Button register_back;
	private Button register_registerbutton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		viewInit();
	}
	
	private void viewInit(){
		register_back = (Button) this.findViewById(R.id.register_back);
		register_back.setOnClickListener(onClickListener);
		register_registerbutton = (Button) this.findViewById(R.id.register_registerbutton);
		register_registerbutton.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.register_back:
				register.this.finish();
				break;
			case R.id.register_registerbutton:
				InputMethodManager inputMethodManager = (InputMethodManager) getApplication().getSystemService(INPUT_METHOD_SERVICE);
				inputMethodManager.hideSoftInputFromWindow(register.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
				break;
			}
		}
	};
}