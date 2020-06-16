package com.example.kymanage.presenter.Presenters.Print2;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class MaterialFactoryDumpPresenter extends BasePresenter<BaseView1<MaterialFactoryDumpRep>> {


    private final AppModel appModel;

    public MaterialFactoryDumpPresenter() {
        appModel = new AppModel();
    }

    public void MaterialFactoryDump(MaterialFactoryDumpReq data){
        appModel.MaterialFactoryDump(data,new HttpDataListener<MaterialFactoryDumpRep>() {


            @Override
            public void onDataSuccess(MaterialFactoryDumpRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
