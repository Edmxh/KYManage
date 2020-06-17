package com.example.kymanage.presenter.Presenters.Print3;


import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSReqBean1;
import com.example.kymanage.Beans.GetLableStorageInfoJS.GetLableStorageInfoJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetDeliveryListInfoJSPresenter extends BasePresenter<BaseView1<GetDeliveryListInfoJSRepBean3>> {


    private final AppModel appModel;

    public GetDeliveryListInfoJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDeliveryListInfoJS(List<GetDeliveryListInfoJSReqBean1> materialArr, int flag, String user, String requestTime){
        appModel.GetDeliveryListInfoJS(materialArr,flag,user,requestTime,new HttpDataListener<GetDeliveryListInfoJSRepBean3>() {


            @Override
            public void onDataSuccess(GetDeliveryListInfoJSRepBean3 data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
