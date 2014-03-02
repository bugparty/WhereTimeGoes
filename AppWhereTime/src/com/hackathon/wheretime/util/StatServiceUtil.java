package com.hackathon.wheretime.util;

import android.content.Context;
import android.content.Intent;

import com.hackathon.wheretime.service.StatService;
import com.hackathon.wheretime.service.StatServiceConn;

/**
 * Created by bowman on 14-3-2.
 */
public class StatServiceUtil {
    public static boolean bindStatService(Context context, StatServiceConn mConnection) {
        Intent intent = new Intent(context, StatService.class);
        return context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }
}
