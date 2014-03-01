package com.hackathon.wheretime.util;


import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.constant.AppConstant;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceUtil {

	private static SharedPreferenceUtil sharedPreferenceUtil;
	
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	
	private SharedPreferenceUtil(Context context,String file) {
		// TODO Auto-generated constructor stub
		sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
		editor = sp.edit();
	}
	
	public synchronized static SharedPreferenceUtil getInstance(){
		if(sharedPreferenceUtil == null){
			sharedPreferenceUtil = new SharedPreferenceUtil(AppData.getContext(), AppConstant.STORAGE);
		}
		return sharedPreferenceUtil;
	}
	
	public int addNotificationCount(){
		int count = sp.getInt("notificationCount", -1);
		if(count != -1){
			count ++;
			editor.putInt("notificationCount", count)
				.commit();
			return count;
		}else{
			editor.putInt("notificationCount", 1)
			.commit();
			return 1;
		}
	}
	
	public void setNotificationCount(int count){
		editor.putInt("notificationCount", count)
			.commit();
	}
	
	public int getNotificationCount(){
		return sp.getInt("notificationCount", -1);
	}
	
	// appid
	public void setAppId(String appid) {
		// TODO Auto-generated method stub
		editor.putString("appid", appid);
		editor.commit();
	}

	public String getAppId() {
		return sp.getString("appid", "");
	}

	// user_id
	public void setUserId(String userId) {
		editor.putString("userId", userId);
		editor.commit();
	}

	public String getUserId() {
		return sp.getString("userId", "");
	}

	// channel_id
	public void setChannelId(String ChannelId) {
		editor.putString("ChannelId", ChannelId);
		editor.commit();
	}

	public String getChannelId() {
		return sp.getString("ChannelId", "");
	}

	// nick
	public void setNick(String nick) {
		editor.putString("nick", nick);
		editor.commit();
	}

	public String getNick() {
		return sp.getString("nick", "");
	}

	public int getHeadIcon() {
		return sp.getInt("headIcon", 0);
	}

	public void setHeadIcon(int icon) {
		editor.putInt("headIcon", icon);
		editor.commit();
	}
	
	
	
}
