package com.example.kymanage.presenter.Print3Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

import java.util.List;

public class GetDeliveryListJSPresenter extends BasePresenter<PrintBaseView<GetDeliveryListInfoJSRepBean3>> {


    private final AppModel appModel;

    public GetDeliveryListJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDeliveryListJS(String DeliveryListNO){
        appModel.GetDeliveryListJS( DeliveryListNO,new HttpDataListener<GetDeliveryListInfoJSRepBean3>() {


            @Override
            public void onDataSuccess(GetDeliveryListInfoJSRepBean3 data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
