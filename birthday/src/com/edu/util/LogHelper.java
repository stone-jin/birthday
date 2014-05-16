package com.edu.util;

import android.util.Log;

public class LogHelper {
	private static boolean mIsDebugMode = true;//获取堆栈信息会影响性能，发布应用时记得关闭DebugMode模式
	private static String mLogTag = "PickingStone";
	
	private static final String CLASS_METHOD_LINE_FORMAT = "%s.%s() (%s) Line:%d";
	
	public static void trace(){
		if(mIsDebugMode){
			StackTraceElement traceElement = Thread.currentThread().getStackTrace()[3];//从堆栈信息中获取当前被调用的方法信息
			String logText = String.format(CLASS_METHOD_LINE_FORMAT, traceElement.getClassName(), traceElement.getMethodName()
								, traceElement.getFileName(), traceElement.getLineNumber());
			Log.d(mLogTag, logText);
		}
	}
}
