package com.example.kymanage.presenter.Presenters.WXPage2;


import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.AUFNRBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReq;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.UPAUFNRBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class OutsourceFinishedProductReceivingJSPresenter extends BasePresenter<BaseView2<OutsourceFinishedProductReceivingJSRep>> {


    private final AppModel appModel;

    public OutsourceFinishedProductReceivingJSPresenter() {
        appModel = new AppModel();
    }

    public void OutsourceFinishedProductReceivingJS(OutsourceFinishedProductReceivingJSReq data){
        appModel.OutsourceFinishedProductReceivingJS(data,new HttpDataListener<OutsourceFinishedProductReceivingJSRep>() {


            @Override
            public void onDataSuccess(OutsourceFinishedProductReceivingJSRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
