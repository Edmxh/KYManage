package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.XSFHRecordAdapter;
import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRepBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Print3Record.GetDeliveryListDetailDataJSPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class XSFHRecord2Activity extends BaseActivity implements BaseView1<GetDeliveryListDetailDataJSRep> {
    //print
    private ImageView print;
    //选择日期
    private TextView date;
    //listview
    private String DeliveryListNO;
    private ListView listview1;
    private List<GetDeliveryListDetailDataJSRepBean> datas;
    private XSFHRecordAdapter adapter;
    //
    private String username;
    //
    private GetDeliveryListDetailDataJSPresenter presenter1;
    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_xsfhrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        print = findViewById(R.id.print);
        listview1 = findViewById(R.id.listview1);

        presenter1=new GetDeliveryListDetailDataJSPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        DeliveryListNO=intent.getStringExtra("DeliveryListNO");

        datas=new ArrayList<GetDeliveryListDetailDataJSRepBean>();

        presenter1.GetDeliveryListDetailDataJS(DeliveryListNO);

    }

    @Override
    public void initLisenter() {
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess1(GetDeliveryListDetailDataJSRep data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
//        System.out.println(data.getData().get(0).getClientName());
            datas=data.getData();
            adapter=new XSFHRecordAdapter(this, R.layout.xsfhrecorditem,datas);
            listview1.setAdapter(adapter);
        }else {
            DialogUtil.errorMessageDialog(XSFHRecord2Activity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {

    }
}
