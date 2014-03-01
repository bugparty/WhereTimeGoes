package com.hackathon.wheretime.ui;

import java.math.BigDecimal;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

public class DetailInfo {
	
	private DrawableCompat icon;

	private String name;
	
	private double time;
	
	public Drawable getIcon(){
		return icon;
	}
	
	public void setIcon(Drawable icon){
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
	
	
	public double getFormatTime(){
		double hTime = time / 3600.0;
		BigDecimal bd = new BigDecimal(hTime);
		bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
		return bd.doubleValue();
	}
	
}
