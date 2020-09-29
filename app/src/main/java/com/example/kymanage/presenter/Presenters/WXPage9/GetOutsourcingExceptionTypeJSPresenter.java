package com.example.kymanage.presenter.Presenters.WXPage9;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GetOutsourcingExceptionTypeJSPresenter extends BasePresenter<BaseView1<GetOutsourcingExceptionTypeJSRep>> {


    private final AppModel appModel;

    public GetOutsourcingExceptionTypeJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutsourcingExceptionTypeJS(){
        appModel.GetOutsourcingExceptionTypeJS( new HttpDataListener<GetOutsourcingExceptionTypeJSRep>() {


            @Override
            public void onDataSuccess(GetOutsourcingExceptionTypeJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
