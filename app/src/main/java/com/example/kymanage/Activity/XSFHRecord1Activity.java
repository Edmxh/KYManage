package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kymanage.Adapter.Print3Record1Adapter;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRepBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Print3Record.GetDeliveryListDataJSPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class XSFHRecord1Activity extends BaseActivity implements BaseView1<GetDeliveryListDataJSRep>, Print3Record1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

    //选择日期
    private TextView date;
    private ListView listview1;
    private List<GetDeliveryListDataJSRepBean> datas;
    private Print3Record1Adapter adapter;
    //筛选条件
    private TextView wlbm;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;
    private boolean queryall;

    private GetDeliveryListDataJSPresenter presenter1;

    //username
    private String username;
    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_xsfhrecord1;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        listview1 = findViewById(R.id.listview1);
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        queryself = findViewById(R.id.queryself);

        //查询记录
        presenter1=new GetDeliveryListDataJSPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        datas=new ArrayList<GetDeliveryListDataJSRepBean>();

        date.setText(getCurrentdate());
        queryRecord();

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
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                date.setText("");
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                queryRecord();
            }
        });
    }

    @Override
    public void onDataSuccess1(GetDeliveryListDataJSRep data) {
        if(data.getCode()==1){
            datas=data.getData();
            adapter=new Print3Record1Adapter(this, R.layout.print3record1item,datas);
            adapter.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(this);
        }else {
            DialogUtil.errorMessageDialog(XSFHRecord1Activity.this,data.getMessage());
        }
    }

    @Override
    public void onFailed(String msg) {

    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }


    //查询
    private void queryRecord(){
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.GetDeliveryListDataJS(username,queryall,date.getText().toString(),wlbm.getText().toString(),xsddh.getText().toString());
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
                queryRecord();

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void itemClick(View v) {

    }
}
