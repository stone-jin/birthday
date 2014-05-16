package com.edu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.util.Base64;

public class Encrypt {
	//BASE64可逆加密算法
	public static String encryptBase64(String s){
		String result = Base64.encodeToString(s.getBytes(), Base64.DEFAULT);
		return result;
	}
	
	//MD5不可逆加密算法
	public static String encrpyMD5(String s){
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(s.getBytes());
			byte[] m = md5.digest();
			return getString(m);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	private static String getString(byte[] b){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < b.length; i++){
			sb.append(b[i]);
		}
		return sb.toString();
	}
}
