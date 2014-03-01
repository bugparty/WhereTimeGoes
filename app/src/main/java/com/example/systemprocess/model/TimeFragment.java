package com.example.systemprocess.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bowman on 14-3-1.
 */
public class TimeFragment {
    long start;
    //毫秒存储
    long during;
    long lastUpdated;

    public TimeFragment() {

        start = Calendar.getInstance().getTimeInMillis();
        lastUpdated = start;
        during = 0;
    }

    /**
     * 如果自从上次更新时间后应用一直运行，直接调用此函数更新统计时间
     *
     * @param
     * @return null
     */
    public void updateDuring2Now() {

        during += (Calendar.getInstance().getTimeInMillis() - lastUpdated);
        lastUpdated = Calendar.getInstance().getTimeInMillis();
    }


    /**
     * 添加指定时长，单位毫秒
     *
     * @param millis long表示的毫秒时长
     */
    public void addDuring(long millis) {
        during += millis;
    }

    public Date getStart() {
        Date d = new Date();
        d.setTime(start);
        return d;
    }

    public long getDuring() {
        return during;
    }

}
