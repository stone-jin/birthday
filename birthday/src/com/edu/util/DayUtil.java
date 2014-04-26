package com.edu.util;

import java.util.Calendar;


/**********
 * 
 * �й����ڷ���ļ�����
 * 
 * @author bing
 *
 */
public class DayUtil {

	//���ؽ�������
	public static int getCurYear(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}
	
	//���ؽ������
	public static int getCurMonth(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH);
	}
	
	//���ؽ������
	public static int getCurDay(){
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	//����������ݼ�����������Ф
	public static String getAnimals(int year){
		String s = "�Ｆ������ţ������������";
		int index = (year % 12);
		return Character.toString(s.charAt(index));
	}
	
	//���������·�������
	public static String getConstellation(int mouth, int day){
		String s = "Ħ��ˮƿ˫������ţ˫�Ӿ�зʨ�Ӵ�Ů�����Ы����Ħ��";
		int days[] = {20,19,20,20,21,21,22,23,23,23,22,21,20};
		int index = ((day <= days[mouth -1])?0:2) + (mouth -1) *2;
		return s.substring(index, index+2) + "��";
	}
	
	//��������ж��Ƿ�������
	public static boolean isLeapYear(int year){
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
			return true;
		}
		return false;
	}
}