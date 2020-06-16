package com.example.kymanage.presenter.Presenters.Print2Record2;


import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetDumpRecordPresenter extends BasePresenter<BaseView1<GetDumpRecordRep>> {


    private final AppModel appModel;

    public GetDumpRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetDumpRecord(GetDumpRecordReq data){
        appModel.GetDumpRecord(data,new HttpDataListener<GetDumpRecordRep>() {


            @Override
            public void onDataSuccess(GetDumpRecordRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
