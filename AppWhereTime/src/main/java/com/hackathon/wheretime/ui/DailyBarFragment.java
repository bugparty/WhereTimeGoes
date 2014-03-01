package com.hackathon.wheretime.ui;

import java.util.ArrayList;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;
import com.example.wheretime.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DailyBarFragment extends Fragment{

	
	private BarGraph barGraph;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_daily_bar_statistic, container,false);
		
		barGraph = (BarGraph)rootView.findViewById(R.id.dailyBarGraph);
		
		ArrayList<Bar> points = new ArrayList<Bar>();
		Bar d = new Bar();
		d.setColor(Color.parseColor("#99CC00"));
		d.setName("����");
		d.setValue(1000);
		d.setValueString("3.4Сʱ");
		Bar d2 = new Bar();
		d2.setColor(Color.parseColor("#FFBB33"));
		d2.setName("ѧϰ");
		d2.setValue(2000);
		d2.setValueString("5Сʱ");
		Bar d3 = new Bar();
		d3.setColor(Color.parseColor("#AA66CC"));
		d3.setName("����");
		d3.setValue(800);
		d3.setValueString("2.3Сʱ");
		Bar d4 = new Bar();
		d4.setColor(Color.parseColor("#892312"));
		d4.setName("���� ");
		d4.setValue(200);
		d4.setValueString("1.2Сʱ");
		points.add(d);
		points.add(d2);
		points.add(d3);
		points.add(d4);
		
		barGraph.setBars(points);
		
		barGraph.setOnBarClickedListener(new OnBarClickedListener(){

			@Override
			public void onClick(int index) {
				
			}
			
		});
		
		return rootView;
	}
	
}
