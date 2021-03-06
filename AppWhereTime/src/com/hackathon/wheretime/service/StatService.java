package com.hackathon.wheretime.service;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.hackathon.wheretime.model.AppStats;
import com.hackathon.wheretime.util.CompareUtil;

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
    private ActivityManager AM;
    private Timer mTimer;
    private Context mContext;
    private NotificationManager mNM;
    public StatService() {
        super();
        Log.d(TAG, "onInit");
    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        startStat();
    }

    public void startStat(){
        if(mContext == null){
            mContext = getApplicationContext();
            if(mContext == null) throw new RuntimeException("Could not get Context");
        }

        mTimer = new Timer();
        mTimer.schedule(mStatTask,0,5*1000);
        Log.d(TAG, "mTimer scheduled");
    }
    public class StatTask extends TimerTask{
        private HashMap<ActivityManager.RunningTaskInfo,AppStats> mStats;
        ActivityManager.RunningTaskInfo cur,prev;
        final static int APP_CHANGED=0;
        final static int APP_NOTCHANING=1;
        final static int APP_NULL=2;
        int mTasksState = APP_NULL;
        //flag whether the service ha
        private boolean firstBoot = true;
        public StatTask() {
            mStats = new HashMap<ActivityManager.RunningTaskInfo, AppStats>();
            Log.d(TAG, "StatTask init");
        }
        private void updateNStopKV(ActivityManager.RunningTaskInfo runningTaskInfo){
            AppStats app;
            for(ActivityManager.RunningTaskInfo info: mStats.keySet()){
                if(CompareUtil.isSamePackage(runningTaskInfo, info)){
                    app = mStats.get(info);
                    app.updateNstop();
                }
            }

        }
        private void updateKV(ActivityManager.RunningTaskInfo runningTaskInfo){
            AppStats app;
            for(ActivityManager.RunningTaskInfo info: mStats.keySet()){
                if(CompareUtil.isSamePackage(runningTaskInfo, info)){
                    app = mStats.get(info);
                    app.update();
                }
            }



        }
        public HashMap<ActivityManager.RunningTaskInfo,AppStats> getStats(){
            return mStats;
        }
        /**
         * The task to run should be specified in the implementation of the {@code run()}
         * method.
         */
        @Override
        public void run() {
            Log.d(TAG,"stat calcalating");
            if(firstBoot){
                firstBoot = false;
                prev = getRunningTaskInfo();
                return;
            }
            cur = getRunningTaskInfo();
            if(cur == null){
                mTasksState = APP_NULL;
                Log.d(TAG, "APP_NULL STATE");
            }else if(CompareUtil.isSamePackage(cur,prev)){
                mTasksState = APP_NOTCHANING;
                Log.d(TAG, "APP_NOTCHANG STATE");
            }else{
                Log.i(TAG, "cur: "+cur.baseActivity.getPackageName());
                Log.i(TAG, "prev: "+prev.baseActivity);
                mTasksState = APP_CHANGED;
                Log.d(TAG, "APP_CHANGED STATE");
            }
            switch (mTasksState){
                case APP_NULL:
                    if(cur!=null){
                        updateNStopKV(cur);
                        cur = null;
                    }
                    //nothing
                    break;
                case APP_NOTCHANING:
                    if(cur != null)
                        updateNStopKV(cur);
                    break;
                case APP_CHANGED:
                    updateNStopKV(prev);
                    updateNStopKV(cur);
                    prev = cur;

                    break;
                default:
                    Log.e(TAG, "unexpactable value");
                    throw new IllegalArgumentException();
            }

        }
    }
    private StatTask mStatTask = new StatTask();

    public HashMap<ActivityManager.RunningTaskInfo, AppStats> getStats() {
        return mStatTask.getStats();
    }

    private final  IStatService.Stub mBinder = new IStatService.Stub() {
        @Override
        public long getTodayStats(String category) throws RemoteException {
            long time = 0;
            HashMap<ActivityManager.RunningTaskInfo, AppStats> map = StatService.this.getStats();
            for (AppStats task : map.values()) {
                if (task.getCategory().equals(category))
                    time += task.getTotalTimeToday();
            }
            return time;
        }

        /**
         * 获取当前在屏幕上的进程
         *
         * @return 获取当前正在运行的app包名，没有则返回null
         * @throws RemoteException
         */
        @Override
        public String getCurrentRuningApp() throws RemoteException {
            ActivityManager.RunningTaskInfo info = StatService.this.getRunningTaskInfo();
            if (info == null)
                return null;
            return info.baseActivity.getPackageName();
        }
    };
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
        mTimer.cancel();
        Log.d(TAG, "mTimer has been stop");
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
