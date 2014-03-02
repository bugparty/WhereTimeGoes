package com.hackathon.wheretime.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by bowman on 14-3-2.
 */
public class StatServiceConn implements ServiceConnection {
    final String TAG = "StatServiceConn";
    boolean mBound = false;
    IStatService mService;

    public boolean isBound() {
        return mBound;
    }

    public IStatService getService() {
        return mService;
    }

    public StatServiceConn() {
    }

    /**
     * Called when a connection to the Service has been established, with
     * the {@link android.os.IBinder} of the communication channel to the
     * Service.
     *
     * @param name    The concrete component name of the service that has
     *                been connected.
     * @param service The IBinder of the Service's communication channel,
     */
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        // We've bound to LocalService, cast the IBinder and get LocalService instance
        Log.i(TAG, "ServiceConneted");
        mService = IStatService.Stub.asInterface(service);
        try {
            String currentApp = mService.getCurrentRuningApp();
            mBound = true;
        } catch (RemoteException e) {
            e.printStackTrace();

        }
    }

    /**
     * Called when a connection to the Service has been lost.  This typically
     * happens when the process hosting the service has crashed or been killed.
     * This does <em>not</em> remove the ServiceConnection itself -- this
     * binding to the service will remain active, and you will receive a call
     * to {@link #onServiceConnected} when the Service is next running.
     *
     * @param name The concrete component name of the service whose
     *             connection has been lost.
     */
    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.i(TAG, name.getClassName() + "has lose conn to StatService");
        mBound = false;
    }
}
