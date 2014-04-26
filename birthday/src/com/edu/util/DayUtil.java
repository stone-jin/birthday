package com.edu.util;

import java.util.Calendar;


/**********
 * 
 * 有关日期方面的计算类
 * 
 * @author bing
 *
 */
public class DayUtil {

	//返回今年的年份
	public static int getCurYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	//返回今年的月
	public static int getCurMonth(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH);
	}
	
	//返回今年的日
	public static int getCurDay(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	//根据生日年份计算出本年的生肖
	public static String getAnimals(int year){
		String s = "猴鸡狗猪鼠牛虎兔龙蛇马羊";
		int index = (year % 12);
		return Character.toString(s.charAt(index));
	}
	
	//根据生日月份算星座
	public static String getConstellation(int mouth, int day){
		String s = "摩羯水瓶双鱼白羊金牛双子巨蟹狮子处女天秤天蝎射手摩羯";
		int days[] = {20,19,20,20,21,21,22,23,23,23,22,21,20};
		int index = ((day <= days[mouth -1])?0:2) + (mouth -1) *2;
		return s.substring(index, index+2) + "座";
	}
	
	//根据年份判断是否是闰年
	public static boolean isLeapYear(int year){
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			return true;
		}
		return false;
	}
}
