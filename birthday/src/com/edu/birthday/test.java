package com.edu.birthday;

import com.edu.sql.SqlDatebase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class test extends Activity {
	private SQLiteDatabase sqLiteDatabase;
	
	//view����
	private EditText addsql_edit1;
	private EditText addsql_edit2;
	private EditText addsql_edit3;
	private Button addsql_button;
	private Button addsql_button1;
	
	private int Z_PK1;
	private int Z_PK2;
	private int locationx;
	private int locationy;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addsql);
		viewInit();
	}
	
	private void viewInit(){
		addsql_edit1 = (EditText) this.findViewById(R.id.addsql_edit1);
		addsql_edit2 = (EditText) this.findViewById(R.id.addsql_edit2);
		addsql_edit3 = (EditText) this.findViewById(R.id.addsql_edit3);
		addsql_button = (Button) this.findViewById(R.id.addsql_button);
		addsql_button.setOnClickListener(onClickListener);
		addsql_button1 = (Button) this.findViewById(R.id.addsql_button1);
		addsql_button1.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.addsql_button:
				dateInit();
				dateInit2();
				dateInit3();
				break;
			case R.id.addsql_button1:
				dateInit();
				delete();
				dateInit3();
				break;
			}
		}
	};
	
	private void dateInit(){
		String[] s = addsql_edit1.getText().toString().split("-");
		Z_PK1 = Integer.parseInt(s[0]);
		Z_PK2 = Integer.parseInt(s[1]);
		String[] s1 = addsql_edit2.getText().toString().split("-");
		locationx = Integer.parseInt(s1[0]);
		locationy = Integer.parseInt(s1[1]);
	}
	
	private void dateInit2(){
		sqLiteDatabase = SqlDatebase.getInstanceDatabase(this);
		Cursor cursor = sqLiteDatabase.rawQuery("select ZPOPULARITY,ZCONTENT from ZSMSCONTENT where Z_PK >= '" + Z_PK1 + "' and Z_PK <= '" + Z_PK2 + "'", null);
		if(cursor.getColumnCount() != 0){
			cursor.moveToPosition(0);
			while(true){
				if(cursor.isAfterLast()){
					break;
				}
				sqLiteDatabase.execSQL("insert into sms(positionx, positiony,popularity, content, iscollect)values('" + locationx + "', '" + locationy + "', '" + cursor.getInt(0) +"', '" + (cursor.getString(1)).replace("'", "''") + "' ,'false')");
				cursor.moveToNext();
			}
		}
		cursor.close();
//		sqLiteDatabase.execSQL("delete from sms where id > '1026'");
	}
	
	private void dateInit3(){
		sqLiteDatabase = SqlDatebase.getInstanceDatabase(this);
		Cursor cursor = sqLiteDatabase.rawQuery("select count(*) from sms", null);
		if(cursor.getColumnCount() != 0){
			cursor.moveToPosition(0);
			while(true){
				if(cursor.isAfterLast()){
					break;
				}
				addsql_edit3.setText(cursor.getInt(0) + "");
				cursor.moveToNext();
			}
		}
		cursor.close();
	}
	
	private void delete(){
		sqLiteDatabase = SqlDatebase.getInstanceDatabase(this);
		System.out.println("delete from sms where id >= '" + Z_PK1 + "' and id <= '" + Z_PK2 + "'");
		sqLiteDatabase.execSQL("delete from sms where id >= '" + Z_PK1 + "' and id <= '" + Z_PK2 + "'");
	}
	
}
