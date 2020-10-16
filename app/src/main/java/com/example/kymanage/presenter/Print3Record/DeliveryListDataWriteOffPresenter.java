package com.example.kymanage.presenter.Print3Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class DeliveryListDataWriteOffPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public DeliveryListDataWriteOffPresenter() {
        appModel = new AppModel();
    }

    public void DeliveryListDataWriteOff(List<String> VBELN_VL, String user){
        appModel.DeliveryListDataWriteOff( VBELN_VL, user,new HttpDataListener<CodeMessageBean>() {


            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
