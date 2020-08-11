package com.example.kymanage.presenter.Presenters.Print1;


import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class GetCMInFactoryDeliverJSPresenter extends BasePresenter<BaseView2<GetCMInFactoryDeliverJSRep>> {


    private final AppModel appModel;

    public GetCMInFactoryDeliverJSPresenter() {
        appModel = new AppModel();
    }

    public void GetCMInFactoryDeliverJS(List<String> deliverNO){
        appModel.GetCMInFactoryDeliverJS(deliverNO,new HttpDataListener<GetCMInFactoryDeliverJSRep>() {


            @Override
            public void onDataSuccess(GetCMInFactoryDeliverJSRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
