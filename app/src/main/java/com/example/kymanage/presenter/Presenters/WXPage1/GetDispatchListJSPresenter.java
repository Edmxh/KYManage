package com.example.kymanage.presenter.Presenters.WXPage1;


import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetDispatchListJSPresenter extends BasePresenter<PrintBaseView<GetDispatchListJSRep>> {


    private final AppModel appModel;

    public GetDispatchListJSPresenter() {
        appModel = new AppModel();
    }

    public void GetDispatchListJS(List<Long> AdvanceStorageId, String User){
        appModel.GetDispatchListJS(AdvanceStorageId,User,new HttpDataListener<GetDispatchListJSRep>() {


            @Override
            public void onDataSuccess(GetDispatchListJSRep data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
