package com.hackathon.wheretime.ui;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;
import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.AppData.Span;
import com.hackathon.wheretime.R;

import java.util.ArrayList;

public class DailyBarFragment extends Fragment{

	
	private BarGraph barGraph;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_daily_bar_statistic, container,false);
		
		barGraph = (BarGraph)rootView.findViewById(R.id.dailyBarGraph);
		if(AppData.selectedSpan == Span.DAILY){
			
			ArrayList<Bar> points = new ArrayList<Bar>();
			Bar d = new Bar();
			d.setColor(Color.parseColor("#99CC00"));

            d.setName("工作");

            d.setValue(1000);
            d.setValueString("0.57小时");
            Bar d2 = new Bar();
			d2.setColor(Color.parseColor("#FFBB33"));
            d2.setName("映射");
            d2.setValue(2000);
            d2.setValueString("0.85小时");
            Bar d3 = new Bar();
			d3.setColor(Color.parseColor("#AA66CC"));
            d3.setName("游戏");
            d3.setValue(800);
            d3.setValueString("2.26小时");
            Bar d4 = new Bar();
			d4.setColor(Color.parseColor("#892312"));
            d4.setName("社交 ");
            d4.setValue(200);
            d4.setValueString("1.98小时");
            Bar d5 = new Bar();
			d5.setColor(Color.parseColor("#674256"));
            d5.setName("其他");
            d5.setValue(200);
            d5.setValueString("0.85小时");
            points.add(d);
			points.add(d2);
			points.add(d3);
			points.add(d4);
			points.add(d5);
			barGraph.setBars(points);
			
			barGraph.setOnBarClickedListener(new OnBarClickedListener(){
	
				@Override
				public void onClick(int index) {
                    new AlertDialog.Builder(DailyBarFragment.this.getActivity()).setTitle("每日最长使用时间 ")
                            .setView(new EditText(DailyBarFragment.this.getActivity()))
                            .setPositiveButton("确定", null).setNegativeButton("取消", null).show();
                }
				
			});
		}
			
		return rootView;
	}
	
}
