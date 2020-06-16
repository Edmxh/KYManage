package com.example.kymanage.presenter.Presenters;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.ReceivingListBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.IBaseView;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

import java.util.List;

public class YRKCX103Presenter extends BasePresenter<BaseView1<StatusRespBean>> {


    private final AppModel appModel;

    public YRKCX103Presenter() {
        appModel = new AppModel();
    }

    public void YRKCX103(List<Long> ids,String RequestTime){
        appModel.MaterialFlow103WriteOff(ids,RequestTime, new HttpDataListener<StatusRespBean>() {


            @Override
            public void onDataSuccess(StatusRespBean data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
