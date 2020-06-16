package com.example.kymanage.presenter;


import com.example.kymanage.Beans.GetMaterialInfo.GetMaterialInfoBean;
import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

public class GetMaterialInfoPresenter extends BasePresenter<IBaseView<GetMaterialInfoBean>> {


    private final AppModel appModel;

    public GetMaterialInfoPresenter() {
        appModel = new AppModel();
    }

    public void GetMaterialInfo(String material){
        appModel.GetMaterialInfo(material,new HttpDataListener<GetMaterialInfoBean>() {


            @Override
            public void onDataSuccess(GetMaterialInfoBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
