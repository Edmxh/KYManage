package com.example.kymanage.presenter.Presenters.KFPage2;


import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordReqBean;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordRep;
import com.example.kymanage.Beans.InsertDumpTransferRecord.InsertDumpTransferRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class InsertDumpTransferRecordPresenter extends BasePresenter<BaseView1<InsertDumpTransferRecordRep>> {


    private final AppModel appModel;

    public InsertDumpTransferRecordPresenter() {
        appModel = new AppModel();
    }

    public void InsertDumpTransferRecord(InsertDumpTransferRecordReq data){
        appModel.InsertDumpTransferRecord(data, new HttpDataListener<InsertDumpTransferRecordRep>() {

            @Override
            public void onDataSuccess(InsertDumpTransferRecordRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
