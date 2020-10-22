package com.example.kymanage.presenter.Presenters.Print2;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpRep;
import com.example.kymanage.Beans.MaterialFactoryDump.MaterialFactoryDumpReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

public class MaterialExistDumpDataPresenter extends BasePresenter<BaseView3<StatusRespBean>> {


    private final AppModel appModel;

    public MaterialExistDumpDataPresenter() {
        appModel = new AppModel();
    }

    public void MaterialExistDumpData(MaterialFactoryDumpReq data){
        appModel.MaterialExistDumpData(data,new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
