package com.hackathon.wheretime.model;

import android.content.ComponentName;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by bowman on 14-3-1.
 */
public class AppStats {
    private int mStatus;
    private ArrayList<TimeFragment> mTimeFragments;
    private TimeFragment mCursor;
    private ComponentName mAppName;
    private String mAppString;//������Ԫ����
    public final  static int Running=1;
    public final static int Stopped=0;
    final String TAG = "AppStats";
    private  AppStats(){
        mTimeFragments = new ArrayList<TimeFragment>();
        mStatus = AppStats.Running;
        mCursor = new TimeFragment();
    }
    public AppStats(String mAppString) {
        this();
        this.mAppString = mAppString;

    }

    public AppStats(ComponentName mAppName) {
        this();
        this.mAppName = mAppName;
        mTimeFragments = new ArrayList<TimeFragment>();
        mStatus = AppStats.Running;
    }

    /**
     * ����ʱ��ͳ�Ʋ�ֹͣ��ʱ
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
     * ���µ�ǰӦ��ͳ��ʱ��
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
        return mAppString;
    }

    /**
     * �����µ�TimeFragment,�ڲ�����
     * @param tf
     */
    protected void add(TimeFragment tf) {
        mTimeFragments.add(tf);
    }

    /**
     * ���ظ�App���ܺ�ʱ
     *
     * @return long �ܹ��ĺ���
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
}
