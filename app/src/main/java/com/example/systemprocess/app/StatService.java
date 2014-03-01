package com.example.systemprocess.app;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.systemprocess.model.AppStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by bowman on 14-3-1.
 */
public class StatService extends Service {
    public final String TAG = "StatService";
    private final IBinder mBinder = new StatBinder();
    private ActivityManager AM;
    private Timer mTimer;
    private Context mContext;
    private HashMap<ActivityManager.RunningTaskInfo,AppStats> mStats;
    public StatService() {
        super();
        mStats = new HashMap<ActivityManager.RunningTaskInfo, AppStats>();
        Log.d(TAG, "onInit");
    }
    public void startStat(){
        if(mContext == null){
            mContext = getApplicationContext();
            if(mContext == null) throw new RuntimeException("Could not get Context");
        }

        mTimer = new Timer();
        mTimer.schedule(new StatTask(),0,5*1000);
        Log.d(TAG, "mTimer scheduled");
    }
    public class StatTask extends TimerTask{
        ActivityManager.RunningTaskInfo cur;

        public StatTask() {
            Log.d(TAG, "StatTask init");
        }

        /**
         * The task to run should be specified in the implementation of the {@code run()}
         * method.
         */
        @Override
        public void run() {
            Log.d(TAG,"stat calcalating");
            cur = getRunningTaskInfo();
            if(mStats.containsKey(cur)){
                 AppStats v = mStats.get(cur);
                 switch (v.getStatus()){
                     case AppStats.Running:

                         break;
                     case AppStats.Stopped:
                         break;
                     default:
                         break;
                 }
            }
        }
    }
    public class StatBinder extends Binder{
        public StatService getService(){
            if(StatService.this.mContext == null)
                StatService.this.mContext = StatService.this.getApplicationContext();
            startStat();
            return StatService.this;
        }

    }
    public ActivityManager.RunningTaskInfo getRunningTaskInfo(){
        if(AM == null){
            AM = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        }
        ActivityManager.RunningTaskInfo task;
        List<ActivityManager.RunningTaskInfo> tasks;
        tasks = AM.getRunningTasks(1);
        Log.d(TAG, "tasks number"+tasks.size());
        task = tasks.get(0);
        Log.d(TAG, "task is"+task.topActivity);

        return task;
    }
    /**
     * Called by the system to notify a Service that it is no longer used and is being removed.  The
     * service should clean up any resources it holds (threads, registered
     * receivers, etc) at this point.  Upon return, there will be no more calls
     * in to this Service object and it is effectively dead.  Do not call this method directly.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Return the communication channel to the service.  May return null if
     * clients can not bind to the service.  The returned
     * {@link android.os.IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/components/aidl.html">described using
     * aidl</a>.
     * <p/>
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     *
     * @param intent The Intent that was used to bind to this service,
     *               as given to {@link android.content.Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * @return Return an IBinder through which clients can call on to the
     * service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    /**
     * Called when all clients have disconnected from a particular interface
     * published by the service.  The default implementation does nothing and
     * returns false.
     *
     * @param intent The Intent that was used to bind to this service,
     *               as given to {@link android.content.Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * @return Return true if you would like to have the service's
     * {@link #onRebind} method later called when new clients bind to it.
     */
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    ArrayList<String> getProcessList(){
        int pid = android.os.Process.myPid();

        ArrayList<String> list = new ArrayList<String>();
        for(ActivityManager.RunningAppProcessInfo info: AM.getRunningAppProcesses()){
            if(pid != info.pid)
                list.add(info.processName);

        }
        return list;
    }
}
