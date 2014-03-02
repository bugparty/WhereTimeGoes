package com.hackathon.wheretime.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackathon.wheretime.R;
import com.hackathon.wheretime.ui.indicator.TabPageIndicator;

public class ContentFragment extends Fragment{
	
	public ViewPager pager;
	
	private TabPageIndicator indicator;
	
	public PagerAdapter pagerAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_content,container,false);
		
		pager = (ViewPager)rootView.findViewById(R.id.pager);

        pagerAdapter = new PagerAdapter(ContentFragment.this.getActivity());
        pager.setAdapter(pagerAdapter);

		indicator = (TabPageIndicator)rootView.findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		
		return rootView;
	}
	
	
	
}
