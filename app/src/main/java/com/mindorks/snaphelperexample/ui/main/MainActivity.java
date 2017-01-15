package com.mindorks.snaphelperexample.ui.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.mindorks.snaphelperexample.R;
import com.mindorks.snaphelperexample.data.model.App;
import com.mindorks.snaphelperexample.injection.ActivityDependency;
import com.mindorks.snaphelperexample.ui.base.BaseActivity;
import com.mindorks.snaphelperexample.ui.common.StartSnapHelper;
import com.mindorks.snaphelperexample.ui.main.adapter.AppListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainMvpPresenter<MainMvpView> mMainMvpPresenter;
    private AppListAdapter appListCenterAdapter;
    private AppListAdapter appListStartAdapter;

    @BindView(R.id.centerSnapRecyclerView)
    public RecyclerView centerSnapRecyclerView;

    @BindView(R.id.startSnapRecyclerView)
    public RecyclerView startSnapRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActivityDependency.MainActivityDependency dependency = ActivityDependency.inject(this);
        mMainMvpPresenter = dependency.getMvpPresenter();
        mMainMvpPresenter.attachView(this);
        setUpRecyclerView();
        mMainMvpPresenter.getAppList();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainMvpPresenter.detachView();
    }

    @Override
    public void showApps(List<App> appList) {
        appListCenterAdapter.updateList(appList);
        appListStartAdapter.updateList(appList);
    }

    private void setUpRecyclerView() {

        LinearLayoutManager layoutManagerCenter
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        centerSnapRecyclerView.setLayoutManager(layoutManagerCenter);
        appListCenterAdapter = new AppListAdapter(this);
        centerSnapRecyclerView.setAdapter(appListCenterAdapter);
        SnapHelper snapHelperCenter = new LinearSnapHelper();
        snapHelperCenter.attachToRecyclerView(centerSnapRecyclerView);

        LinearLayoutManager layoutManagerStart
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        startSnapRecyclerView.setLayoutManager(layoutManagerStart);
        appListStartAdapter = new AppListAdapter(this);
        startSnapRecyclerView.setAdapter(appListStartAdapter);
        SnapHelper snapHelperStart = new StartSnapHelper();
        snapHelperStart.attachToRecyclerView(startSnapRecyclerView);

    }
}
