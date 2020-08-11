package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kymanage.Adapter.Print1Record2Adapter;
import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.Print1Record2.GetInFactoryDeliverListDetailJSPresenter;

import java.util.ArrayList;
import java.util.List;

public class PrintCNPSDRecord2Activity extends BaseActivity implements BaseView1<GetInFactoryDeliverListDetailJSRep> {

    private String DeliverID;
    private ListView listView1;
    private List<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean> datas;
    private Print1Record2Adapter adapter;
    private GetInFactoryDeliverListDetailJSPresenter presenter1;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_cnpsdrecord2;
    }

    @Override
    public void initview() {
        listView1=findViewById(R.id.listview1);

        presenter1=new GetInFactoryDeliverListDetailJSPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        datas=new ArrayList<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean>();
        Intent intent=getIntent();
        DeliverID=intent.getStringExtra("DeliverID");
        presenter1.GetInFactoryDeliverListDetailJS(DeliverID);
    }

    @Override
    public void initLisenter() {

    }

    @Override
    public void onDataSuccess1(GetInFactoryDeliverListDetailJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas=data.getData();
            adapter=new Print1Record2Adapter(this, R.layout.print1record2item,datas);
            listView1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {

    }
}
