package com.mindorks.snaphelperexample.ui.main;

import android.os.Bundle;

import com.mindorks.snaphelperexample.R;
import com.mindorks.snaphelperexample.data.model.App;
import com.mindorks.snaphelperexample.injection.ActivityDependency;
import com.mindorks.snaphelperexample.ui.base.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainMvpPresenter<MainMvpView> mMainMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityDependency.MainActivityDependency dependency = ActivityDependency.inject(this);
        mMainMvpPresenter = dependency.getMvpPresenter();
        mMainMvpPresenter.attachView(this);
        mMainMvpPresenter.getAppList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainMvpPresenter.detachView();
    }

    @Override
    public void showApps(List<App> appList) {

    }
}
