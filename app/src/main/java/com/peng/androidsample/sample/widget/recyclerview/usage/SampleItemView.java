package com.peng.androidsample.sample.widget.recyclerview.usage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.peng.androidsample.R;
import com.peng.androidsample.sample.utils.LogUtil;
import com.peng.androidsample.sample.widget.recyclerview.IItemData;
import com.peng.androidsample.sample.widget.recyclerview.ItemViewHolder;

/**
 * Created by peng on 2017/9/9.
 */

public class SampleItemView extends ItemViewHolder {

    private static final String TAG = SampleItemView.class.getSimpleName();

    private Context mContext;
    private ImageView mRecyclerViewImageView;
    private TextView mRecyclerViewTextView;

    public SampleItemView(Context context, View itemView) {
        super(itemView);
        mContext = context;
    }

    @Override
    public void findViews(View itemView) {
        mRecyclerViewImageView = (ImageView) itemView.findViewById(R.id.img_widget_recyclerview_usage_item);
        mRecyclerViewTextView = (TextView) itemView.findViewById(R.id.tv_widget_recyclerview_usage_item);
    }

    @Override
    public void setViews(IItemData itemData) {
        if (itemData == null) {
            return;
        }
        SampleItemData data = (SampleItemData) itemData;

        mRecyclerViewImageView.setImageResource(data.imgRes);
        mRecyclerViewTextView.setText(data.textStr);

        otherOperationOnViews();
    }

    private void otherOperationOnViews() {
        LogUtil.e(TAG, "这里可以对相关控件设置监听器，或者对view做一些特殊操作等");
    }
}
