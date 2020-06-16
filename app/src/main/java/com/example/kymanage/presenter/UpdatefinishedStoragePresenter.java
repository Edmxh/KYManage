package com.example.kymanage.presenter;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdatefinishedStorage.UpdatefinishedStorageData;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class UpdatefinishedStoragePresenter extends BasePresenter<JJreceiveView105<StatusRespBean>> {


    private final AppModel appModel;

    public UpdatefinishedStoragePresenter() {
        appModel = new AppModel();
    }

    public void UpdatefinishedStorage(List<UpdatefinishedStorageData> data){
        appModel.UpdatefinishedStorage(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccessjj105(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
