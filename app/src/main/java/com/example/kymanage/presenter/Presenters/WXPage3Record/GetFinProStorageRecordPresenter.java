package com.example.kymanage.presenter.Presenters.WXPage3Record;


import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetFinProStorageRecordPresenter extends BasePresenter<BaseView1<GetFinProStorageRecordReps>> {


    private final AppModel appModel;

    public GetFinProStorageRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetFinProStorageRecord(GetFinProStorageRecordReq data){
        appModel.GetFinProStorageRecord(data,new HttpDataListener<GetFinProStorageRecordReps>() {


            @Override
            public void onDataSuccess(GetFinProStorageRecordReps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
