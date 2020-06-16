package com.example.kymanage.presenter;


import com.example.kymanage.Beans.LabelBean;
import com.example.kymanage.Beans.ReceivingListBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;

public class QueryLabelPresenter extends BasePresenter<IBaseView<LabelBean>> {


    private final AppModel appModel;

    public QueryLabelPresenter() {
        appModel = new AppModel();
    }

    public void querylabel(String lableseqnum){
        appModel.QueryLabel(lableseqnum, new HttpDataListener<LabelBean>() {


            @Override
            public void onDataSuccess(LabelBean data) {
                getView().onDataSuccess(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
