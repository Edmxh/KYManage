package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kymanage.R;
import com.jensdriller.libs.multistatelistview.MultiStateListView;

public class TestActivity extends BaseActivity {

    private MultiStateListView listview1;

    @Override
    public int initLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void initview() {
        listview1=findViewById(R.id.listview1);
        listview1.showLoadingView();
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLisenter() {

    }
}
