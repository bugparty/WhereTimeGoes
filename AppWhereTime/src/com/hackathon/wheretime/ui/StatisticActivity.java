package com.hackathon.wheretime.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.hackathon.wheretime.R;
import com.hackathon.wheretime.ui.indicator.TabPageIndicator;

public class StatisticActivity extends ActionBarActivity{

	private ViewPager pager;
	
	private TabPageIndicator indicator;
	
	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);
		
		actionBar = getSupportActionBar();
		//actionBar.setDisplayHomeAsUpEnabled(true);
		//actionBar.setDisplayShowTitleEnabled(true);
		
		SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.span, android.R.layout.simple_spinner_dropdown_item);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(adapter, new DropDownListener());
		
		
		pager = (ViewPager)findViewById(R.id.pager);
		pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
		indicator = (TabPageIndicator)findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}
	
	
	public class DropDownListener implements OnNavigationListener{
		
		String[] listNames = getResources().getStringArray(R.array.span);

		@Override
		public boolean onNavigationItemSelected(int arg0, long arg1) {
			// TODO Auto-generated method stub
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.commit();
            return true;
		}
		
	}
	
	/*
	
	public void onClick(View view){
		switch(view.getId()){
		case R.id.tab1:
			break;
		case R.id.tab2:
			break;
		case R.id.tab3:
			break;
		default:
			break;
		}
	}
	*/
	
	
	
}
