package com.example.kymanage.presenter.Presenters.WXPage1;


import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.Print2BaseView;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

import java.util.List;

public class Semi_FinishedProductReceivingLablePresenter extends BasePresenter<Print2BaseView<Semi_FinishedProductReceivingLableRep>> {


    private final AppModel appModel;

    public Semi_FinishedProductReceivingLablePresenter() {
        appModel = new AppModel();
    }

    public void Semi_FinishedProductReceivingLable(long AdvanceStorageId, String User,String RequesTime){
        appModel.Semi_FinishedProductReceivingLable(AdvanceStorageId,User,RequesTime,new HttpDataListener<Semi_FinishedProductReceivingLableRep>() {


            @Override
            public void onDataSuccess(Semi_FinishedProductReceivingLableRep data) {
                getView().onDataSuccessPrint2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
