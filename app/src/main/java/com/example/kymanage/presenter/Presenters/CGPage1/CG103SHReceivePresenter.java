package com.example.kymanage.presenter.Presenters.CGPage1;


import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103RepStatus;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103ReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class CG103SHReceivePresenter extends BasePresenter<BaseView2<MaterialFlow103RepStatus>> {


    private final AppModel appModel;

    public CG103SHReceivePresenter() {
        appModel = new AppModel();
    }

    public void CG103SHReceive(String postingDate, String documentDate, String user, List<MaterialFlow103ReqBean> detail){
        appModel.MaterialFlow103(postingDate,documentDate,user,detail,new HttpDataListener<MaterialFlow103RepStatus>() {


            @Override
            public void onDataSuccess(MaterialFlow103RepStatus data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
