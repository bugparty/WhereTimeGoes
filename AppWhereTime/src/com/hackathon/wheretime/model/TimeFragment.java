package com.hackathon.wheretime.model;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bowman on 14-3-1.
 */
public class TimeFragment {
    long start;
    //����洢
    long during;
    long lastUpdated;

    public TimeFragment() {

        start = Calendar.getInstance().getTimeInMillis();
        lastUpdated = start;
        during = 0;
    }

    /**
     * ����Դ��ϴθ���ʱ���Ӧ��һֱ���У�ֱ�ӵ��ô˺�������ͳ��ʱ��
     *
     * @param
     * @return null
     */
    public void updateDuring2Now() {

        during += (Calendar.getInstance().getTimeInMillis() - lastUpdated);
        lastUpdated = Calendar.getInstance().getTimeInMillis();
    }


    /**
     * ���ָ��ʱ������λ����
     *
     * @param millis long��ʾ�ĺ���ʱ��
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
