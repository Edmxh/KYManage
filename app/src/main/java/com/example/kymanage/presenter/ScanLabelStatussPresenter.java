package com.example.kymanage.presenter;


import com.example.kymanage.Beans.GetLableInfo.LabelStatussBean;
import com.example.kymanage.Beans.LabelBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

public class ScanLabelStatussPresenter extends BasePresenter<IBaseView<LabelStatussBean>> {


    private final AppModel appModel;

    public ScanLabelStatussPresenter() {
        appModel = new AppModel();
    }

    public void ScanLabelStatuss(String lableseqnum){
        appModel.ScanLabelStatuss(lableseqnum, new HttpDataListener<LabelStatussBean>() {


            @Override
            public void onDataSuccess(LabelStatussBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
