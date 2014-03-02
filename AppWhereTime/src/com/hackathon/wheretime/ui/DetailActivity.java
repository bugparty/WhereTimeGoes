package com.hackathon.wheretime.ui;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.ui.DailyPieFragment.AnnotationAdapter.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import com.hackathon.wheretime.R;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity{
	
	private ListView detailList;
	
	private ActionBar actionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_statistic);
		
		actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		detailList = (ListView)findViewById(R.id.detailView);
		detailList.setDivider(AppData.getContext().getResources().getDrawable(R.drawable.list_divider));
		detailList.setDividerHeight(2);
		List<DetailInfo> detailInfos = createInfos();
		detailList.setAdapter(new DetailAdapter(detailInfos, this));
		
		
		TranslateAnimation animation = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,1,Animation.RELATIVE_TO_SELF,0,
				Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0);
		animation.setDuration(300);
		LayoutAnimationController lac = new LayoutAnimationController(animation);
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		lac.setDelay((float)0.05);
		
		detailList.setLayoutAnimation(lac);
	}
	
	public List<DetailInfo> createInfos(){
		List<DetailInfo> detailInfos = new ArrayList<DetailInfo>();
		for(int i = 0; i < 20; i++){
			DetailInfo info = new DetailInfo();
			info.setIcon(AppData.getContext().getResources().getDrawable(R.drawable.ic_launcher));
			info.setName("test");
			info.setTime(9876);
			detailInfos.add(info);
		}
		return detailInfos;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
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

			ImageView iconView;
			View lineView;
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
				viewHolder.iconView = (ImageView)convertView.findViewById(R.id.appIcon);
				viewHolder.lineView = (View)convertView.findViewById(R.id.lineView);
				viewHolder.nameView = (TextView)convertView.findViewById(R.id.appName);
				viewHolder.timeView = (TextView)convertView.findViewById(R.id.activeTime);
				
				convertView.setTag(viewHolder);
			}else{
				viewHolder = (ViewHolder)convertView.getTag();
			}
			viewHolder.iconView.setImageDrawable(info.getIcon());
			viewHolder.lineView.getLayoutParams().width = (int)(info.getFormatTime() / 4.0 * 300);
			viewHolder.nameView.setText(info.getName());
			viewHolder.timeView.setText(info.getFormatTime() + "Сʱ");
			
			return convertView;
			
		}
		
		
	}
}
