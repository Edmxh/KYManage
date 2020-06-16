package com.example.kymanage.presenter.Presenters.WXPage3Record;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class WriteOffProStorageRecordPresenter extends BasePresenter<BaseView2<StatusRespBean>> {


    private final AppModel appModel;

    public WriteOffProStorageRecordPresenter() {
        appModel = new AppModel();
    }

    public void WriteOffProStorageRecord(WriteOffProStorageRecordReq data){
        appModel.WriteOffProStorageRecord(data,new HttpDataListener<StatusRespBean>() {


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
