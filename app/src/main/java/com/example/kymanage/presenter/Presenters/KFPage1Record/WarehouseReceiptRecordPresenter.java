package com.example.kymanage.presenter.Presenters.KFPage1Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class WarehouseReceiptRecordPresenter extends BasePresenter<BaseView1<WarehouseReceiptRecordReps>> {


    private final AppModel appModel;

    public WarehouseReceiptRecordPresenter() {
        appModel = new AppModel();
    }

    public void WarehouseReceiptRecord(String DocumentDate,String user){
        appModel.WarehouseReceiptRecord(DocumentDate,user, new HttpDataListener<WarehouseReceiptRecordReps>() {

            @Override
            public void onDataSuccess(WarehouseReceiptRecordReps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
