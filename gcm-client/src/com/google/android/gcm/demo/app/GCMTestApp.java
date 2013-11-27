package com.google.android.gcm.demo.app;

import com.google.android.gcm.demo.app.networking.RequestManager;

import android.app.Application;

/**
 *
 * @author Lucas Nobile
 */
public class GCMTestApp extends Application {

    // Handle requests
    public static RequestManager REQUEST_MANAGER;

    @Override
    public void onCreate() {
        super.onCreate();

        REQUEST_MANAGER = new RequestManager(this);
    }
}
