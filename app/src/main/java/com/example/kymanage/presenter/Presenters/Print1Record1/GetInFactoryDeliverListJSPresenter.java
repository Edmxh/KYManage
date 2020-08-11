package com.example.kymanage.presenter.Presenters.Print1Record1;


import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GetInFactoryDeliverListJSPresenter extends BasePresenter<BaseView1<GetInFactoryDeliverListJSRep>> {


    private final AppModel appModel;

    public GetInFactoryDeliverListJSPresenter() {
        appModel = new AppModel();
    }

    public void GetInFactoryDeliverListJS(String DeliverID,String IssueStorage,String CreateUser,String CreateTime,boolean Checked){
        appModel.GetInFactoryDeliverListJS(DeliverID,IssueStorage,CreateUser,CreateTime,Checked,new HttpDataListener<GetInFactoryDeliverListJSRep>() {


            @Override
            public void onDataSuccess(GetInFactoryDeliverListJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
