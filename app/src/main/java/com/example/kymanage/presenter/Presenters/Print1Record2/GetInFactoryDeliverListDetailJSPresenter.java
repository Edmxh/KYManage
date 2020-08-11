package com.example.kymanage.presenter.Presenters.Print1Record2;


import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetInFactoryDeliverListDetailJSPresenter extends BasePresenter<BaseView1<GetInFactoryDeliverListDetailJSRep>> {


    private final AppModel appModel;

    public GetInFactoryDeliverListDetailJSPresenter() {
        appModel = new AppModel();
    }

    public void GetInFactoryDeliverListDetailJS(String DeliverID){
        appModel.GetInFactoryDeliverListDetailJS(DeliverID,new HttpDataListener<GetInFactoryDeliverListDetailJSRep>() {


            @Override
            public void onDataSuccess(GetInFactoryDeliverListDetailJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
