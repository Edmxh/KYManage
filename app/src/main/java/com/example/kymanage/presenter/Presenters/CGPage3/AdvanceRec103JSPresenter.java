package com.example.kymanage.presenter.Presenters.CGPage3;


import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetPreRecMaterialCodeInfoJS.GetPreRecMaterialCodeInfoJSRep;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.ScanBaseView;

public class AdvanceRec103JSPresenter extends BasePresenter<BaseView1<CodeMessageBean>> {


    private final AppModel appModel;

    public AdvanceRec103JSPresenter() {
        appModel = new AppModel();
    }

    public void AdvanceRec103JS(long AdvanceStorageId,String DocumentDate,String PostingDate,String User,float RecNum){
        appModel.AdvanceRec103JS( AdvanceStorageId, DocumentDate, PostingDate, User, RecNum,new HttpDataListener<CodeMessageBean>() {


            @Override
            public void onDataSuccess(CodeMessageBean data) {
                getView().onDataSuccess1(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
