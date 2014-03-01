package com.example.systemprocess.util;

import android.app.ActivityManager;

/**
 * Created by bowman on 14-3-1.
 */
public  class CompareUtil {
    public final static boolean isSamePackage(ActivityManager.RunningTaskInfo left, ActivityManager.RunningTaskInfo right){
        if(left.baseActivity.getPackageName().equals(right.topActivity.getPackageName()))
            return true;
        return false;
    }
}
