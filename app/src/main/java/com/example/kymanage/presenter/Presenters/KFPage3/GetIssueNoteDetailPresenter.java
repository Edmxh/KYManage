package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class GetIssueNoteDetailPresenter extends BasePresenter<BaseView1<GetIssueNoteDetailRep>> {


    private final AppModel appModel;

    public GetIssueNoteDetailPresenter() {
        appModel = new AppModel();
    }

    public void GetIssueNoteDetail(List<GetIssueNoteDetailReq> data){
        appModel.GetIssueNoteDetail(data, new HttpDataListener<GetIssueNoteDetailRep>() {


            @Override
            public void onDataSuccess(GetIssueNoteDetailRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
