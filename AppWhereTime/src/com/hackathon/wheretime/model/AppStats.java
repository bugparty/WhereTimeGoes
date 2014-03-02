package com.hackathon.wheretime.model;

import android.content.ComponentName;
import android.util.Log;

import com.hackathon.wheretime.util.CateUtil;

import java.util.ArrayList;

/**
 * Created by bowman on 14-3-1.
 */
public class AppStats {
    private int mStatus;
    private String category;
    private ArrayList<TimeFragment> mTimeFragments;
    private TimeFragment mCursor;
    private ComponentName mAppName;
    private String mPackageName;
    public final  static int Running=1;
    public final static int Stopped=0;
    final String TAG = "AppStats";
    private  AppStats(){
        mTimeFragments = new ArrayList<TimeFragment>();
        mStatus = AppStats.Running;
        mCursor = new TimeFragment();
    }

    public AppStats(String mPackageName) {
        this();
        this.mPackageName = mPackageName;
        this.category = CateUtil.getCateBypackage(mPackageName);

    }

    public AppStats(ComponentName mAppName) {
        this();
        this.mAppName = mAppName;
        this.mPackageName = mAppName.getPackageName();
        this.category = CateUtil.getCateBypackage(mPackageName);
        mTimeFragments = new ArrayList<TimeFragment>();
        mStatus = AppStats.Running;
    }

    /**
     * 更新时间统计并停止计时
     */
    public void updateNstop(){
        if(mStatus == AppStats.Running){
            mCursor.updateDuring2Now();
            mTimeFragments.add(mCursor);
            mCursor = null;
            mStatus = AppStats.Stopped;

        }else{
            Log.e(TAG,"already stoped" );
        }
    }

    /**
     * 更新当前应用统计时间
     */
    public void update(){
        if(mStatus == AppStats.Running){
            mCursor.updateDuring2Now();

        }else{
            mCursor.updateDuring2Now();
            mTimeFragments.add(mCursor);
            mCursor = new TimeFragment();
            mStatus = AppStats.Running;
        }
    }

    public String getAppName() {
        if (mAppName != null) {
            return mAppName.getClassName();
        }
        return mPackageName;
    }

    /**
     * 加入新的TimeFragment,内部函数
     * @param tf
     */
    protected void add(TimeFragment tf) {
        mTimeFragments.add(tf);
    }

    /**
     * 返回该App的总耗时
     *
     * @return long 总共的毫秒
     */
    public long getTotalTimeToday() {
        long total = 0;
        for (TimeFragment tf : mTimeFragments) {
            total += tf.getDuring();
        }
        if(mCursor!=null)
            total += mCursor.getDuring();
        return total;
    }

    public int getStatus() {
        return mStatus;
    }

    private void setStatue(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getCategory() {
        return category;
    }
}
