package com.example.kymanage.presenter.Presenters.Print2Record1;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetMainDumpRecordPresenter extends BasePresenter<BaseView1<GetMainDumpRecordRep>> {


    private final AppModel appModel;

    public GetMainDumpRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetMainDumpRecord(GetMainDumpRecordReq data){
        appModel.GetMainDumpRecord(data,new HttpDataListener<GetMainDumpRecordRep>() {


            @Override
            public void onDataSuccess(GetMainDumpRecordRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
