package com.example.kymanage.presenter.Presenters.mainPage;


import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.UpdateApp.UpdateAppRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class UpdateAppPresenter extends BasePresenter<BaseView1<UpdateAppRep>> {


    private final AppModel appModel;

    public UpdateAppPresenter() {
        appModel = new AppModel();
    }

    public void UpdateApp(String name){
        appModel.UpdateApp(name,new HttpDataListener<UpdateAppRep>() {


            @Override
            public void onDataSuccess(UpdateAppRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
