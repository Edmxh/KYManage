package com.example.kymanage.presenter.Presenters.Print2Record2;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.Beans.WriteOffMaterialFactoryCDump.WriteOffMaterialFactoryCDumpReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class WriteOffMaterialFactoryCDumpPresenter extends BasePresenter<BaseView2<StatusRespBean>> {


    private final AppModel appModel;

    public WriteOffMaterialFactoryCDumpPresenter() {
        appModel = new AppModel();
    }

    public void WriteOffMaterialFactoryCDump(WriteOffMaterialFactoryCDumpReq data){
        appModel.WriteOffMaterialFactoryCDump(data,new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
