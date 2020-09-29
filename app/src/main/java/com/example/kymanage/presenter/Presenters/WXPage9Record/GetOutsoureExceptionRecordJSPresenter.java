package com.example.kymanage.presenter.Presenters.WXPage9Record;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetOutsoureExceptionRecordJS.GetOutsoureExceptionRecordJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GetOutsoureExceptionRecordJSPresenter extends BasePresenter<BaseView1<GetOutsoureExceptionRecordJSRep>> {


    private final AppModel appModel;

    public GetOutsoureExceptionRecordJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutsoureExceptionRecordJS(String user,String documentDate,String MarketOrderNO,String MaterialDesc,String PurchaseOrderRow,boolean checked,String MarketOrderRow,String MaterialCode,String PurchaseOrderNO){
        appModel.GetOutsoureExceptionRecordJS(user,documentDate,MarketOrderNO,MaterialDesc,PurchaseOrderRow,checked,MarketOrderRow,MaterialCode,PurchaseOrderNO, new HttpDataListener<GetOutsoureExceptionRecordJSRep>() {


            @Override
            public void onDataSuccess(GetOutsoureExceptionRecordJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
