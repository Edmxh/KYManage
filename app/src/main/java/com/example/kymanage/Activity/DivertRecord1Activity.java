package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.Print2Record1Adapter;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRepBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.Print2Record1.GetMainDumpRecordPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DivertRecord1Activity extends BaseActivity implements BaseView1<GetMainDumpRecordRep>, Print2Record1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //选择日期
    private TextView date;
    private ListView listView1;
    private Print2Record1Adapter adapter;
    private List<GetMainDumpRecordRepBean> datas;

    private GetMainDumpRecordPresenter presenter1;

    //username
    private String username;
    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_divert_record1;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        listView1 = findViewById(R.id.listview1);


        presenter1=new GetMainDumpRecordPresenter();
        presenter1.setView(this);

    }

    @Override
    public void initData() {
        datas=new ArrayList<GetMainDumpRecordRepBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                showDateAndTable();
            }
        });
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess1(GetMainDumpRecordRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas=data.getData();
            adapter=new Print2Record1Adapter(this, R.layout.print2record1item,datas);
            adapter.setOnInnerItemOnClickListener(this);
            listView1.setAdapter(adapter);
            listView1.setOnItemClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailed(String msg) {

    }

    //日期弹窗
    private void showDateAndTable() {
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
                GetMainDumpRecordReq req=new GetMainDumpRecordReq((str1+str2+str3),username);
                presenter1.GetMainDumpRecord(req);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("整体item----->", i + "");
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.detail:
                Log.e("detail----->", position + "");
                Intent intent=new Intent(DivertRecord1Activity.this,DivertRecord2Activity.class);
                intent.putExtra("id",datas.get(position).getID()+"");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
