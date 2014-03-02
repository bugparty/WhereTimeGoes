package com.hackathon.wheretime.util;

/**
 * Created by wangzhenzhi on 14-3-1.
 */

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;

import java.util.List;

public class CateUtil {


    public static String getCateBypackage(String packageName) {
        List<AVObject> l;
        AVQuery<AVObject> query = new AVQuery<AVObject>("Type");
        query.whereEqualTo("packageName", packageName);
        try {
            l = query.find();
        } catch (AVException e) {
            e.printStackTrace();
            return "其他";
        }
        if (l.size() == 0)
            return "其他";
        return l.get(0).getString("category");
    }
}
