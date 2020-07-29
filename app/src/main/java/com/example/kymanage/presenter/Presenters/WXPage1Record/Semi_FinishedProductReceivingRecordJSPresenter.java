package com.example.kymanage.presenter.Presenters.WXPage1Record;


import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class Semi_FinishedProductReceivingRecordJSPresenter extends BasePresenter<BaseView1<Semi_FinishedProductReceivingRecordJSRep>> {


    private final AppModel appModel;

    public Semi_FinishedProductReceivingRecordJSPresenter() {
        appModel = new AppModel();
    }

    public void Semi_FinishedProductReceivingRecordJS(String documentDate, String user,boolean Checked,String MarketOrderNO,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO,String PurchaseOrderRow){
        appModel.Semi_FinishedProductReceivingRecordJS(documentDate,user,Checked,MarketOrderNO,MarketOrderRow,MaterialCode,PurchaseOrderNO,PurchaseOrderRow,new HttpDataListener<Semi_FinishedProductReceivingRecordJSRep>() {


            @Override
            public void onDataSuccess(Semi_FinishedProductReceivingRecordJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
