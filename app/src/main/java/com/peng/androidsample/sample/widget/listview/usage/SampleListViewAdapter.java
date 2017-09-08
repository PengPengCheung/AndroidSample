package com.peng.androidsample.sample.widget.listview.usage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.peng.androidsample.R;
import com.peng.androidsample.sample.widget.listview.IItemViewData;
import com.peng.androidsample.sample.widget.listview.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/9/8.
 */

public class SampleListViewAdapter extends ListViewAdapter {

    private Context mContext;

    private List<IItemViewData> makeMockData() {
        List<IItemViewData> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IItemViewData itemViewData = new SampleItemData();
            ((SampleItemData) itemViewData).setmData("data: " + i);
            dataList.add(itemViewData);
        }

        return dataList;
    }

    public SampleListViewAdapter(Context context) {
        super();
        mContext = context;
    }


    @Override
    public List<IItemViewData> getDataList() {
        return makeMockData();
    }

    @Override
    public View getItemView(List<IItemViewData> dataList, int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.widget_listview_usage_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.img_widget_listview_usage_item);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.tv_widget_listview_usage_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(R.drawable.widget_listview_item_img_1);
        viewHolder.textView.setText(((SampleItemData)dataList.get(position)).getmData());

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}
