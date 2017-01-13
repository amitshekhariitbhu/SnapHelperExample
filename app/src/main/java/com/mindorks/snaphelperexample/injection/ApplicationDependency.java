package com.mindorks.snaphelperexample.injection;

import android.app.Application;
import android.content.Context;

import com.mindorks.snaphelperexample.data.DataManager;
import com.mindorks.snaphelperexample.data.local.DummyDataHelper;

/**
 * Created by amitshekhar on 13/01/17.
 */

public class ApplicationDependency {

    private DataManager mDataManager;

    private ApplicationDependency(Context context) {
        DummyDataHelper dummyDataHelper = new DummyDataHelper();
        mDataManager = new DataManager(dummyDataHelper);
    }

    public static ApplicationDependency inject(Application application) {
        return new ApplicationDependency(application);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
