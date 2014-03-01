package com.hackathon.wheretime.ui;


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
		
		Line l = new Line();
		LinePoint p = new LinePoint();
		p.setX(0);
		p.setY(5);
        p.setColor("#FF0000");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(2);
		p.setY(8);
        p.setColor("#0000FF");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(4);
		p.setY(4);
        p.setColor("#00FF00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(6);
		p.setY(6);
        p.setColor("#00FF00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(8);
		p.setY(8);
        p.setColor("#00FF00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(10);
		p.setY(10);
        p.setColor("#00FF00");
		l.addPoint(p);
		p = new LinePoint();
		p.setX(12);
		p.setY(12);
        p.setColor("#00FF00");
		l.addPoint(p);
		l.setColor(Color.parseColor("#FFBB33"));
		
		Line ll = new Line();
		LinePoint pp = new LinePoint();
		pp.setX(0);
		pp.setY(6);
        pp.setColor("#FF0000");
		ll.addPoint(pp);
		pp = new LinePoint();
		pp.setX(8);
		pp.setY(9);
        pp.setColor("#0000FF");
		ll.addPoint(pp);
		pp = new LinePoint();
		pp.setX(10);
		pp.setY(6);
		ll.addPoint(pp);
        pp.setColor("#00FF00");
		ll.setColor(Color.parseColor("#FFBB33"));
		
		weeklyGraph = (LineGraph)rootView.findViewById(R.id.weeklyGraph);
		weeklyGraph.addLine(l);
		weeklyGraph.addLine(ll);
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
	
}
