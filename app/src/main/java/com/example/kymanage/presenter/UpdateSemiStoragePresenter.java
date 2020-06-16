package com.example.kymanage.presenter;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdateSemiStorage.UpdateSemiStorageReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class UpdateSemiStoragePresenter extends BasePresenter<JJreceiveView103<StatusRespBean>> {


    private final AppModel appModel;

    public UpdateSemiStoragePresenter() {
        appModel = new AppModel();
    }

    public void UpdateSemiStorage(List<UpdateSemiStorageReq> data){
        appModel.UpdateSemiStorage(data, new HttpDataListener<StatusRespBean>() {


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
