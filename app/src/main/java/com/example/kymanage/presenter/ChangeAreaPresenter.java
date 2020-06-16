package com.example.kymanage.presenter;


import com.example.kymanage.Beans.FlagAndMessageBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

public class ChangeAreaPresenter extends BasePresenter<ChangeAreaView<FlagAndMessageBean>> {


    private final AppModel appModel;

    public ChangeAreaPresenter() {
        appModel = new AppModel();
    }

    public void ChangeArea(String lableseqnum,String areano,String changetime,String people){
        appModel.ChangeLabelArea(lableseqnum, areano,changetime,people, new HttpDataListener<FlagAndMessageBean>() {


            @Override
            public void onDataSuccess(FlagAndMessageBean data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
