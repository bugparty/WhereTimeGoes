package com.hackathon.wheretime.ui;

import java.util.List;

import com.hackathon.wheretime.AppData;
import com.hackathon.wheretime.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {
    private ListView mListView;
    
    private List<String> items;

    public DrawerAdapter(ListView listView,List<String> items) {
        mListView = listView;
        this.items = items;
    }

    @Override
    public int getCount() {
    	return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(AppData.getContext()).inflate(
                    R.layout.item_drawer, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        textView.setText(getItem(position));
        textView.setSelected(mListView.isItemChecked(position));
        return convertView;
    };
}
