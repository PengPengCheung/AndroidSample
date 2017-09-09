package com.peng.androidsample.sample.widget.recyclerview.usage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.peng.androidsample.R;
import com.peng.androidsample.sample.utils.LogUtil;
import com.peng.androidsample.sample.widget.recyclerview.DefaultStyle;
import com.peng.androidsample.sample.widget.recyclerview.IItemData;
import com.peng.androidsample.sample.widget.recyclerview.UniversalListView;

import java.util.List;


/**
 * Created by peng on 2017/9/9.
 */

public class SampleRecyclerView {

    private static final String TAG = SampleRecyclerView.class.getSimpleName();

    private UniversalListView mRecyclerView;
    private Activity mActivity;
    private View mParentView;

    public SampleRecyclerView(Activity activity) {
        mActivity = activity;

        // Fragment$onCreateView中初始化RecyclerView的写法
//        mParentView = LayoutInflater.from(mActivity).inflate(R.layout.widget_recycler_view, null);
//        mRecyclerView = new UniversalListView(mActivity, mParentView);

        // Activity渲染RecyclerView的写法
//        mRecyclerView = new UniversalListView(mActivity, R.id.swipe_refresh_widget, R.id.recycle_view);

        // 更换控件的另一种写法
        DefaultStyle.sRecycleViewId = R.id.recycle_view;
        mRecyclerView = new UniversalListView(mActivity);
        initRecyclerView();
        enableRefresh();
    }

    public void addRecyclerViewDataList(List<IItemData> list) {
        mRecyclerView.getAdapter().addData(list);
    }

    private void initRecyclerView() {
        if (mRecyclerView == null) {
            return;
        }

        mRecyclerView.setItemViewListener(new UniversalListView.ItemViewListener() {
            @Override
            public RecyclerView.ViewHolder createItemViewHolder(Context context) {
                View view = LayoutInflater.from(context).inflate(R.layout.widget_recycler_view_item, null);
                SampleItemView itemView = new SampleItemView(context, view);
                return itemView;
            }

            @Override
            public void setItemViewContent(RecyclerView.ViewHolder holder, int pos) {
                List<IItemData> dataList = mRecyclerView.getAdapter().getData();
                if (dataList != null && pos < dataList.size()) {
                    ((SampleItemView) holder).setViews(dataList.get(pos));
                }
            }
        });
    }

    private void enableRefresh() {
        mRecyclerView.setRefreshEnabled(true);
        mRecyclerView.setRefreshListener(new UniversalListView.OnUniversalListViewRefreshListener() {
            @Override
            public void refresh() {
                LogUtil.e(TAG, "Show progress or show loading dialog, then request the data.");
            }
        });
    }
}
