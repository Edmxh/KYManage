package com.example.kymanage.presenter.Presenters.KFPage3Record;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueRep;
import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueReq;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class WriteOffProductOrderIssuePresenter extends BasePresenter<BaseView2<StatusRespBean>> {


    private final AppModel appModel;

    public WriteOffProductOrderIssuePresenter() {
        appModel = new AppModel();
    }

    public void WriteOffProductOrderIssue(WriteOffProductOrderIssueReq data){
        appModel.WriteOffProductOrderIssue(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
