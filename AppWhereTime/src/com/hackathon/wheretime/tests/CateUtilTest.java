package com.hackathon.wheretime.tests;

import android.test.InstrumentationTestCase;

import com.hackathon.wheretime.util.CateUtil;

/**
 * Created by bowman on 14-3-2.
 */
public class CateUtilTest extends InstrumentationTestCase {
    public void testGetCateByPackage() throws Exception {
        String cate = CateUtil.getCateBypackage("com.tencent.qq");
        assertEquals("娱乐", cate);

    }
}
