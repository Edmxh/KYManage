package com.example.kymanage.presenter;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdateStorage.UpdateStorageReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class CGSH103ReceivePresenter extends BasePresenter<ReceiveView<StatusRespBean>> {


    private final AppModel appModel;

    public CGSH103ReceivePresenter() {
        appModel = new AppModel();
    }

    public void CGSHReceivedata(List<UpdateStorageReq> data){
        appModel.ReceivingDatas(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
       // System.out.println(444);
    }


}
