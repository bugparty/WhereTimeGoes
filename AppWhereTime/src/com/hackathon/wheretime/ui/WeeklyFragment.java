package com.hackathon.wheretime.ui;


import java.util.ArrayList;
import java.util.List;

import com.echo.holographlibrary.Line;
import com.echo.holographlibrary.LineGraph;
import com.echo.holographlibrary.LineGraph.OnPointClickedListener;
import com.echo.holographlibrary.LinePoint;
import com.hackathon.wheretime.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WeeklyFragment extends Fragment{

	
	private LineGraph weeklyGraph;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_weekly_statistic,container,false);
		
		Line l = createLine();
		Line l2 = createLine(0,3,2,5,4,4,6,8,8,10,10,2,12,7,"#ffbb33");
		Line l3 = createLine(0,5,2,5,4,7,6,1,8,9,10,3,12,5,"#aa66cc");
		Line l4 = createLine(0,2,2,2,4,5,6,9,8,1,10,9,12,3,"#892312");
		
		weeklyGraph = (LineGraph)rootView.findViewById(R.id.weeklyGraph);
		weeklyGraph.addLine(l);
		weeklyGraph.addLine(l2);
		weeklyGraph.addLine(l3);
		weeklyGraph.addLine(l4);
		weeklyGraph.setRangeY(0, 14);
		weeklyGraph.setRangeX(0, 14);
		
		weeklyGraph.setOnPointClickedListener(new OnPointClickedListener(){

			@Override
			public void onClick(int lineIndex, int pointIndex) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		return rootView;
	}
	
	
	
	
	private Line createLine(){
		
		Line l = new Line();
		LinePoint p = new LinePoint();
		p.setX(0);
		p.setY(5);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(2);
		p.setY(8);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(4);
		p.setY(4);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(6);
		p.setY(6);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(8);
		p.setY(8);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(10);
		p.setY(10);
        p.setColor("#99CC00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(12);
		p.setY(12);
        p.setColor("#99CC00");
		l.addPoint(p);
		l.setColor(Color.parseColor("#99CC00"));
		return l;
	}
	
	private Line createLine(double x1, double y1, double x2, double y2, double x3, double y3,
			double x4, double y4, double x5, double y5, double x6, double y6, double x7, double y7,
			String color){
		
		Line l = new Line();
		LinePoint p = new LinePoint();
		p.setX(x1);
		p.setY(y1);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x2);
		p.setY(y2);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x3);
		p.setY(y3);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x4);
		p.setY(y4);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x5);
		p.setY(y5);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x6);
		p.setY(y6);
        p.setColor(color);
		l.addPoint(p);
		p = new LinePoint();
		p.setX(x7);
		p.setY(y7);
        p.setColor(color);
		l.addPoint(p);
		l.setColor(Color.parseColor(color));
		return l;
	}
	
}
