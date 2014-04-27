package com.edu.sql;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.edu.bean.Birth_listview_item;
import com.edu.bean.SQL_Person;
import com.edu.util.DayUtil;
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
	 * 插入生日人
	 * 
	 */
	public void insert(SQL_Person item){
		String sql = "insert into " + Sqlvalue.TABLE_birth_name + "(" + Sqlvalue.birthPer_name + "," + Sqlvalue.birthPer_age + "," + 
				Sqlvalue.birthPer_sex + "," + Sqlvalue.birthPer_photo + "," + Sqlvalue.birthPer_Greyear + "," + Sqlvalue.birthPer_Gremonth + "," + 
				Sqlvalue.birthPer_Greday + "," + Sqlvalue.birthPer_phone + "," + Sqlvalue.birthPer_animals + "," + Sqlvalue.birthPer_constellation + "," +
				Sqlvalue.birthPer_beizhuInfo + ")values('" + item.getName() + "','" + item.getAge() + "','" + item.getSex() + "','" + item.getPhoto() + "','" + item.getGreyear() + 
				"','" + item.getGremonth() + "','" + item.getGreday() + "','" + item.getPhone() + "','" + item.getAnimal() + "','" + item.getConstellation() +
				"','" + item.getBeizhuInfo() + "')";
		System.out.println(sql);
		db.execSQL(sql);
	}
	
	/*********
	 * 
	 * 查询生日人，排序：根据剩余天数排序
	 * 
	 */
	public List<Birth_listview_item> qure_byresidue(){
		List<Birth_listview_item> list = new ArrayList<Birth_listview_item>();
		int years[]; 
		Cursor cursor = db.rawQuery("select " + Sqlvalue.birthPer_name + "," + Sqlvalue.birthPer_Gremonth + "," + Sqlvalue.birthPer_Greday + ",id ," + Sqlvalue.birthPer_Greyear +" from " + Sqlvalue.TABLE_birth_name , null);
		years = new int[cursor.getCount()];
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
				item.setId(cursor.getInt(3));
				years[list.size()] = cursor.getInt(4);
				list.add(item);
				cursor.moveToNext();
			}
		}
		for(int i = 0; i < list.size(); i++){
			int year,month,day;
			year = years[i];
			month = list.get(i).getMouth();
			day = list.get(i).getDay();
			list.get(i).setResidue(DayUtil.getResidueToNextBirthday(year,month,day));
		}
		//冒泡排序
		for(int i = 0; i < list.size(); i++){
			for(int j = i+1; j < list.size(); j ++){
				if(list.get(i).getResidue() > list.get(j).getResidue()){
					Birth_listview_item item = new Birth_listview_item();
					item = list.get(i);
					list.set(i, list.get(j));
					list.set(j, item);
				}
			}
		}
		return list;
	}
	
	/********
	 * 
	 * 根据生日人id进行删除
	 * 
	 */
	public void delete_byid(int id){
		String sql = "delete from " + Sqlvalue.TABLE_birth_name + " where id='" + id + "'";
		db.execSQL(sql);
	}
	
}
