package com.example.kymanage.presenter.Presenters.WXPage2Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.OutsoureFinProductWriteOffJS.OutsoureFinProductWriteOffJSReqBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class OutsoureFinProductWriteOffJSPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public OutsoureFinProductWriteOffJSPresenter() {
        appModel = new AppModel();
    }

    public void OutsoureFinProductWriteOffJS(String user, String requestTime, List<OutsoureFinProductWriteOffJSReqBean> data){
        appModel.OutsoureFinProductWriteOffJS(user,requestTime,data,new HttpDataListener<CodeMessageBean>() {


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
