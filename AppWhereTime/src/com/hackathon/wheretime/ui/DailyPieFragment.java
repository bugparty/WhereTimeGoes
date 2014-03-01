package com.hackathon.wheretime.ui;

import java.util.ArrayList;
import java.util.List;

import com.echo.holographlibrary.PieGraph;
import com.echo.holographlibrary.PieGraph.OnSliceClickedListener;
import com.echo.holographlibrary.PieSlice;
import com.example.wheretime.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class DailyPieFragment extends Fragment {
	
	
	private PieGraph overViewGraph;
	
	private ListView annotationList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_daily_pie_statistic, container,false);
		
		annotationList = (ListView)rootView.findViewById(R.id.annotationView);
		List<Annotation> annotations = createAnnotationns();
		Log.d("Main","first annotation" + annotations.get(0).getColor() + annotations.get(0).getName());
		annotationList.setAdapter(new AnnotationAdapter(this.getActivity(), annotations));
		
		
		overViewGraph = (PieGraph)rootView.findViewById(R.id.dailyGraph);
		PieSlice slice = new PieSlice();
		slice.setColor(Color.parseColor("#99CC00"));
		slice.setValue(2);
		overViewGraph.addSlice(slice);
		slice = new PieSlice();
		slice.setColor(Color.parseColor("#FFBB33"));
		slice.setValue(3);
		overViewGraph.addSlice(slice);
		slice = new PieSlice();
		slice.setColor(Color.parseColor("#AA66CC"));
		slice.setValue(8);
		overViewGraph.addSlice(slice);
		slice = new PieSlice();
		slice.setColor(Color.parseColor("#892312"));
		slice.setValue(7);
		overViewGraph.addSlice(slice);		
		overViewGraph.setCoreValue("6.5小时");
		
		overViewGraph.setOnSliceClickedListener(new OnSliceClickedListener() {
			
			@Override
			public void onClick(int index) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DailyPieFragment.this.getActivity(),DetailActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("test","test");
				startActivity(intent);
				
				
			}
		});
		return rootView;
	}
	
	
	public List<Annotation> createAnnotationns(){
		List<Annotation> annotations = new ArrayList<Annotation>();
		Annotation annotation = new Annotation();
		annotation.setColor("#99CC00");
		annotation.setName("工作");
		Annotation annotation2 = new Annotation();
		annotation2.setColor("#FFBB33");
		annotation2.setName("学习");
		Annotation annotation3 = new Annotation();
		annotation3.setColor("#AA66CC");
		annotation3.setName("娱乐");
		Annotation annotation4 = new Annotation();
		annotation4.setColor("#892312");
		annotation4.setName("其他");
		annotations.add(annotation);
		annotations.add(annotation2);
		annotations.add(annotation3);
		annotations.add(annotation4);
		return annotations;
	}
	
	
	public class AnnotationAdapter extends BaseAdapter{
		
		private List<Annotation> annotations;
		
		private Context context;
		
		public AnnotationAdapter(Context context, List<Annotation> annotations){
			this.context = context;
			this.annotations = annotations;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return annotations != null ? annotations.size() : 0;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return annotations.get(arg0);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public class ViewHolder{
			View colorView;
			TextView nameView;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Annotation annotation	= (Annotation)getItem(position);
			ViewHolder viewHolder = null;
			if(convertView  == null){
				convertView = LayoutInflater.from(context).inflate(R.layout.item_annotation,null);
				viewHolder = new ViewHolder();
				viewHolder.colorView = (View)convertView.findViewById(R.id.color);
				viewHolder.nameView = (TextView)convertView.findViewById(R.id.name);
				
				convertView.setTag(viewHolder);
			}else{
				viewHolder = (ViewHolder)convertView.getTag();
			}
			viewHolder.colorView.setBackgroundColor(Color.parseColor(annotation.getColor()));
			viewHolder.nameView.setText(annotation.getName());
			
			
			return convertView;
		}
		
	}
	
	
}