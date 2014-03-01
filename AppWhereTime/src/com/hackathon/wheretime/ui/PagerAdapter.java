package com.hackathon.wheretime.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.AppData.Span;

public class PagerAdapter extends FragmentStatePagerAdapter {
	
	private static final String[] CONTENT = new String[]{"…»–ŒÕº", "’€œﬂÕº"};
	
	private FragmentManager fm;

	public PagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fm = fm;
		
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		Fragment fragment = null;
		switch(arg0){
		case 0:
			Log.d("Main","day");
			fragment = new DailyPieFragment();
			break;
		case 1:
			Log.d("Main","weekly");
			if(AppData.selectedSpan == Span.DAILY)
				fragment = new DailyBarFragment();
			else if(AppData.selectedSpan == Span.WEEKLY)
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
	
	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}
	
	
}
