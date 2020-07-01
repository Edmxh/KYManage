package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Print3Record.GetDeliveryListDetailDataJSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class XSFHRecordActivity extends BaseActivity implements BaseView2<GetDeliveryListDetailDataJSRep> {
    //print
    private ImageView print;
    //选择日期
    private TextView date;
    //listview
    private ListView listview1;
    private List<GetDeliveryListDetailDataJSRepBean> datas;
    private XSFHRecordAdapter adapter;
    //
    private String username;
    //
    private GetDeliveryListDetailDataJSPresenter presenter2;
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

        presenter2=new GetDeliveryListDetailDataJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        datas=new ArrayList<GetDeliveryListDetailDataJSRepBean>();
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                showdate();
            }
        });
    }

    //日期弹窗
    private void showdate() {
        Calendar calendar = Calendar.getInstance();//调用Calendar类获取年月日
        int  mYear = calendar.get(Calendar.YEAR);//年
        int  mMonth = calendar.get(Calendar.MONTH);//月份要加一个一，这个值的初始值是0。不加会日期会少一月。
        int  mDay = calendar.get(Calendar.DAY_OF_MONTH);//日
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String str1=""+i;
                String str2;
                String str3;
                str2=(i1+1)<10?("-0"+(i1+1)):"-" + (i1+1);
                str3=i2<10?("-0"+i2):"-"+i2;
                date.setText(str1+str2+str3);
                presenter2.GetDeliveryListDetailDataJS((str1+str2+str3),username,"S");
//                presenter1.Semi_FinishedProductReceivingRecordJS((str1+str2+str3),username,"外协半成品");

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess2(GetDeliveryListDetailDataJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
//        System.out.println(data.getData().get(0).getClientName());
        datas=data.getData();
        adapter=new XSFHRecordAdapter(this, R.layout.xsfhrecorditem,datas);
        listview1.setAdapter(adapter);
    }

    @Override
    public void onFailed(String msg) {

    }
}
