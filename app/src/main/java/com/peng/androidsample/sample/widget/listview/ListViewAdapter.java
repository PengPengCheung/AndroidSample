package com.peng.androidsample.sample.widget.listview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/9/8.
 */

public abstract class ListViewAdapter extends BaseAdapter {

    private static final String TAG = ListViewAdapter.class.getSimpleName();

    private List<IItemViewData> mItemViewDataList;


    public ListViewAdapter() {
        super();
        mItemViewDataList = getDataList();
        if (mItemViewDataList == null) {
            Log.e(TAG, "ListViewAdapter Constructor: DataList is null");
            mItemViewDataList = new ArrayList<>();
        }
    }

    public abstract List<IItemViewData> getDataList();

    public abstract View getItemView(List<IItemViewData> dataList, int position, View convertView, ViewGroup parent);

    @Override
    public int getCount() {
        return mItemViewDataList.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= mItemViewDataList.size()) {
            Log.e(TAG, "DataList getItem null");
            return new Object();
        }
        return mItemViewDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(mItemViewDataList, position, convertView, parent);
    }
}
