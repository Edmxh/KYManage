package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class InsertProductOrderIssuePresenter extends BasePresenter<BaseView2<InsertProductOrderIssueRep>> {


    private final AppModel appModel;

    public InsertProductOrderIssuePresenter() {
        appModel = new AppModel();
    }

    public void InsertProductOrderIssue(List<InsertProductOrderIssueReq> data){
        appModel.InsertProductOrderIssue(data, new HttpDataListener<InsertProductOrderIssueRep>() {


            @Override
            public void onDataSuccess(InsertProductOrderIssueRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
