package com.hackathon.wheretime.util;

/**
 * Created by wangzhenzhi on 14-3-1.
 */

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.List;

public class CateUtil {
    public static String type;

    public  String getNameBypackage(String packageName){
        String type = "";
        AVQuery<AVObject> query = new AVQuery<AVObject>("Type");
        query.whereEqualTo("packageName", packageName);
        query.findInBackground(new FindCallback<AVObject>() {
            public void done(List<AVObject> avObjects, AVException e) {
                if (e == null) {
                    Log.d("锟缴癸拷", "锟斤拷询锟斤拷" + avObjects.size() + " 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷");
                    CateUtil.type = (String) avObjects.get(0).get("type");
                    System.out.println(avObjects.get(0).get("type"));
                } else {
                    Log.d("失锟斤拷", "锟斤拷询锟斤拷锟斤拷: " + e.getMessage());
                }
            }
        });

        return type;
    }
}
