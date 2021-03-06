package com.example.feagleeye.hookclass;


import com.example.feagleeye.NativeEntry;

import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook.MethodHookParam;

public class ApplicationHook extends MethodHook {
	private static final String mClassName = "android.app.Application";
	
	public ApplicationHook(Methods method) {
		super(mClassName, method.name());
	}

	// public void onCreate()
	// frameworks/base/core/java/android/app/Application.java
	// http://developer.android.com/reference/android/app/Application.html

	private enum Methods {
		onCreate
	};

	public static List<MethodHook> getMethodHookList() {
		List<MethodHook> methodHookList = new ArrayList<MethodHook>();
		methodHookList.add(new ApplicationHook(Methods.onCreate));
		return methodHookList;
	}
	
	public void after(MethodHookParam param) throws Throwable {
		NativeEntry.initSystemNativeHook();
	}
	
}
