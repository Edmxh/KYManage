package com.example.kymanage.presenter.Presenters.WXPage1Record;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class Semi_FinishedProductReceivingwriteoffJSPresenter extends BasePresenter<BaseView2<CodeMessageBean>> {


    private final AppModel appModel;

    public Semi_FinishedProductReceivingwriteoffJSPresenter() {
        appModel = new AppModel();
    }

    public void Semi_FinishedProductReceivingwriteoffJS(String user, String CurrentDate, List<Semi_FinishedProductReceivingwriteoffJSReqBean> data){
        appModel.Semi_FinishedProductReceivingwriteoffJS(user,CurrentDate,data,new HttpDataListener<CodeMessageBean>() {


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
