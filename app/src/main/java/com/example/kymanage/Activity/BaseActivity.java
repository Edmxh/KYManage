package com.example.kymanage.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kymanage.net.NetBroadcastReceiver;
import com.example.kymanage.net.NetUtil;
import com.facebook.drawee.backends.pipeline.Fresco;

public abstract class BaseActivity extends AppCompatActivity implements NetBroadcastReceiver.NetEvevt {
    private static String TAG = "Baseactivity";
    public static NetBroadcastReceiver.NetEvevt evevt;
    private int netMobile;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化Fresco
        Fresco.initialize(getBaseContext());
        TAG = getClass().getSimpleName();//打印
        int i = initLayoutId();//布局
        if (i != 0) {
            setContentView(i);
            evevt = this;
            inspectNet();
            initview();
            initLisenter();
            initData();
            initVariable();
        } else {
            setContentView(null);
        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 禁用横屏
    }

    public abstract int initLayoutId();//布局

    public abstract void initview();//控件

    public abstract void initData();//数据

    public abstract void initLisenter();//监听事件

    public void initVariable() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean inspectNet() {
        this.netMobile = NetUtil.getNetWorkState(BaseActivity.this);
        return isNetConnect();
    }


    @Override
    public void onNetChange(int netMobile) {
        // TODO Auto-generated method stub
        this.netMobile = netMobile;
        isNetConnect();
    }

    /**
     * 判断有无网络 。
     *
     * @return true 有网, false 没有网络.
     */
    public boolean isNetConnect() {
        if (netMobile == 1) {
            return true;
        } else if (netMobile == 0) {
            return true;
        } else if (netMobile == -1) {
            return false;
        }
        return false;
    }


}
