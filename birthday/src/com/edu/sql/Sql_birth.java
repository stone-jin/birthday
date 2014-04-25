package com.edu.sql;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Sql_birth {
	private SQLiteDatabase db;
	
	private MySql mysql;
	
	public Sql_birth(Context context){
		mysql = MySql.getInstance(context);
		db = mysql.getWritableDatabase();
	}
}
