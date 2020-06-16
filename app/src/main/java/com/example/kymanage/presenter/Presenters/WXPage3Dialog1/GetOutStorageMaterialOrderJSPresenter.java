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

    public void GetOutStorageMaterialOrderJS(String I_INKDPOS,String I_INMATNR,String I_INKDAUF,String I_INWERKS,boolean I_INFLAG){
        appModel.GetOutStorageMaterialOrderJS(I_INKDPOS,I_INMATNR,I_INKDAUF,I_INWERKS,I_INFLAG,new HttpDataListener<GetOutStorageMaterialOrderJSRep>() {


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
