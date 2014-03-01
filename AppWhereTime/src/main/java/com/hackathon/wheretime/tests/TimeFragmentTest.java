package com.hackathon.wheretime.tests;

import android.test.InstrumentationTestCase;

import com.hackathon.wheretime.model.TimeFragment;

import java.util.Date;

/**
 * Created by bowman on 14-3-1.
 * ����ģ�͵ĵ�Ԫ���ԣ���Ҳ���Դ�����ѧ����Щ����÷�
 */
public class TimeFragmentTest extends InstrumentationTestCase {
    public void testTimeFragment() throws Exception {
        TimeFragment tf1 = new TimeFragment();
        tf1.updateDuring2Now();
        tf1.updateDuring2Now();
        tf1.updateDuring2Now();
        tf1.updateDuring2Now();
        Date start = tf1.getStart();
        assertNotNull(start);
        System.out.println(start);
        long during = tf1.getDuring();
        assertNotNull(during);
        System.out.println(during);


    }

}
