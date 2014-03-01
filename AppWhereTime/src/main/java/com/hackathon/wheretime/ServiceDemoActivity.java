package com.hackathon.wheretime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hackathon.wheretime.app.StatService;

import java.util.ArrayList;

import com.example.wheretime.R;

public class ServiceDemoActivity extends ActionBarActivity {
    final String TAG = "ServiceDemoActivity";
    StatService mService;

    boolean mBound = false;
    /**
     * Dispatch onStart() to all fragments.  Ensure any created loaders are
     * now started.
     */
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,StatService.class);
        bindService(intent,mConnection,Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_stat_service_demo);
        final View text = findViewById(R.id.textView);
        final ListView lv = (ListView)findViewById(R.id.tv);
        final Context context = getApplicationContext();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> l = new ArrayList<String>();
                assert(mService!= null);


                l.add(mService.getRunningTaskInfo().topActivity.toString());
                ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1,l);
                lv.setAdapter(adapter);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            StatService.StatBinder binder = (StatService.StatBinder) service;
            mService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

}
