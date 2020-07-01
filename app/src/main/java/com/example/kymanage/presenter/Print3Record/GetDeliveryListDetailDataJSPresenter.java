package com.example.kymanage.presenter.Print3Record;


import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSReqBean1;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class GetDeliveryListDetailDataJSPresenter extends BasePresenter<BaseView2<GetDeliveryListDetailDataJSRep>> {


    private final AppModel appModel;

    public GetDeliveryListDetailDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDeliveryListDetailDataJS(String Time,String Handler,String Code){
        appModel.GetDeliveryListDetailDataJS(Time,Handler,Code,new HttpDataListener<GetDeliveryListDetailDataJSRep>() {


            @Override
            public void onDataSuccess(GetDeliveryListDetailDataJSRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
