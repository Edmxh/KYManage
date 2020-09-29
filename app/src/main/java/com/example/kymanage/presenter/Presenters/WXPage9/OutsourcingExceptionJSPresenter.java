package com.example.kymanage.presenter.Presenters.WXPage9;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetOutsourcingExceptionTypeJS.GetOutsourcingExceptionTypeJSRep;
import com.example.kymanage.Beans.OutsourcingExceptionJS.OutsourcingExceptionJSReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class OutsourcingExceptionJSPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public OutsourcingExceptionJSPresenter() {
        appModel = new AppModel();
    }

    public void OutsourcingExceptionJS(OutsourcingExceptionJSReq data){
        appModel.OutsourcingExceptionJS(data,new HttpDataListener<CodeMessageBean>() {


            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
