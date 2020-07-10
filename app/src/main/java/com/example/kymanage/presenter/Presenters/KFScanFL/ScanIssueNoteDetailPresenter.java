package com.example.kymanage.presenter.Presenters.KFScanFL;


import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRep;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

import java.util.List;

public class ScanIssueNoteDetailPresenter extends BasePresenter<ScanBaseView<ScanIssueNoteDetailRep>> {


    private final AppModel appModel;

    public ScanIssueNoteDetailPresenter() {
        appModel = new AppModel();
    }

    public void ScanIssueNoteDetail(ScanIssueNoteDetailReqBean data){
        appModel.ScanIssueNoteDetail(data,new HttpDataListener<ScanIssueNoteDetailRep>() {


            @Override
            public void onDataSuccess(ScanIssueNoteDetailRep data) {
                getView().onDataSuccessScan(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
