package com.mindorks.snaphelperexample.injection;

import android.content.Context;

import com.mindorks.snaphelperexample.MyApplication;
import com.mindorks.snaphelperexample.data.DataManager;
import com.mindorks.snaphelperexample.ui.base.MvpPresenter;
import com.mindorks.snaphelperexample.ui.base.MvpView;
import com.mindorks.snaphelperexample.ui.main.MainActivity;
import com.mindorks.snaphelperexample.ui.main.MainMvpPresenter;
import com.mindorks.snaphelperexample.ui.main.MainMvpView;
import com.mindorks.snaphelperexample.ui.main.MainPresenter;

/**
 * Created by amitshekhar on 13/01/17.
 */

public abstract class ActivityDependency<P extends MvpPresenter<? extends MvpView>> {

    public static MainActivityDependency inject(MainActivity activity) {
        return new MainActivityDependency(activity);
    }

    public abstract P getMvpPresenter();

    protected DataManager getDataManager(Context context) {
        return MyApplication.get(context.getApplicationContext()).getDataManager();
    }


    public static class MainActivityDependency extends ActivityDependency<MainMvpPresenter<MainMvpView>> {

        private MainMvpPresenter<MainMvpView> mvpPresenter;

        protected MainActivityDependency(MainActivity activity) {
            mvpPresenter = new MainPresenter<>(getDataManager(activity));
        }

        @Override
        public MainMvpPresenter<MainMvpView> getMvpPresenter() {
            return mvpPresenter;
        }
    }

}
