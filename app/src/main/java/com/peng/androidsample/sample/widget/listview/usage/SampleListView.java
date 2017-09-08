package com.peng.androidsample.sample.widget.listview.usage;

import android.app.Activity;
import android.widget.ListView;

import com.peng.androidsample.R;

/**
 * Created by peng on 2017/9/8.
 */

public class SampleListView {

    private Activity mActivity;
    private ListView mListView;
    private SampleListViewAdapter mListViewAdapter;

    public SampleListView(Activity activity) {
        mActivity = activity;

        initView();
    }

    private void initView() {
        mListView = (ListView) mActivity.findViewById(R.id.listview_widget_listview_usage);
        mListViewAdapter = new SampleListViewAdapter(mActivity);
        mListView.setAdapter(mListViewAdapter);
    }
}
