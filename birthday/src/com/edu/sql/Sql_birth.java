package com.edu.sql;


import java.util.ArrayList;
import java.util.List;

import com.edu.bean.Birth_listview_item;
import com.edu.bean.SQL_Person;
import com.edu.value.Sqlvalue;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Sql_birth {
	private SQLiteDatabase db;
	
	private MySql mysql;
	
	public Sql_birth(Context context){
		mysql = MySql.getInstance(context);
		db = mysql.getWritableDatabase();
	}
	
	/*********
	 * 
	 * ����������
	 * 
	 */
	public void insert(SQL_Person item){
		String sql = "insert into " + Sqlvalue.TABLE_birth_name + "(" + Sqlvalue.birthPer_name + "," + Sqlvalue.birthPer_age + "," + 
				Sqlvalue.birthPer_sex + "," + Sqlvalue.birthPer_photo + "," + Sqlvalue.birthPer_Greyear + "," + Sqlvalue.birthPer_Gremonth + "," + 
				Sqlvalue.birthPer_Greday + "," + Sqlvalue.birthPer_phone + "," + Sqlvalue.birthPer_animals + "," + Sqlvalue.birthPer_constellation + "," +
				Sqlvalue.birthPer_beizhuInfo + ")values('" + item.getName() + "','" + item.getAge() + "','" + item.getSex() + "','" + item.getPhoto() + "','" + item.getGreyear() + 
				"','" + item.getGremonth() + "','" + item.getGreday() + "','" + item.getPhone() + "','" + item.getAnimal() + "','" + item.getConstellation() +
				"','" + item.getBeizhuInfo() + "')";
		db.execSQL(sql);
	}
	
	/*********
	 * 
	 * ��ѯ�����ˣ����򣺸���ʣ����������
	 * 
	 */
	public List<Birth_listview_item> qure_byresidue(){
		List<Birth_listview_item> list = new ArrayList<Birth_listview_item>();
		Cursor cursor = db.rawQuery("select " + Sqlvalue.birthPer_name + "," + Sqlvalue.birthPer_Gremonth + "," + Sqlvalue.birthPer_Greday + " from " + Sqlvalue.TABLE_birth_name, null);
		if(cursor.getCount() != 0){
			cursor.moveToPosition(0);
			while(true){
				if(cursor.isAfterLast()){
					break;
				}
				Birth_listview_item item = new Birth_listview_item();
				item.setName(cursor.getString(0));
				item.setPhoto(null);
				item.setMouth(cursor.getInt(1));
				item.setDay(cursor.getInt(2));
				item.setResidue(10);
				list.add(item);
				cursor.moveToNext();
			}
		}
		return list;
	}
}