package com.edu.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefrencesUtil {
	//tableΪSharedPrefrences���ļ�����sΪ����dataΪֵ
	public static void saveToSharedPrefrences(String table, String s,String data,Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(table, 0);
		Editor editor = sharedPreferences.edit();
		editor.putString(s, data);
		editor.commit();
	}
	
	//tableΪSharedPrefrences���ļ�����sΪ����dataΪֵ
	//account --->haveSaved��������Ƿ��Ѿ��������˺�����
	public static void saveToSharedPrefrences(String table,String s,Boolean data,Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(table, 0);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(s, data);
		editor.commit();
	}
	
	//tableΪSharedPrefrences���ļ�����sΪ����s1��ʾ����
	public static String getSharedPrefrences(String table,String s,String s1,Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(table, 0);
		String result = sharedPreferences.getString(s, "");
		return result;
	}
	
	//tableΪSharedPrefrences���ļ�����sΪ����s1λ����
	public static Boolean getSharedPrefrences(String table,String s,Boolean s1,Context context){
		SharedPreferences sharedPreferences = context.getSharedPreferences(table, 0);
		Boolean result = sharedPreferences.getBoolean(s, false);
		return result;
	}
}
