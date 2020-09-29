package com.example.kymanage.presenter.Print3Record;


import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class GetDeliveryListDetailDataJSPresenter extends BasePresenter<BaseView1<GetDeliveryListDetailDataJSRep>> {


    private final AppModel appModel;

    public GetDeliveryListDetailDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDeliveryListDetailDataJS(String DeliveryListNO){
        appModel.GetDeliveryListDetailDataJS(DeliveryListNO,new HttpDataListener<GetDeliveryListDetailDataJSRep>() {


            @Override
            public void onDataSuccess(GetDeliveryListDetailDataJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
