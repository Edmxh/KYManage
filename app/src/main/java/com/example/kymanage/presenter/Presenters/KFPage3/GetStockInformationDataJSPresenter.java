package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetStockInformationDataJS.GetStockInformationDataJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class GetStockInformationDataJSPresenter extends BasePresenter<ScanBaseView<GetStockInformationDataJSRep>> {


    private final AppModel appModel;

    public GetStockInformationDataJSPresenter() {
        appModel = new AppModel();
    }

    public void GetStockInformationDataJS(String materialCode,String factory){
        appModel.GetStockInformationDataJS(materialCode,factory, new HttpDataListener<GetStockInformationDataJSRep>() {


            @Override
            public void onDataSuccess(GetStockInformationDataJSRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
