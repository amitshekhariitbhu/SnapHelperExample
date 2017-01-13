package com.mindorks.snaphelperexample.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mindorks.snaphelperexample.data.model.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitshekhar on 14/01/17.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {

    private List<App> appList;
    private Context context;

    public AppListAdapter(Context context) {
        this.context = context;
        appList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
