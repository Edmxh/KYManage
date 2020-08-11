package com.example.kymanage.presenter.Presenters.WXPage2Record;


import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetOutsoureFinProductDataJSPresenter extends BasePresenter<BaseView1<GetOutsoureFinProductDataJSRep>> {


    private final AppModel appModel;

    public GetOutsoureFinProductDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutsoureFinProductDataJS(String user, String documentDate,String MarketOrderNO,String MaterialDesc,String PurchaseOrderRow,boolean checked,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO){
        appModel.GetOutsoureFinProductDataJS(user,documentDate,MarketOrderNO,MaterialDesc,PurchaseOrderRow,checked,MarketOrderRow,MaterialCode,PurchaseOrderNO,new HttpDataListener<GetOutsoureFinProductDataJSRep>() {


            @Override
            public void onDataSuccess(GetOutsoureFinProductDataJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
