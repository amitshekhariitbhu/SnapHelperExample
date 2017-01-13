package com.mindorks.snaphelperexample.ui.main;

import com.mindorks.snaphelperexample.data.model.App;
import com.mindorks.snaphelperexample.ui.base.MvpView;

import java.util.List;

/**
 * Created by amitshekhar on 13/01/17.
 */

public interface MainMvpView extends MvpView {

    void showApps(List<App> appList);

}
