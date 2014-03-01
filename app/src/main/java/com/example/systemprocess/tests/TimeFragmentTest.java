package com.example.systemprocess.tests;

import android.test.InstrumentationTestCase;

import com.example.systemprocess.model.AppStats;
import com.example.systemprocess.model.TimeFragment;

import java.util.Date;

/**
 * Created by bowman on 14-3-1.
 * 数据模型的单元测试，你也可以从这里学到这些类的用法
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
