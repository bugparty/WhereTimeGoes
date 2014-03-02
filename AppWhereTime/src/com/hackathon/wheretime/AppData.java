package com.hackathon.wheretime;


import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.avos.avoscloud.AVACL;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.hackathon.wheretime.util.CateUtil;

public class AppData extends Application {
    public static final int DAILY = 0;

    public static final int WEEKLY = 1;

    private static Context context;
    public final String TAG = "WhereTimeApplication";

    public enum Span {
        DAILY, WEEKLY
    }

    public static Span selectedSpan = Span.DAILY;


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        context = getApplicationContext();
        // Your application id and Application Key
        AVOSCloud.initialize(this, "an9azodiifaz755e0qkvf3hw017r65cnqla5ft9jzf60w7ae", "p48dn3fmrpy6cwo9adg03ee4srur1ce3y66nu1qjz30ua1lq");
        AVOSCloud.useAVCloudCN();
        AVUser.enableAutomaticUser();
        AVACL defaultACL = new AVACL();
        defaultACL.setPublicWriteAccess(true);
        defaultACL.setPublicReadAccess(true);
        AVACL.setDefaultACL(defaultACL, true);
        Log.d(TAG, "查询到" + new CateUtil().getCateBypackage("com.baidu.com") + " 条符合条件的数据");
    }

    public static Context getContext() {
        return context;
    }


}
