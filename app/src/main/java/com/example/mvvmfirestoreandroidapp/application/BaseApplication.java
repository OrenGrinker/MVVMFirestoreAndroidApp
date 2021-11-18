package com.example.mvvmfirestoreandroidapp.application;

import android.app.Application;
import com.example.mvvmfirestoreandroidapp.BuildConfig;
import timber.log.Timber;

public class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Timber.d("Init Timber for better logging");
        }
    }

}
