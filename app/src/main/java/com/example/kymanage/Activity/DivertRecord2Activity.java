package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kymanage.Adapter.Print2Record2Adapter;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRepBean;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.Print2Record2.GetDumpRecordPresenter;

import java.util.ArrayList;
import java.util.List;

public class DivertRecord2Activity extends BaseActivity implements BaseView1<GetDumpRecordRep> {

    private String id;
    private ListView listView1;
    private List<GetDumpRecordRepBean> datas;
    private Print2Record2Adapter adapter;
    private GetDumpRecordPresenter presenter1;


    @Override
    public int initLayoutId() {
        return R.layout.activity_divert_record2;
    }

    @Override
    public void initview() {
        listView1=findViewById(R.id.listview1);

        presenter1=new GetDumpRecordPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        datas=new ArrayList<GetDumpRecordRepBean>();
        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        GetDumpRecordReq req=new GetDumpRecordReq(id);
        presenter1.GetDumpRecord(req);
    }

    @Override
    public void initLisenter() {

    }

    @Override
    public void onDataSuccess1(GetDumpRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas=data.getData();
            adapter=new Print2Record2Adapter(this, R.layout.print2record2item,datas);
            listView1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {

    }
}
