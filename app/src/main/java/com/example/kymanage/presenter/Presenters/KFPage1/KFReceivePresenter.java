package com.example.kymanage.presenter.Presenters.KFPage1;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class KFReceivePresenter extends BasePresenter<BaseView1<CodeMessageBean>> {


    private final AppModel appModel;

    public KFReceivePresenter() {
        appModel = new AppModel();
    }

    public void WarehouseReceipt(String postingDate,String documentDate,String handler,List<WarehouseReceiptReq> data){
        appModel.WarehouseReceipt(postingDate,documentDate,handler,data, new HttpDataListener<CodeMessageBean>() {

            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
