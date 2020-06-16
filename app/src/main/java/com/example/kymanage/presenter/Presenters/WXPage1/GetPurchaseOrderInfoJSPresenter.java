package com.example.kymanage.presenter.Presenters.WXPage1;


import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetPurchaseOrderInfoJSPresenter extends BasePresenter<ScanBaseView<GetPurchaseOrderInfoJSReps>> {


    private final AppModel appModel;

    public GetPurchaseOrderInfoJSPresenter() {
        appModel = new AppModel();
    }

    public void GetPurchaseOrderInfoJS(String KDAUF,String KDPOS,String MATAR){
        appModel.GetPurchaseOrderInfoJS(KDAUF,KDPOS,MATAR,new HttpDataListener<GetPurchaseOrderInfoJSReps>() {


            @Override
            public void onDataSuccess(GetPurchaseOrderInfoJSReps data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
