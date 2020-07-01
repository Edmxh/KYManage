package com.example.kymanage.presenter.Presenters.KFPage3Record;


import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;

import java.util.List;

public class GetIssueNoteDetail4Presenter extends BasePresenter<BaseView4<GetIssueNoteDetailRep>> {


    private final AppModel appModel;

    public GetIssueNoteDetail4Presenter() {
        appModel = new AppModel();
    }

    public void GetIssueNoteDetail2(List<GetIssueNoteDetailReq> data){
        appModel.GetIssueNoteDetail(data, new HttpDataListener<GetIssueNoteDetailRep>() {


            @Override
            public void onDataSuccess(GetIssueNoteDetailRep data) {
                getView().onDataSuccess4(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
