package com.example.kymanage.presenter.Presenters.WXPage3Record;


import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteReqBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.model.AppModel;
import com.example.kymanage.net.HttpDataListener;
import com.example.kymanage.presenter.BasePresenter;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;

import java.util.List;

public class GetFinProStorageRecordNotePresenter extends BasePresenter<BaseView3<GetFinProStorageRecordNoteRep>> {


    private final AppModel appModel;

    public GetFinProStorageRecordNotePresenter() {
        appModel = new AppModel();
    }

    public void GetFinProStorageRecordNote(List<GetFinProStorageRecordNoteReqBean> data){
        appModel.GetFinProStorageRecordNote(data,new HttpDataListener<GetFinProStorageRecordNoteRep>() {


            @Override
            public void onDataSuccess(GetFinProStorageRecordNoteRep data) {
                getView().onDataSuccess3(data);
            }

            @Override
            public void onFailer(String msg) {
                getView().onFailed(msg);
            }
        });
    }


}
