package com.edu.birthday;

import java.sql.Date;
import java.util.Calendar;

import com.edu.util.DayUtil;

import android.app.Activity;
import android.os.Bundle;

public class helloworld extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birth_listview_item);
		test();
	}
	
	private void test(){
		DayUtil.getCurYear();
		DayUtil.getCurMonth();
		DayUtil.getCurDay();
	}
}
