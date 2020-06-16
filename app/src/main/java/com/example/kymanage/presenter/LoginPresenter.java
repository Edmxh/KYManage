package com.example.kymanage.presenter;


import com.example.kymanage.Beans.LoginBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

public class LoginPresenter extends BasePresenter<IBaseView<LoginBean>> {


    private final AppModel appModel;

    public LoginPresenter() {
        appModel = new AppModel();
    }

    public void Logindata(String name, String pwd){
        appModel.comingSoondata(name, pwd, new HttpDataListener<LoginBean>() {


            @Override
            public void onDataSuccess(LoginBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
