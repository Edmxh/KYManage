package com.example.kymanage.presenter.Presenters.Print2;


import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeReqBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class GetDumpRecordNodePresenter extends BasePresenter<BaseView2<GetDumpRecordNodeRep>> {


    private final AppModel appModel;

    public GetDumpRecordNodePresenter() {
        appModel = new AppModel();
    }

    public void GetDumpRecordNode(List<GetDumpRecordNodeReqBean> data){
        appModel.GetDumpRecordNode(data,new HttpDataListener<GetDumpRecordNodeRep>() {


            @Override
            public void onDataSuccess(GetDumpRecordNodeRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
