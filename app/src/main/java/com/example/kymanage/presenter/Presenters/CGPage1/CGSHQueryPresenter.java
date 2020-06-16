package com.example.kymanage.presenter.Presenters.CGPage1;


import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.Beans.ReceivingListBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.IBaseView;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class CGSHQueryPresenter extends BasePresenter<BaseView1<GetRecevingDetailreps>> {


    private final AppModel appModel;

    public CGSHQueryPresenter() {
        appModel = new AppModel();
    }

    public void CGSHQuerydata(String orderno){
        appModel.ReceivingList(orderno,new HttpDataListener<GetRecevingDetailreps>() {


            @Override
            public void onDataSuccess(GetRecevingDetailreps data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
