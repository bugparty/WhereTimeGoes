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
                    Log.d("�ɹ�", "��ѯ��" + avObjects.size() + " ����������������");
                    CateUtil.type = (String) avObjects.get(0).get("type");
                    System.out.println(avObjects.get(0).get("type"));
                } else {
                    Log.d("ʧ��", "��ѯ����: " + e.getMessage());
                }
            }
        });

        return type;
    }
}
