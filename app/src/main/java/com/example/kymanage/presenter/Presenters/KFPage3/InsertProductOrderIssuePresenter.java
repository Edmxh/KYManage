package com.example.kymanage.presenter.Presenters.KFPage3;


import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.SendProductOrderIssueReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

public class InsertProductOrderIssuePresenter extends BasePresenter<BaseView2<InsertProductOrderIssueRep>> {


    private final AppModel appModel;

    public InsertProductOrderIssuePresenter() {
        appModel = new AppModel();
    }

    public void InsertProductOrderIssue(SendProductOrderIssueReq data){
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
