package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class GetIssueNoteDetail2Presenter extends BasePresenter<BaseView3<GetIssueNoteDetailRep>> {


    private final AppModel appModel;

    public GetIssueNoteDetail2Presenter() {
        appModel = new AppModel();
    }

    public void GetIssueNoteDetail2(List<GetIssueNoteDetailReq> data){
        appModel.GetIssueNoteDetail(data, new HttpDataListener<GetIssueNoteDetailRep>() {


            @Override
            public void onDataSuccess(GetIssueNoteDetailRep data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
