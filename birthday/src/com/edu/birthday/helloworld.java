package com.edu.birthday;

import com.edu.util.DayUtil;
import com.edu.util.GregorianUtil;

import android.app.Activity;
import android.os.Bundle;

public class helloworld extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_sms);
		test();
	}
	
	private void test(){
		String s = GregorianUtil.getFestvial(5, 32);
		System.out.println(s);
	}
}
