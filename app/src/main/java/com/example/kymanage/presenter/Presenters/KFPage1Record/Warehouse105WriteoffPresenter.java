package com.example.kymanage.presenter.Presenters.KFPage1Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.Warehouse105Writeoff.Warehouse105WriteoffReq;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class Warehouse105WriteoffPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public Warehouse105WriteoffPresenter() {
        appModel = new AppModel();
    }

    public void WarehouseReceiptRecord(List<Warehouse105WriteoffReq> data,String documentData){
        appModel.Warehouse105Writeoff(data,documentData, new HttpDataListener<CodeMessageBean>() {

            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
