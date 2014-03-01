package com.hackathon.wheretime.tests;

import android.test.InstrumentationTestCase;

import com.hackathon.wheretime.model.AppStats;

/**
 * Created by bowman on 14-3-1.
 */
public class AppStatsTest extends InstrumentationTestCase {

    public void testUpdate() throws Exception{

        AppStats appStats = new AppStats("testApp");
        assertEquals("testApp",appStats.getAppName());
        Thread.sleep(2000);
        appStats.update();

        assertTrue(appStats.getTotalTimeToday()-1500 > 0);

    }
    public void testUpdateNStop() throws Exception{
        AppStats appStats = new AppStats("testApp");
        assertEquals("testApp",appStats.getAppName());
        Thread.sleep(2000);
        appStats.updateNstop();

        assertTrue(appStats.getTotalTimeToday()-1500 > 0);
    }
    //todo : more testing requsting
}
