package com.example.kymanage.presenter.Presenters.Print1Record2;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class OutSemifinProductIssueWriteOffJSPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public OutSemifinProductIssueWriteOffJSPresenter() {
        appModel = new AppModel();
    }

    public void OutSemifinProductIssueWriteOffJS(List<String> dispatchListNOArr,String user,String deliverID){
        appModel.OutSemifinProductIssueWriteOffJS(dispatchListNOArr,user,deliverID,new HttpDataListener<CodeMessageBean>() {


            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
