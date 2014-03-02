package com.hackathon.wheretime.ui;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.R;

public class StatisticActivity extends ActionBarActivity{
	
	public DrawerLayout drawerLayout;
	
	public ActionBarDrawerToggle drawerToggle;
	
	private ActionBar actionBar;
	
	public ContentFragment contentFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_statistic);
		
		drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerLayout.setScrimColor(Color.argb(100, 0, 0, 0));
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setIcon(AppData.getContext().getResources().getDrawable(R.drawable.ic_actionbar));
		actionBar.setTitle(getStrDate());
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer,
                R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
            	super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
            	super.onDrawerOpened(drawerView);
            }
            
        };
        
        drawerLayout.setDrawerListener(drawerToggle); 
		
		
		contentFragment = new ContentFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, contentFragment).commit();
		
        fragmentManager.beginTransaction().replace(R.id.left_drawer, new DrawerFragment()).commit();
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	private String getStrDate(){
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  E");
		String strDate = format.format(date);
		return strDate;
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}
	
	
	public void tab1Click(View view){
		contentFragment.pager.setCurrentItem(0);
	}
	
	public void tab2Click(View view){
		contentFragment.pager.setCurrentItem(1);
	}
	
	
	public void shareClick(View view){
		return;
	}
	
	
}
