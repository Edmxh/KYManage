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
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

import java.util.List;

public class GetOutsourceFinProLableJSPresenter extends BasePresenter<PrintBaseView<GetOutsourceFinProLableJSRep>> {


    private final AppModel appModel;

    public GetOutsourceFinProLableJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutsourceFinProLableJS(List<Integer> data){
        appModel.GetOutsourceFinProLableDataJS(data,new HttpDataListener<GetOutsourceFinProLableJSRep>() {


            @Override
            public void onDataSuccess(GetOutsourceFinProLableJSRep data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
