package com.example.kymanage.presenter.Presenters.KFPage3Record;


import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordRep;
import com.example.kymanage.Beans.GenerateStorageLssueRecord.GenerateStorageLssueRecordReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;

import java.util.List;

public class GenerateStorageLssueRecord4Presenter extends BasePresenter<BaseView4<GenerateStorageLssueRecordRep>> {


    private final AppModel appModel;

    public GenerateStorageLssueRecord4Presenter() {
        appModel = new AppModel();
    }

    public void GenerateStorageLssueRecord2(GenerateStorageLssueRecordReq data){
        appModel.GenerateStorageLssueRecord(data, new HttpDataListener<GenerateStorageLssueRecordRep>() {


            @Override
            public void onDataSuccess(GenerateStorageLssueRecordRep data) {
                getView().onDataSuccess4(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
