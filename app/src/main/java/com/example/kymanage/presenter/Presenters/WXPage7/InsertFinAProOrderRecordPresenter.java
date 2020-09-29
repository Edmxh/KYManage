package com.example.kymanage.presenter.Presenters.WXPage7;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordReq;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

public class InsertFinAProOrderRecordPresenter extends BasePresenter<PrintBaseView<InsertFinAProOrderRecordRep>> {


    private final AppModel appModel;

    public InsertFinAProOrderRecordPresenter() {
        appModel = new AppModel();
    }

    public void InsertFinAProOrderRecord(InsertFinAProOrderRecordReq data){
        appModel.InsertFinAProOrderRecord(data,new HttpDataListener<InsertFinAProOrderRecordRep>() {


            @Override
            public void onDataSuccess(InsertFinAProOrderRecordRep data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
