package com.example.kymanage.presenter.Presenters.CGPage1;


import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

import java.util.List;

public class CGSHPrintPresenter extends BasePresenter<PrintBaseView<GetParchaseCenterLableReps>> {


    private final AppModel appModel;

    public CGSHPrintPresenter() {
        appModel = new AppModel();
    }

    public void CGSHPrint(List<Long> AdvanceStorageIds,String Employee, String PrintTime){
        appModel.GetParchaseCenterLable(AdvanceStorageIds,Employee,PrintTime,new HttpDataListener<GetParchaseCenterLableReps>() {


            @Override
            public void onDataSuccess(GetParchaseCenterLableReps data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
