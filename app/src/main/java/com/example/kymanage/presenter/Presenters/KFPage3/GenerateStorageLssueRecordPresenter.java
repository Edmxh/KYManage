package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GenerateStorageLssueRecordPresenter extends BasePresenter<BaseView1<GenerateStorageLssueRecordRep>> {


    private final AppModel appModel;

    public GenerateStorageLssueRecordPresenter() {
        appModel = new AppModel();
    }

    public void GenerateStorageLssueRecord(GenerateStorageLssueRecordReq data){
        appModel.GenerateStorageLssueRecord(data, new HttpDataListener<GenerateStorageLssueRecordRep>() {


            @Override
            public void onDataSuccess(GenerateStorageLssueRecordRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
