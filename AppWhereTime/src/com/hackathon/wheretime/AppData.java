package com.hackathon.wheretime;


import android.app.Application;
import android.content.Context;

public class AppData extends Application{
	
	public static final int DAILY = 0;
	
	public static final int WEEKLY = 1;

	private static Context context;	
	
	public enum Span{
		DAILY, WEEKLY
	}
	
	public static Span selectedSpan = Span.DAILY;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		context = getApplicationContext();
	}
	
	public static Context getContext(){
		return context;
	}
	
	
}
