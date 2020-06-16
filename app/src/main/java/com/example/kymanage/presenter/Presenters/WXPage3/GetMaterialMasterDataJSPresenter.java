package com.example.kymanage.presenter.Presenters.WXPage3;


import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetMaterialMasterDataJSPresenter extends BasePresenter<ScanBaseView<GetMaterialMasterDataRep>> {


    private final AppModel appModel;

    public GetMaterialMasterDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetMaterialMasterDataJS(String materialCode,String factory){
        appModel.GetMaterialMasterDataJS(materialCode,factory,new HttpDataListener<GetMaterialMasterDataRep>() {


            @Override
            public void onDataSuccess(GetMaterialMasterDataRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
