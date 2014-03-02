package com.hackathon.wheretime.ui;

import java.util.ArrayList;

import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.echo.holographlibrary.BarGraph.OnBarClickedListener;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.AppData.Span;
import com.hackathon.wheretime.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
	
			d.setName("����");
	
			d.setValue(1000);
			d.setValueString("0.57Сʱ");
			Bar d2 = new Bar();
			d2.setColor(Color.parseColor("#FFBB33"));
			d2.setName("ӳ��");
			d2.setValue(2000);
			d2.setValueString("0.85Сʱ");
			Bar d3 = new Bar();
			d3.setColor(Color.parseColor("#AA66CC"));
			d3.setName("��Ϸ");
			d3.setValue(800);
			d3.setValueString("2.26Сʱ");
			Bar d4 = new Bar();
			d4.setColor(Color.parseColor("#892312"));
			d4.setName("�罻 ");
			d4.setValue(200);
			d4.setValueString("1.98Сʱ");
			Bar d5 = new Bar();
			d5.setColor(Color.parseColor("#674256"));
			d5.setName("����");
			d5.setValue(200);
			d5.setValueString("0.85Сʱ");
			points.add(d);
			points.add(d2);
			points.add(d3);
			points.add(d4);
			points.add(d5);
			barGraph.setBars(points);
			
			barGraph.setOnBarClickedListener(new OnBarClickedListener(){
	
				@Override
				public void onClick(int index) {
					new AlertDialog.Builder(DailyBarFragment.this.getActivity()).setTitle("ÿ���ʹ��ʱ�� ")
						.setView(new EditText(DailyBarFragment.this.getActivity()))
						.setPositiveButton("ȷ��", null).setNegativeButton("ȡ��", null).show();
				}
				
			});
		}
			
		return rootView;
	}
	
}
