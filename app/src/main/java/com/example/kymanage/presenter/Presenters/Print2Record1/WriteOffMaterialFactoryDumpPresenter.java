package com.example.kymanage.presenter.Presenters.Print2Record1;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeReqBean;
import com.example.kymanage.Beans.WriteOffMaterialFactoryDump.WriteOffMaterialFactoryDumpReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class WriteOffMaterialFactoryDumpPresenter extends BasePresenter<BaseView3<StatusRespBean>> {


    private final AppModel appModel;

    public WriteOffMaterialFactoryDumpPresenter() {
        appModel = new AppModel();
    }

    public void WriteOffMaterialFactoryDump(List<WriteOffMaterialFactoryDumpReqBean> data){
        appModel.WriteOffMaterialFactoryDump(data,new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
