package com.example.kymanage.presenter.Presenters.WLQueryPage1;


import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRep;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetMaterialStoragePresenter extends BasePresenter<BaseView1<GetMaterialStorageRep>> {


    private final AppModel appModel;

    public GetMaterialStoragePresenter() {
        appModel = new AppModel();
    }

    public void GetMaterialStorage(GetMaterialStorageReq data){
        appModel.GetMaterialStorage(data,new HttpDataListener<GetMaterialStorageRep>() {


            @Override
            public void onDataSuccess(GetMaterialStorageRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
