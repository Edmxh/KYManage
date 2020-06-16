package com.example.kymanage.presenter.Presenters.Print1;


import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetCMInFactoryDeliverPresenter extends BasePresenter<ScanBaseView<GetCMInFactoryDeliverRep>> {


    private final AppModel appModel;

    public GetCMInFactoryDeliverPresenter() {
        appModel = new AppModel();
    }

    public void GetCMInFactoryDeliver(List<String> DispatchListNO, String user, String requestTime){
        appModel.GetCMInFactoryDeliver(DispatchListNO,user,requestTime,new HttpDataListener<GetCMInFactoryDeliverRep>() {


            @Override
            public void onDataSuccess(GetCMInFactoryDeliverRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
