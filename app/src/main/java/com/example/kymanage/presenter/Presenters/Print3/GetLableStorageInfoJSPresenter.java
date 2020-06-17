package com.example.kymanage.presenter.Presenters.Print3;


import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetLableStorageInfoJS.GetLableStorageInfoJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetLableStorageInfoJSPresenter extends BasePresenter<ScanBaseView<GetLableStorageInfoJSRep>> {


    private final AppModel appModel;

    public GetLableStorageInfoJSPresenter() {
        appModel = new AppModel();
    }

    public void GetLableStorageInfoJS(String materialCode,long id, String type, String factory){
        appModel.GetLableStorageInfoJS(materialCode,id,type,factory,new HttpDataListener<GetLableStorageInfoJSRep>() {


            @Override
            public void onDataSuccess(GetLableStorageInfoJSRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
