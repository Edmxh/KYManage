package com.example.kymanage.presenter.Presenters.WXPage1;


import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

import java.util.List;

public class GetIssueAndDispatchListJSPresenter extends BasePresenter<PrintBaseView<GetDispatchListJSRep>> {


    private final AppModel appModel;

    public GetIssueAndDispatchListJSPresenter() {
        appModel = new AppModel();
    }

    public void GetIssueAndDispatchListJS(List<Long> AdvanceStorageIdArr, String user){
        appModel.GetIssueAndDispatchListJS(AdvanceStorageIdArr,user,new HttpDataListener<GetDispatchListJSRep>() {


            @Override
            public void onDataSuccess(GetDispatchListJSRep data) {
                getView().onDataSuccessPrint(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
