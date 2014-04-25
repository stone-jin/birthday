package com.edu.sql;


import com.edu.bean.SQL_Person;
import com.edu.value.Sqlvalue;

import android.content.Context;
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
				Sqlvalue.birthPer_sex + "," + Sqlvalue.birthPer_photo + "," + Sqlvalue.birthPer_Greyear + "," + Sqlvalue.birthPer_Gremouth + "," + 
				Sqlvalue.birthPer_Greday + "," + Sqlvalue.birthPer_phone + "," + Sqlvalue.birthPer_animals + "," + Sqlvalue.birthPer_constellation + "," +
				Sqlvalue.birthPer_beizhuInfo + ")values('" + item.getName() + "','" + item.getAge() + "','" + item.getSex() + "','" + item.getPhoto() + "','" + item.getGreyear() + 
				"','" + item.getGremouth() + "','" + item.getGreday() + "','" + item.getPhone() + "','" + item.getAnimal() + "','" + item.getConstellation() +
				"','" + item.getBeizhuInfo() + "')";
		db.execSQL(sql);
	}
}
