package com.example.kymanage.presenter.Presenters.KFPage4;


import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReps;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetIssueRecordPresenter extends BasePresenter<BaseView1<GetIssueDetailRecordReps>> {


    private final AppModel appModel;

    public GetIssueRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetIssueRecord(GetIssueDetailRecordReq data){
        appModel.GetIssueDetailRecord(data,new HttpDataListener<GetIssueDetailRecordReps>() {


            @Override
            public void onDataSuccess(GetIssueDetailRecordReps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
