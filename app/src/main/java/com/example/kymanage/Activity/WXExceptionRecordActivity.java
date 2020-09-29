package com.example.kymanage.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kymanage.Adapter.WXExceptionRecordAdapter;
import com.example.kymanage.Beans.GetOutsoureExceptionRecordJS.GetOutsoureExceptionRecordJSRep;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.Presenters.WXPage9Record.GetOutsoureExceptionRecordJSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WXExceptionRecordActivity extends BaseActivity implements BaseView1<GetOutsoureExceptionRecordJSRep> {

    //选择日期
    private TextView date;
    private ListView listview1;
    private List<GetOutsoureExceptionRecordJSRep.GetOutsoureExceptionRecordJSRepBean> data1;
    private GetOutsoureExceptionRecordJSPresenter presenter1;
    private WXExceptionRecordAdapter adapter;

    //
    private String username;
    //震动
    private Vibrator vibrator;

    //筛选条件
    private TextView wlbm;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;
    private boolean queryall=true;


    @Override
    public int initLayoutId() {
        return R.layout.activity_wxexception_record;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        listview1 = findViewById(R.id.listview1);

        //筛选条件
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        queryself = findViewById(R.id.queryself);

        presenter1=new GetOutsoureExceptionRecordJSPresenter();
        presenter1.setView(this);
    }

    @Override
    public void initData() {

        data1=new ArrayList<GetOutsoureExceptionRecordJSRep.GetOutsoureExceptionRecordJSRepBean>();
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");


        date.setText(getCurrentdate());
        query();

    }

    //查询记录
    public void query(){
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.GetOutsoureExceptionRecordJS(username,getCurrentdate(),xsddh.getText().toString(),"","",queryall,"",wlbm.getText().toString(),"");
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
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                query();
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

                query();

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public void onDataSuccess1(GetOutsoureExceptionRecordJSRep data) {
        adapter=new WXExceptionRecordAdapter(this, R.layout.wxexceptionrecorditem,data.getData());
        listview1.setAdapter(adapter);
    }

    @Override
    public void onFailed(String msg) {

    }
}
