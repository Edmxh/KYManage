package com.example.kymanage.presenter.Presenters.KFPage4;


import com.example.kymanage.Beans.GetIssueRecord.GetIssueRecordReps;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetIssueRecordPresenter extends BasePresenter<BaseView1<GetIssueRecordReps>> {


    private final AppModel appModel;

    public GetIssueRecordPresenter() {
        appModel = new AppModel();
    }

    public void GetIssueRecord(String issueDate,String user){
        appModel.GetIssueRecord(issueDate,user,new HttpDataListener<GetIssueRecordReps>() {


            @Override
            public void onDataSuccess(GetIssueRecordReps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
