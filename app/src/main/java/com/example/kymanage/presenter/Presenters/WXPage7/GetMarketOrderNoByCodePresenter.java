package com.example.kymanage.presenter.Presenters.WXPage7;


import com.example.kymanage.Beans.GetMarketOrderNoByCode.GetMarketOrderNoByCodeRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordRep;
import com.example.kymanage.Beans.InsertFinAProOrderRecord.InsertFinAProOrderRecordReq;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;

public class GetMarketOrderNoByCodePresenter extends BasePresenter<BaseView2<GetMarketOrderNoByCodeRep>> {


    private final AppModel appModel;

    public GetMarketOrderNoByCodePresenter() {
        appModel = new AppModel();
    }

    public void GetMarketOrderNoByCode(String materialCode){
        appModel.GetMarketOrderNoByCode(materialCode,new HttpDataListener<GetMarketOrderNoByCodeRep>() {


            @Override
            public void onDataSuccess(GetMarketOrderNoByCodeRep data) {
                getView().onDataSuccess2(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
