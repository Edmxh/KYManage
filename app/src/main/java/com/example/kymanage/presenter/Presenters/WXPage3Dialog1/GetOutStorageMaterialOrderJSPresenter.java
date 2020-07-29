package com.example.kymanage.presenter.Presenters.WXPage3Dialog1;


import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;

public class GetOutStorageMaterialOrderJSPresenter extends BasePresenter<BaseView1<GetOutStorageMaterialOrderJSRep>> {


    private final AppModel appModel;

    public GetOutStorageMaterialOrderJSPresenter() {
        appModel = new AppModel();
    }

    public void GetOutStorageMaterialOrderJS(String KDPOS,String MATNR,String KDAUF,String WERKS,float RQTY){
        appModel.GetOutStorageMaterialOrderJS(KDPOS,MATNR,KDAUF,WERKS,RQTY,new HttpDataListener<GetOutStorageMaterialOrderJSRep>() {


            @Override
            public void onDataSuccess(GetOutStorageMaterialOrderJSRep data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
