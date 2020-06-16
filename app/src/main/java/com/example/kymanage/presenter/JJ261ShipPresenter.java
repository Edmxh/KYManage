package com.example.kymanage.presenter;


import com.example.kymanage.Beans.InsertProductOrderIssue.InsertProductOrderIssueReq;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

import java.util.List;

public class JJ261ShipPresenter extends BasePresenter<JJshipView<StatusRespBean>> {


    private final AppModel appModel;

    public JJ261ShipPresenter() {
        appModel = new AppModel();
    }

    public void InsertProductOrderIssue(List<InsertProductOrderIssueReq> data){
        appModel.InsertProductOrderIssue(data, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccessjjship(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
