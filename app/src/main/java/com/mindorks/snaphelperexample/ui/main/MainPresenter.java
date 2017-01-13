package com.mindorks.snaphelperexample.ui.main;

import com.mindorks.snaphelperexample.data.DataManager;
import com.mindorks.snaphelperexample.ui.base.BasePresenter;

/**
 * Created by amitshekhar on 13/01/17.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    final DataManager mDataManager;

    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void getAppList() {
        getMvpView().showApps(mDataManager.getAppList());
    }
}
