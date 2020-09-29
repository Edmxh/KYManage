package com.example.kymanage.presenter.Presenters.WXPage6Record;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRep;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GetDistributorDumpRecordDataPresenter extends BasePresenter<BaseView1<GetDistributorDumpRecordDataRep>> {


    private final AppModel appModel;

    public GetDistributorDumpRecordDataPresenter() {
        appModel = new AppModel();
    }

    public void GetDistributorDumpRecordData(GetDistributorDumpRecordDataReqBean data){
        appModel.GetDistributorDumpRecordData(data, new HttpDataListener<GetDistributorDumpRecordDataRep>() {


            @Override
            public void onDataSuccess(GetDistributorDumpRecordDataRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
