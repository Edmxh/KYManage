package com.example.kymanage.presenter.Presenters.WXPage1;


import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class Semi_FinishedProductReceivingPresenter extends BasePresenter<BaseView2<Semi_FinishedProductReceivingRep>> {


    private final AppModel appModel;

    public Semi_FinishedProductReceivingPresenter() {
        appModel = new AppModel();
    }

    public void Semi_FinishedProductReceiving(Semi_FinishedProductReceivingReq datas){
        appModel.Semi_FinishedProductReceiving(datas,new HttpDataListener<Semi_FinishedProductReceivingRep>() {


            @Override
            public void onDataSuccess(Semi_FinishedProductReceivingRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
