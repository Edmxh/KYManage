package com.example.kymanage.presenter;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.warehousereceipts.warehousereceiptsReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class KF301ReceivePresenter extends BasePresenter<KFReceiveView<StatusRespBean>> {


    private final AppModel appModel;

    public KF301ReceivePresenter() {
        appModel = new AppModel();
    }

    public void WarehouseReceipts(List<warehousereceiptsReq> data){
        appModel.WarehouseReceipts(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccesskf(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
