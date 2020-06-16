package com.example.kymanage.presenter.Presenters.KFPage1;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetPurWayMaterialDataPresenter extends BasePresenter<ScanBaseView<GetPurWayMaterialDataRep>> {


    private final AppModel appModel;

    public GetPurWayMaterialDataPresenter() {
        appModel = new AppModel();
    }

    public void GetPurWayMaterialData(String PurchaseOrderRow,String PurchaseOrderNO,float Qty,String MaterialCode, String Factory){
        appModel.GetPurWayMaterialData(PurchaseOrderRow,PurchaseOrderNO,Qty,MaterialCode,Factory, new HttpDataListener<GetPurWayMaterialDataRep>() {

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
