package com.example.kymanage.presenter;


import com.example.kymanage.Beans.InsertCMStorageRecevingRecordDetail.InsertCMStorageRecevingRecordDetailReq;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class JJ101ReceivePresenter extends BasePresenter<JJreceiveView103<StatusRespBean>> {


    private final AppModel appModel;

    public JJ101ReceivePresenter() {
        appModel = new AppModel();
    }

    public void InsertCMStorageRecevingRecordDetail(List<InsertCMStorageRecevingRecordDetailReq> data){
        appModel.InsertCMStorageRecevingRecordDetail(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccessjj103(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
