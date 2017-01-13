package com.mindorks.snaphelperexample;

import android.app.Application;
import android.content.Context;

import com.mindorks.snaphelperexample.data.DataManager;
import com.mindorks.snaphelperexample.injection.ApplicationDependency;

/**
 * Created by amitshekhar on 13/01/17.
 */

public class MyApplication extends Application {

    private ApplicationDependency applicationDependency;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationDependency = ApplicationDependency.inject(this);
    }

    public DataManager getDataManager() {
        return applicationDependency.getDataManager();
    }
}
