package com.example.kymanage.presenter.Presenters.CGPage2;


import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class CGSHRecordPresenter extends BasePresenter<BaseView2<PurchaseCenterRecordReps>> {


    private final AppModel appModel;

    public CGSHRecordPresenter() {
        appModel = new AppModel();
    }

    public void CGSHRecord(String documentDate,String user,String po,String materialCode,boolean checked){
        appModel.PurchaseCenterRecord(documentDate,user,po,materialCode,checked,new HttpDataListener<PurchaseCenterRecordReps>() {


            @Override
            public void onDataSuccess(PurchaseCenterRecordReps data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
