package com.hackathon.wheretime.tests;

import android.app.Application;
import android.content.Intent;
import android.os.IBinder;
import android.test.ServiceTestCase;

/**
 * Created by bowman on 14-3-1.
 */
public class StatServiceTest extends ServiceTestCase{
    /**
     * Constructor
     *
     * @param serviceClass The type of the service under test.
     */
    public StatServiceTest(Class serviceClass) {
        super(serviceClass);
    }

    /**
     * <p>
     * Starts the service under test, in the same way as if it were started by
     * {@link android.content.Context#bindService(android.content.Intent, ServiceConnection, int)
     * Context.bindService(Intent, ServiceConnection, flags)} with an
     * {@link android.content.Intent} that identifies a service.
     * </p>
     * <p>
     * Notice that the parameters are different. You do not provide a
     * {@link android.content.ServiceConnection} object or the flags parameter. Instead,
     * you only provide the Intent. The method returns an object whose type is a
     * subclass of {@link android.os.IBinder}, or null if the method fails. An IBinder
     * object refers to a communication channel between the application and
     * the service. The flag is assumed to be {@link android.content.Context#BIND_AUTO_CREATE}.
     * </p>
     * <p>
     * See <a href="{@docRoot}guide/components/aidl.html">Designing a Remote Interface
     * Using AIDL</a> for more information about the communication channel object returned
     * by this method.
     * </p>
     * Note:  To be able to use bindService in a test, the service must implement getService()
     * method. An example of this is in the ApiDemos sample application, in the
     * LocalService demo.
     *
     * @param intent An Intent object of the form expected by
     *               {@link android.content.Context#bindService}.
     * @return An object whose type is a subclass of IBinder, for making further calls into
     * the service.
     */
    @Override
    protected IBinder bindService(Intent intent) {
        return super.bindService(intent);
    }

    /**
     * Returns the Application object in use by the service under test.
     *
     * @return The application object.
     * @see #setApplication
     */
    @Override
    public Application getApplication() {
        return super.getApplication();
    }
}
