package com.example.kymanage.presenter.Presenters.KFPage4;


import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class GetWarehouselabelPresenter extends BasePresenter<BaseView2<InsertStorageLableRecordReps>> {


    private final AppModel appModel;

    public GetWarehouselabelPresenter() {
        appModel = new AppModel();
    }

    public void GetWarehouselabel(List<Long> issueId){
        appModel.GetWarehouselabel(issueId,new HttpDataListener<InsertStorageLableRecordReps>() {


            @Override
            public void onDataSuccess(InsertStorageLableRecordReps data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
