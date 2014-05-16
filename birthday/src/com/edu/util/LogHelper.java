package com.edu.util;

import android.util.Log;

public class LogHelper {
	private static boolean mIsDebugMode = true;//��ȡ��ջ��Ϣ��Ӱ�����ܣ�����Ӧ��ʱ�ǵùر�DebugModeģʽ
	private static String mLogTag = "PickingStone";
	
	private static final String CLASS_METHOD_LINE_FORMAT = "%s.%s() (%s) Line:%d";
	
	public static void trace(){
		if(mIsDebugMode){
			StackTraceElement traceElement = Thread.currentThread().getStackTrace()[3];//�Ӷ�ջ��Ϣ�л�ȡ��ǰ�����õķ�����Ϣ
			String logText = String.format(CLASS_METHOD_LINE_FORMAT, traceElement.getClassName(), traceElement.getMethodName()
								, traceElement.getFileName(), traceElement.getLineNumber());
			Log.d(mLogTag, logText);
		}
	}
}
