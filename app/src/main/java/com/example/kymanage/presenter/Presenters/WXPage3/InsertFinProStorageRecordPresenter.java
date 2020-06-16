package com.example.kymanage.presenter.Presenters.WXPage3;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordRep;
import com.example.kymanage.Beans.InsertFinProStorageRecord.InsertFinProStorageRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class InsertFinProStorageRecordPresenter extends BasePresenter<BaseView2<InsertFinProStorageRecordRep>> {


    private final AppModel appModel;

    public InsertFinProStorageRecordPresenter() {
        appModel = new AppModel();
    }

    public void InsertFinProStorageRecord(InsertFinProStorageRecordReq data){
        appModel.InsertFinProStorageRecord(data, new HttpDataListener<InsertFinProStorageRecordRep>() {


            @Override
            public void onDataSuccess(InsertFinProStorageRecordRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
