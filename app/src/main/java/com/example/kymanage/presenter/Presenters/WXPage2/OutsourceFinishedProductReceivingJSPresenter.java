package com.example.kymanage.presenter.Presenters.WXPage2;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSRep;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean2;
import com.example.kymanage.Beans.OutsourceFinishedProductReceivingJS.OutsourceFinishedProductReceivingJSReqBean3;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceiving.Semi_FinishedProductReceivingReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class OutsourceFinishedProductReceivingJSPresenter extends BasePresenter<BaseView2<OutsourceFinishedProductReceivingJSRep>> {


    private final AppModel appModel;

    public OutsourceFinishedProductReceivingJSPresenter() {
        appModel = new AppModel();
    }

    public void OutsourceFinishedProductReceivingJS(String postingDate, String documentDate, String user, OutsourceFinishedProductReceivingJSReqBean3 detail){
        appModel.OutsourceFinishedProductReceivingJS(postingDate,documentDate,user,detail,new HttpDataListener<OutsourceFinishedProductReceivingJSRep>() {


            @Override
            public void onDataSuccess(OutsourceFinishedProductReceivingJSRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
