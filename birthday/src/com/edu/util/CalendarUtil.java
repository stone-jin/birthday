package com.edu.util;

import android.text.format.DateUtils;

//日期计算类
public class CalendarUtil {

	private int gregorianYear; //公历年
	private int gregorianMonth; //公历月
	private int gregorianDay;  //公历日
	private boolean isGregorianLeap; //是否是闰年
	private int dayofYear;  //一年中的第几天
	private int dayofWeek;  //周日一星期的第一天
	private int chineseYear;  //农历年
	private int chineseMonth;   //负数表示闰月
	private int chineseDate;   //农历日
	private int sectionalTerm;
	private int principleTerm;
	
	//初始日，公历农历对应日期:
	//公历1901年1月1日，对应农历4598年11月11日
	private static int baseYear = 1901;
	private static int baseMonth = 1;
	private static int baseDate = 1;
	private static int baseIndex = 0;
	private static int baseChineseYear = 4598 - 1;
	private static int baseChineseMonth = 11;
	private static int baseChineseDate = 11;
	
	private String getChineseDay(int year, int month, int day){
		setGregorian(year,month,day);
		return "";
	}
	
	private void setGregorian(int year, int month, int day){
		this.gregorianYear = year;
		this.gregorianMonth = month;
		this.gregorianDay = day;
		isGregorianLeap = DayUtil.isLeapYear(year);
		dayofYear = DayUtil.dayofYear(year, month, day);
		dayofWeek = DayUtil.dayOfWeek(year, month, day);
		chineseYear = 0;
		chineseMonth = 0;
		chineseDate = 0;
		sectionalTerm = 0;
		principleTerm = 0;
	}
	
	public int computeChineseFields(){
		if(gregorianYear < 1901 || gregorianYear > 2100)
			return 1;
		int startYear = baseYear;
		int startMonth = baseMonth;
		int startDate = baseDate;
		chineseYear = baseChineseYear;
		chineseMonth = baseChineseMonth;
		chineseDate = baseChineseDate;
		//第二个对应日，用以提高计算效率和精确值
		//公历2000年1月1日，对应农历4697年11月25日
		if(gregorianYear >= 2000){
			startYear = baseYear + 99;
			startMonth = 1;
			startDate = 1;
			chineseYear = baseChineseYear + 99;
			chineseMonth = 11;
			chineseDate = 25;
		}
		int dayDiff = 0;
		for(int i = startYear; i < gregorianYear; i++){
			dayDiff += 365;
			if(DayUtil.isLeapYear(i)){
				dayDiff += 1;
			}
		}
		for(int i = startMonth; i < gregorianMonth; i++){
			dayDiff += DayUtil.daysInGregorianMonth(gregorianYear, i);
		}
		dayDiff += gregorianDay - startDate;
		chineseDate += dayDiff;
		return 0;
	}
	
	public static int daysInChineseMonth(int year,int month){
		//注意：闰月 month < 0 
		int index = year - baseChineseYear + baseIndex;
		int v = 0;
		int l = 0;
		int d = 30;
		return 0;
	}
}
