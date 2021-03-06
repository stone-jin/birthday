package com.edu.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/********
 * 
 * 拼音工具类
 * 
 * @author bing
 *
 */
public class PinyinUtil {

	/**********
	 * 
	 * 将字符串中的中文转化为拼音，其他字符不变
	 * 
	 * 张三->ZHANGSAN
	 * 
	 */
	public static String getPinyin(String str){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		char[] input = str.trim().toCharArray();
		String output = "";
		for(int i = 0; i < input.length; i++){
			if(java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")){
				try {
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
					output += temp[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				output += java.lang.Character.toString(input[i]);
			}
		}
		return output;
	}
	
	/**********
	 * 
	 * 将字符串中的中问转化为拼音首字母的大写
	 * 
	 * 张三-ZS
	 * 
	 */
	public static String converToFirstSpell(String str){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		char[] input = str.trim().toCharArray();
		String output = "";
		for(int i = 0; i < input.length; i++){
			if(java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")){
				try {
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
					output += temp[0].charAt(0);
					i++;
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				output += input[i];
			}
		}
		return output;
	}
}
