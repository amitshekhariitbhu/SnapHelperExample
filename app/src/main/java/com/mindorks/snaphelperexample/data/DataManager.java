package com.mindorks.snaphelperexample.data;

import com.mindorks.snaphelperexample.data.local.DummyDataHelper;
import com.mindorks.snaphelperexample.data.model.App;

import java.util.List;

/**
 * Created by amitshekhar on 13/01/17.
 */

public class DataManager {

    private final DummyDataHelper mDummyDataHelper;

    public DataManager(DummyDataHelper dummyDataHelper) {
        this.mDummyDataHelper = dummyDataHelper;
    }

    public List<App> getAppList() {
        return mDummyDataHelper.getAppList();
    }
}
