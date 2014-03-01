package com.hackathon.wheretime.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.example.wheretime.R;
import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.AppData.Span;
import com.hackathon.wheretime.ui.indicator.TabPageIndicator;

public class StatisticActivity extends ActionBarActivity{

	private ViewPager pager;
	
	private TabPageIndicator indicator;
	
	private ActionBar actionBar;
	
	private PagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);
		
		actionBar = getSupportActionBar();
		
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.span, android.R.layout.simple_spinner_dropdown_item);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(adapter, new DropDownListener());
		
		
		pager = (ViewPager)findViewById(R.id.pager);
		pagerAdapter = new PagerAdapter(getSupportFragmentManager());
		pager.setAdapter(pagerAdapter);
		indicator = (TabPageIndicator)findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}
	
	
	public class DropDownListener implements OnNavigationListener{
		
		String[] listNames = getResources().getStringArray(R.array.span);

		@Override
		public boolean onNavigationItemSelected(int arg0, long arg1) {
			// TODO Auto-generated method stub
			if(arg0 == 0){
				AppData.selectedSpan = Span.DAILY;
				Log.d("Main","daily " + arg0);
			}
			else{
				AppData.selectedSpan = Span.WEEKLY;
				Log.d("Main","WEEKLY " + arg0);
			}
			pagerAdapter.notifyDataSetChanged();
			
            return true;
		}
		
	}
	
	
	public void tab1Click(View view){
		pager.setCurrentItem(0);
	}
	
	public void tab2Click(View view){
		pager.setCurrentItem(1);
	}
	
	
	
}
