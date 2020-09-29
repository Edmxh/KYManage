package com.example.kymanage.presenter.Print3Record;


import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class GetDeliveryListDataJSPresenter extends BasePresenter<BaseView1<GetDeliveryListDataJSRep>> {


    private final AppModel appModel;

    public GetDeliveryListDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDeliveryListDataJS(String Handler,boolean Check,String Time,String MaterialCode,String MarketOrderNO){
        appModel.GetDeliveryListDataJS( Handler, Check, Time, MaterialCode, MarketOrderNO,new HttpDataListener<GetDeliveryListDataJSRep>() {


            @Override
            public void onDataSuccess(GetDeliveryListDataJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
