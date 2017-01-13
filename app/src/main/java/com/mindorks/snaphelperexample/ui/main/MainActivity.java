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
import com.mindorks.snaphelperexample.ui.main.adapter.AppListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    private MainMvpPresenter<MainMvpView> mMainMvpPresenter;
    private AppListAdapter appListAdapter;

    @BindView(R.id.recyclerView)
    public RecyclerView recyclerView;

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
        appListAdapter.updateList(appList);
    }

    private void setUpRecyclerView() {
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        appListAdapter = new AppListAdapter(this);
        recyclerView.setAdapter(appListAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}
