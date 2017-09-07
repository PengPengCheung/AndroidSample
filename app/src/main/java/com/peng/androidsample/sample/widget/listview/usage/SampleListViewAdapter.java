package com.peng.androidsample.sample.widget.listview.usage;

import android.view.View;
import android.view.ViewGroup;

import com.peng.androidsample.sample.widget.listview.IItemViewData;
import com.peng.androidsample.sample.widget.listview.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/9/8.
 */

public class SampleListViewAdapter extends ListViewAdapter {

    private List<IItemViewData> makeMockData() {
        List<IItemViewData> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            IItemViewData itemViewData = new SampleItemData();
            ((SampleItemData) itemViewData).setmData("data: " + i);
            dataList.add(itemViewData);
        }

        return dataList;
    }


    @Override
    public List<IItemViewData> getDataList() {
        return makeMockData();
    }

    @Override
    public View getItemView(List<IItemViewData> dataList, int position, View convertView, ViewGroup parent) {
        return null;
    }
}
