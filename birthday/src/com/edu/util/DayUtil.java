package com.edu.util;

import java.util.Calendar;


/**********
 * 
 * 有关日期方面的计算类
 * 当前规定：计算1900年以后的，1900年以前可能会出现问题
 * @author bing
 *
 */
public class DayUtil {
	
	private static String[] stemNames = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
	private static String[] branchNames = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉","戌","亥"};
	private static int[] daysInGrerianMont = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int BASEYEAR = 1900;
	private static final int BASEMONTH = 1;
	private static final int BASEDAY = 1;
	private static final int BASEDAYOFWEEK = 1;
	

	//返回今年的年份
	public static int getCurYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	//返回今年的月
	public static int getCurMonth(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH)+1;
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
	
	//判断日期大小
	public static boolean isBig(int year1, int month1, int day1, int year2, int month2, int day2){
		if(year1 > year2){
			return true;
		}else if(year1 == year2){
			if(month1 > month2){
				return true;
			}else if(month1 == month2){
				if(day1 >= day2){
					return true;
				}
			}
		}
		return false;
	}
	
	//得到下一个闰年
	public static int getNextLeapYear(int year){
		if(isLeapYear(year)){
			year +=1;
		}
		while(isLeapYear(year) == false){
			year += 1;
		}
		return year;
	}
	
	//计算到下一个公历生日需要的时间
	public static int getResidueToNextBirthday(int year,int month,int day){
		int CurYear,CurMonth,CurDay;
		Calendar calendar = Calendar.getInstance();
		CurYear = DayUtil.getCurYear();
		CurMonth = DayUtil.getCurMonth();
		CurDay = DayUtil.getCurDay();
		Calendar calendar2 = Calendar.getInstance();
		if(DayUtil.isLeapYear(year) && month == 2 && day == 29){
			year = CurYear;
			//如果本年也是闰年
			if(DayUtil.isLeapYear(CurYear) && DayUtil.isBig(year, month, day, CurYear, CurMonth, CurDay)){
			}else{
				year +=1;
				while(DayUtil.isLeapYear(year) == false){
					year += 1;
				}
			}
		}else{
			year = CurYear;
			if(DayUtil.isBig(year, month, day, CurYear, CurMonth, CurDay)){
			}else{
				year += 1;
			}
		}
		calendar2.set(year, month-1, day);
		long residueDay = (calendar2.getTimeInMillis() - calendar.getTimeInMillis())/(24*60*60*1000);
		return (int)residueDay;
	}
	
	//得到下一个生日日期
	public static int getNextBirthdayYear(int year, int month, int day){
		int CurYear,CurMonth,CurDay;
		Calendar calendar = Calendar.getInstance();
		CurYear = getCurYear();
		CurMonth = getCurMonth();
		CurDay = getCurDay();
		while(DayUtil.isBig(CurYear, CurMonth, CurDay, year, month, day)){
			year += 1;
		}
		return year;
	}
	
	//得到岁数
	//参数：出生年份
	public static int getAge(int year, int month, int day){
		int age = 0;
		int CurYear = getCurYear();
		int CurMonth = getCurMonth();
		int CurDay = getCurDay();
		while(isBig(CurYear, CurMonth, CurDay, year, month, day)){
			year += 1;
			age += 1;
		}
		return age;
	}
	
	//得到天干地支年
	public static String getChineseEra(int year){
		int index = (year - 4) % 60;
		return stemNames[index % 10] + branchNames[index % 12];
	}
	
	//计算当前天是在本年中的第几天
	public static int dayofYear(int year, int month, int day){
		int num = 0;
		for(int i = 1; i < month; i ++){
			num += daysInGregorianMonth(year, i);
		}
		num += day;
		return num;
	}
	
	//返回某年某月的天数
	public static int daysInGregorianMonth(int year, int month){
		int num = 0;
		num = daysInGrerianMont[month-1];
		if(isLeapYear(year) && month == 2){
			num += 1;
		}
		return num;
	}
	
	//计算某年的天数
	public static int daysInGregorianYear(int year){
		int num = 0;
		num = 365;
		if(isLeapYear(year)){
			num += 1;
		}
		return num;
	}
	
	//推断某年某月某日是星期几,0-1,1-2,2-3,3-4,4-5,5-6,6-7
	public static int dayOfWeek(int year, int month, int day){
		int num = 0;
		for(int i = BASEYEAR; i < year; i ++){
			num += daysInGregorianYear(year);
		}
		for(int i = 1; i < month; i ++){
			num += daysInGregorianMonth(year, i);
		}
		num += day;
		return num % 7;
	}
}
