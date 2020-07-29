package com.example.kymanage.presenter.Presenters.KFPage1;


import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetPurWayMaterialDataRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetMaterialPropertieInfoJSPresenter extends BasePresenter<ScanBaseView<GetPurWayMaterialDataRep>> {


    private final AppModel appModel;

    public GetMaterialPropertieInfoJSPresenter() {
        appModel = new AppModel();
    }

    public void GetMaterialPropertieInfoJS(long AdvanceStorageId){
        appModel.GetMaterialPropertieInfoJS(AdvanceStorageId, new HttpDataListener<GetPurWayMaterialDataRep>() {

            @Override
            public void onDataSuccess(GetPurWayMaterialDataRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
