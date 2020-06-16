package com.example.kymanage.presenter.Presenters.CGPage1;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Req;
import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;

import java.util.List;

public class CG103SHReceivePresenter extends BasePresenter<BaseView2<MaterialFlow103Rep>> {


    private final AppModel appModel;

    public CG103SHReceivePresenter() {
        appModel = new AppModel();
    }

    public void CG103SHReceive(String postingDate, String documentDate, String user, List<MaterialFlow103Req> detail){
        appModel.MaterialFlow103(postingDate,documentDate,user,detail,new HttpDataListener<MaterialFlow103Rep>() {


            @Override
            public void onDataSuccess(MaterialFlow103Rep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
