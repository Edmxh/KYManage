package com.example.kymanage.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.example.kymanage.Activity.BaseActivity;


/*Time:
 *Author:
 *Description:
 */public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetEvevt evevt = BaseActivity.evevt;

    @Override
    public void onReceive(Context context, Intent intent) {
// 如果相等的话就说明网络状态发生了变化
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            int netWorkState = NetUtil.getNetWorkState(context);
            // 接口回调传过去状态的类型
            evevt.onNetChange(netWorkState);
        }

    }

    // 自定义接口
    public interface NetEvevt {
        void onNetChange(int netMobile);
    }
}
