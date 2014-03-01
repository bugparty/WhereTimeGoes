package com.hackathon.wheretime.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
	
	private static final String[] CONTENT = new String[]{"����ͼ", "����ͼ","����"};

	public PagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		switch(arg0){
		case 0:
			fragment = new DailyPieFragment();
			break;
		case 1:
			fragment = new DailyBarFragment();
			break;
		case 2:
			fragment = new WeeklyFragment();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return CONTENT.length;
	}

	
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		return CONTENT[position % CONTENT.length];
	}
	
	
	
	
}
