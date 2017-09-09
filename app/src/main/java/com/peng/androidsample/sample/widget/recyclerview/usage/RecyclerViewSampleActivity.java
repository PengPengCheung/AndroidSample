package com.peng.androidsample.sample.widget.recyclerview.usage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.peng.androidsample.R;
import com.peng.androidsample.sample.widget.recyclerview.IItemData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by peng on 2017/9/9.
 */

public class RecyclerViewSampleActivity extends AppCompatActivity {

    private static final String TAG = RecyclerViewSampleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_recycler_view);
        SampleRecyclerView recyclerView = new SampleRecyclerView(this);
        recyclerView.addRecyclerViewDataList(makeMockData());
    }

    private List<IItemData> makeMockData() {
        List<IItemData> dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            SampleItemData itemData = new SampleItemData();
            itemData.imgRes = R.drawable.widget_listview_item_img_1;
            itemData.textStr = "recycler view data: " + i;
            dataList.add(itemData);
        }

        return dataList;
    }
}
