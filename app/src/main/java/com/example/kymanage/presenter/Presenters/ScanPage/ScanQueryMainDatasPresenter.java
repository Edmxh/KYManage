package com.example.kymanage.presenter.Presenters.ScanPage;


import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class ScanQueryMainDatasPresenter extends BasePresenter<ScanBaseView<GetMaterialMasterDataRep>> {


    private final AppModel appModel;

    public ScanQueryMainDatasPresenter() {
        appModel = new AppModel();
    }

    public void ScanQueryMainDatas(String materialCode,String factory){
//        appModel.GetMaterialMasterData(materialCode,factory,new HttpDataListener<GetMaterialMasterDataRep>() {
//
//
//            @Override
//            public void onDataSuccess(GetMaterialMasterDataRep data) {
//                getView().onDataSuccessScan(data);
//            }
//
//            @Override
//            public void onFailer(String msg) {
//                getView().onFailed(msg);
//            }
//        });
    }


}
