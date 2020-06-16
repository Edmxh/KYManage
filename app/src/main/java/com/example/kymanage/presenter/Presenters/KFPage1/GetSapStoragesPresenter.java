package com.example.kymanage.presenter.Presenters.KFPage1;


import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.GetSapStorageInfoByFactoryJSBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class GetSapStoragesPresenter extends BasePresenter<BaseView2<GetSapStorageInfoByFactoryJSBean>> {


    private final AppModel appModel;

    public GetSapStoragesPresenter() {
        appModel = new AppModel();
    }

    public void GetSapStorages(String factory){
        appModel.GetSapStorageInfoByFactoryJS(factory,new HttpDataListener<GetSapStorageInfoByFactoryJSBean>() {

            @Override
            public void onDataSuccess(GetSapStorageInfoByFactoryJSBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
