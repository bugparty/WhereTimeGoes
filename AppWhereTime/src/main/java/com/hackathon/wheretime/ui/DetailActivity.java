package com.hackathon.wheretime.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.wheretime.R;
import com.hackathon.wheretime.ui.DailyPieFragment.AnnotationAdapter.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity{
	
	private ListView detailList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_statistic);
		
		detailList = (ListView)findViewById(R.id.detailView);
		List<DetailInfo> detailInfos = createInfos();
		detailList.setAdapter(new DetailAdapter(detailInfos, this));
		
		
		TranslateAnimation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,1,Animation.RELATIVE_TO_SELF,0,
				Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
		animation.setDuration(300);
		LayoutAnimationController lac = new LayoutAnimationController(animation);
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		lac.setDelay((float)0.1);
		
		detailList.setLayoutAnimation(lac);
	}
	
	public List<DetailInfo> createInfos(){
		List<DetailInfo> detailInfos = new ArrayList<DetailInfo>();
		for(int i = 0; i < 20; i++){
			DetailInfo info = new DetailInfo();
			info.setName("test");
			info.setTime(1.23);
			detailInfos.add(info);
		}
		return detailInfos;
	}
	
	
	public class DetailAdapter extends BaseAdapter{
		
		private List<DetailInfo> infos;
		
		private Context context;
		
		public DetailAdapter(List<DetailInfo> infos, Context context){
			this.context = context;
			this.infos	= infos;
		}
			
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return infos != null ? infos.size() : 0;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return infos.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public class ViewHolder{
			TextView nameView;
			TextView timeView;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			final DetailInfo info = (DetailInfo)getItem(position);
			ViewHolder viewHolder = null;
			if(convertView  == null){
				convertView = LayoutInflater.from(context).inflate(R.layout.item_detail,null);
				viewHolder = new ViewHolder();
				viewHolder.nameView = (TextView)convertView.findViewById(R.id.nameView);
				viewHolder.timeView = (TextView)convertView.findViewById(R.id.timeView);
				
				convertView.setTag(viewHolder);
			}else{
				viewHolder = (ViewHolder)convertView.getTag();
			}
			viewHolder.nameView.setText(info.getName());
			viewHolder.timeView.setText(info.getTime() + "");
			
			return convertView;
			
		}
		
		
	}
}
