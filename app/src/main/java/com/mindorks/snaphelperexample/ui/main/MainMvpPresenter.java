package com.mindorks.snaphelperexample.ui.main;

import com.mindorks.snaphelperexample.ui.base.MvpPresenter;

/**
 * Created by amitshekhar on 13/01/17.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void getAppList();

}
