package com.example.kymanage.presenter.Presenters.CGPage3;


import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRep;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRepBean;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103RepStatus;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103ReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetPreRecMaterialCodeInfoJSPresenter extends BasePresenter<ScanBaseView<GetPreRecMaterialCodeInfoJSRep>> {


    private final AppModel appModel;

    public GetPreRecMaterialCodeInfoJSPresenter() {
        appModel = new AppModel();
    }

    public void GetPreRecMaterialCodeInfoJS(long AdvanceStorageId){
        appModel.GetPreRecMaterialCodeInfoJS(AdvanceStorageId,new HttpDataListener<GetPreRecMaterialCodeInfoJSRep>() {


            @Override
            public void onDataSuccess(GetPreRecMaterialCodeInfoJSRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
