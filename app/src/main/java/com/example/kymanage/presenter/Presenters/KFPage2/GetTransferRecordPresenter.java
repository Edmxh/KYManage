package com.example.kymanage.presenter.Presenters.KFPage2;


import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordRep;
import com.example.kymanage.Beans.GetTransferRecord.GetTransferRecordReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class GetTransferRecordPresenter extends BasePresenter<ScanBaseView<GetTransferRecordRep>> {


    private final AppModel appModel;

    public GetTransferRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetTransferRecord(GetTransferRecordReqBean data){
        appModel.GetTransferRecord(data, new HttpDataListener<GetTransferRecordRep>() {

            @Override
            public void onDataSuccess(GetTransferRecordRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
