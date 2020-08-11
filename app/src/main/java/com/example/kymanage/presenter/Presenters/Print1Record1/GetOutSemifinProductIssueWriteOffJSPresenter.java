package com.example.kymanage.presenter.Presenters.Print1Record1;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class GetOutSemifinProductIssueWriteOffJSPresenter extends BasePresenter<BaseView3<CodeMessageBean>> {


    private final AppModel appModel;

    public GetOutSemifinProductIssueWriteOffJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutSemifinProductIssueWriteOffJS(List<String> DeliverIDArr, String user, String documentDate){
        appModel.GetOutSemifinProductIssueWriteOffJS(DeliverIDArr,user,documentDate,new HttpDataListener<CodeMessageBean>() {


            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
