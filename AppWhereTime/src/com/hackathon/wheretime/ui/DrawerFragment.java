package com.hackathon.wheretime.ui;

import java.util.ArrayList;
import java.util.List;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.R;
import com.hackathon.wheretime.AppData.Span;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class DrawerFragment extends Fragment{
	
	private ListView listView;
	
	private DrawerAdapter drawerAdapter;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView  = inflater.inflate(R.layout.fragment_drawer,container,false);
        listView = (ListView) rootView.findViewById(R.id.drawerListView);
        List<String> items = new ArrayList<String>();
        items.add("每天");
        items.add("每周");
        drawerAdapter = new DrawerAdapter(listView,items);
        listView.setAdapter(drawerAdapter);
        listView.setItemChecked(0, true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listView.setItemChecked(position, true);
                if(position == 0)
                	AppData.selectedSpan = Span.DAILY;
                else
                	AppData.selectedSpan = Span.WEEKLY;
                ((StatisticActivity)DrawerFragment.this.getActivity()).contentFragment
                		.pagerAdapter.notifyDataSetChanged();
                ((StatisticActivity)DrawerFragment.this.getActivity()).drawerLayout.closeDrawers();
            }
        });
		return rootView;
	}
	
}
