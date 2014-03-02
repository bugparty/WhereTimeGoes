package com.hackathon.wheretime;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hackathon.wheretime.service.StatServiceConn;
import com.hackathon.wheretime.util.StatServiceUtil;

import java.util.ArrayList;

public class ServiceDemoActivity extends ActionBarActivity {
    final String TAG = "ServiceDemoActivity";
    //IStatService mService;
    // String currentApp;
    //boolean mBound = false;

    /**
     * Dispatch onStart() to all fragments.  Ensure any created loaders are
     * now started.
     */
    @Override
    protected void onStart() {
        super.onStart();

    }

    /**
     * Defines callbacks for service binding, passed to bindService()
     */
    private StatServiceConn mConnection = new StatServiceConn();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        final Context context = getApplicationContext();
        setContentView(R.layout.activity_stat_service_demo);

        StatServiceUtil.bindStatService(this, mConnection);

        final View text = findViewById(R.id.textView);
        final ListView lv = (ListView) findViewById(R.id.tv);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> l = new ArrayList<String>();
                try {
                    l.add(mConnection.getService().getCurrentRuningApp());
                    ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, l);
                    lv.setAdapter(adapter);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }


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


}
