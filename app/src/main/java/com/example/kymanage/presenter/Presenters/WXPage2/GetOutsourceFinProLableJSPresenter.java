package com.example.kymanage.presenter.Presenters.WXPage2;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.OutsoureFinProductWriteOffJS.OutsoureFinProductWriteOffJSReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class GetOutsourceFinProLableJSPresenter extends BasePresenter<BaseView3<GetOutsourceFinProLableJSRep>> {


    private final AppModel appModel;

    public GetOutsourceFinProLableJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutsourceFinProLableJS(String user, String requestTime, List<GetOutsourceFinProLableJSReqBean> data){
        appModel.GetOutsourceFinProLableJS(user,requestTime,data,new HttpDataListener<GetOutsourceFinProLableJSRep>() {


            @Override
            public void onDataSuccess(GetOutsourceFinProLableJSRep data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
