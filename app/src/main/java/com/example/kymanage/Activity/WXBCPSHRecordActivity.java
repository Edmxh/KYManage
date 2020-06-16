package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.WXBCPSHRecordAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRepBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.WXPage1Record.Semi_FinishedProductReceivingRecordJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1Record.Semi_FinishedProductReceivingwriteoffJSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WXBCPSHRecordActivity extends BaseActivity implements BaseView1<Semi_FinishedProductReceivingRecordJSRep>, BaseView2<CodeMessageBean> {
    //选择日期
    private TextView date;
    private List<Semi_FinishedProductReceivingRecordJSRepBean> data1;
    private Semi_FinishedProductReceivingRecordJSPresenter presenter1;
    private WXBCPSHRecordAdapter adapter;
    //入库冲销
    private ImageView receive;
    private Semi_FinishedProductReceivingwriteoffJSPresenter presenter2;
    //打印
    private ImageView print;
    //listview
    private ListView listview1;
    //
    private String username;
    //震动
    private Vibrator vibrator;


    @Override
    public int initLayoutId() {
        return R.layout.activity_wxshjl;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        print = findViewById(R.id.print);
        listview1 = findViewById(R.id.listview1);

        presenter1=new Semi_FinishedProductReceivingRecordJSPresenter();
        presenter1.setView(this);

        presenter2=new Semi_FinishedProductReceivingwriteoffJSPresenter();
        presenter2.setView(this);

    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
//        System.out.println("username:"+username);

        data1=new ArrayList<Semi_FinishedProductReceivingRecordJSRepBean>();
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
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<Semi_FinishedProductReceivingwriteoffJSReqBean> idslist=new ArrayList<Semi_FinishedProductReceivingwriteoffJSReqBean>();
                if(data1!=null){
                    for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        Semi_FinishedProductReceivingRecordJSRepBean currData = data1.get(i);
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            Semi_FinishedProductReceivingwriteoffJSReqBean idreq=new Semi_FinishedProductReceivingwriteoffJSReqBean(currData.getStorageId(),currData.getAdvanceStorageId());
                            idslist.add(idreq);
                        }
                    }
                }
//                WriteOffProStorageRecordReq req=new WriteOffProStorageRecordReq(username,idlist);
//                System.out.println("冲销选中数:"+idlist.size());
                presenter2.Semi_FinishedProductReceivingwriteoffJS(username,getCurrentdate(),idslist);
                //Toast.makeText(CGRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);

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

                presenter1.Semi_FinishedProductReceivingRecordJS((str1+str2+str3),username,"外协半成品");

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    @Override
    public void onDataSuccess1(Semi_FinishedProductReceivingRecordJSRep data) {
        try {
            data1 = data.getData();
            System.out.println(data1.size());
            //表格适配数据
            adapter=new WXBCPSHRecordAdapter(WXBCPSHRecordActivity.this, R.layout.wxbcpshrecorditem,data1);
            listview1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        Toast.makeText(WXBCPSHRecordActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
        presenter1.Semi_FinishedProductReceivingRecordJS(date.getText().toString(),username,"外协半成品");
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
}
