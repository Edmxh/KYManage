package com.example.kymanage.presenter.Presenters.CGPage1;


import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class CGSHReceiveDetailPresenter extends BasePresenter<BaseView1<PreMaterialProductOrderReps>> {


    private final AppModel appModel;

    public CGSHReceiveDetailPresenter() {
        appModel = new AppModel();
    }

    public void CGSHReceiveDetail(String marketOrderNO,String marketOrderRow,String materialCode,String factoryNO,float matnrCurrentNum){
        appModel.PreMaterialProductOrder(marketOrderNO,marketOrderRow,materialCode,factoryNO,matnrCurrentNum,new HttpDataListener<PreMaterialProductOrderReps>() {


            @Override
            public void onDataSuccess(PreMaterialProductOrderReps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
