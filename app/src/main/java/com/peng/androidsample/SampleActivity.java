package com.peng.androidsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.peng.androidsample.sample.widget.listview.usage.SampleListView;

/**
 * Created by peng on 2017/9/8.
 */

public class SampleActivity extends AppCompatActivity {

    private SampleListView mSampleListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_listview_usage);
        mSampleListView = new SampleListView(this);


    }
}
