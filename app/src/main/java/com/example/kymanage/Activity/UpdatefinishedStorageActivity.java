package com.example.kymanage.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.UpdatefinishedStorage.UpdatefinishedStorageData;
import com.example.kymanage.R;
import com.example.kymanage.presenter.JJreceiveView103;
import com.example.kymanage.presenter.JJreceiveView105;
import com.example.kymanage.presenter.UpdatefinishedStoragePresenter;

import java.util.ArrayList;
import java.util.List;

public class UpdatefinishedStorageActivity extends BaseActivity implements JJreceiveView105<StatusRespBean> {

    private Button cprk;
    private List<UpdatefinishedStorageData> data;
    private UpdatefinishedStoragePresenter updatefinishedStoragePresenter;

    @Override
    public int initLayoutId() {
        return R.layout.activity_updatefinished_storage;
    }

    @Override
    public void initview() {
        cprk=findViewById(R.id.cprk);

    }

    @Override
    public void initData() {
        updatefinishedStoragePresenter=new UpdatefinishedStoragePresenter();
        //updatefinishedStoragePresenter.setView(this);
        data=new ArrayList<UpdatefinishedStorageData>();

    }

    @Override
    public void initLisenter() {
        cprk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println(UpdateSemiStorageReqs.getData().get(1).getReceiveDate());
                UpdatefinishedStorageData data1=new UpdatefinishedStorageData();
                data1.setBktxt("2020-03-05");
                data1.setDdate("2020-03-05");
                data1.setGzrq("1");
                data1.setGzsl(1);
                data1.setLgort("1");
                data1.setMatnr("1");
                data1.setUser("1");
                data1.setWerks("1");
                data.add(data1);
                updatefinishedStoragePresenter.UpdatefinishedStorage(data);
                Toast.makeText(UpdatefinishedStorageActivity.this, "正在查询...", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onDataSuccessjj105(StatusRespBean data) {
        System.out.println(data.getStatus().getMessage());
    }

    @Override
    public void onFailed(String msg) {

    }
}
