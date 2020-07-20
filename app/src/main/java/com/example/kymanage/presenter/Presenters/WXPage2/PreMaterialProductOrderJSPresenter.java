package com.example.kymanage.presenter.Presenters.WXPage2;


import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.Beans.PreMaterialProductOrderJS.PreMaterialProductOrderJSReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;

import java.util.List;

public class PreMaterialProductOrderJSPresenter extends BasePresenter<BaseView4<PreMaterialProductOrderReps>> {


    private final AppModel appModel;

    public PreMaterialProductOrderJSPresenter() {
        appModel = new AppModel();
    }

    public void PreMaterialProductOrderJS(String marketOrderNO, String marketOrderRow, List<PreMaterialProductOrderJSReqBean> materialCodeArr, String factoryNO){
        appModel.PreMaterialProductOrderJS(marketOrderNO,marketOrderRow,materialCodeArr,factoryNO,new HttpDataListener<PreMaterialProductOrderReps>() {


            @Override
            public void onDataSuccess(PreMaterialProductOrderReps data) {
                getView().onDataSuccess4(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
