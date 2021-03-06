package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.KFCGSHRecordAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.Warehouse105Writeoff.Warehouse105WriteoffReq;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordRep;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordReps;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.KFPage1Record.Warehouse105WriteoffPresenter;
import com.example.kymanage.presenter.Presenters.KFPage1Record.WarehouseReceiptRecordPresenter;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class KFCGRKRecordActivity extends BaseActivity implements BaseView1<WarehouseReceiptRecordReps>, BaseView2<CodeMessageBean> {
    //选择日期
    private TextView date;
    //筛选条件
    private TextView wlbm;
    private TextView cgddh;
    private TextView kwxx;
    private ImageView query;
    private Button reset;
    //入库冲销
    private ImageView receive;
    //listview
    private ListView listview1;
    //查询记录
    private WarehouseReceiptRecordPresenter presenter1;
    private List<WarehouseReceiptRecordRep> data1;
    //
    private KFCGSHRecordAdapter adapter;
    //105冲销
    private Warehouse105WriteoffPresenter presenter2;
    private List<Warehouse105WriteoffReq> allDatas;
    //username
    private String username;
    //震动
    private Vibrator vibrator;


    private CheckBox queryself;
    private boolean queryall=true;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfcgrkrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        wlbm = findViewById(R.id.wlbm);
        cgddh = findViewById(R.id.cgddh);
        kwxx = findViewById(R.id.kwxx);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        receive = findViewById(R.id.receive);
        listview1 = findViewById(R.id.listview1);
        queryself = findViewById(R.id.queryself);

        presenter1=new WarehouseReceiptRecordPresenter();
        presenter1.setView(this);

        presenter2=new Warehouse105WriteoffPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        allDatas=new ArrayList<Warehouse105WriteoffReq>();

        data1=new ArrayList<WarehouseReceiptRecordRep>();
        getSupportFragmentManager();

        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        queryself.setChecked(true);
//        date.setText(getCurrentdate());
////                System.out.println(username);
//        presenter1.WarehouseReceiptRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),kwxx.getText().toString());


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
                if(queryself.isChecked()){
                    queryall=false;
                }else {
                    queryall=true;
                }
                presenter1.WarehouseReceiptRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),kwxx.getText().toString(),queryall);
            }
        });

        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(KFCGRKRecordActivity.this);
            }
        });
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
//                System.out.println(username);
                if(queryself.isChecked()){
                    queryall=false;
                }else {
                    queryall=true;
                }
                presenter1.WarehouseReceiptRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),kwxx.getText().toString(),queryall);
//                presenter2.CGSHRecord((str1+str2+str3),"1");

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onDataSuccess1(WarehouseReceiptRecordReps data) {
//        System.out.println("查询记录成功");
        data1 = data.getData();
        adapter=new KFCGSHRecordAdapter(this, R.layout.kfcgrecorditem,data1);
        listview1.setAdapter(adapter);
        listview1.setOnItemClickListener(new ListViewItemOnClick());

        for (WarehouseReceiptRecordRep warehouseReceiptRecordRep : data1) {
            Warehouse105WriteoffReq tmp=new Warehouse105WriteoffReq(warehouseReceiptRecordRep.getStorageId());
            allDatas.add(tmp);
        }
    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        Toast.makeText(this,data.getMessage(),Toast.LENGTH_SHORT).show();
        LoadingBar.dialog(KFCGRKRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).cancel();
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.WarehouseReceiptRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),kwxx.getText().toString(),queryall);
    }

    @Override
    public void onFailed(String msg) {

    }
    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            View itme=listview1.getChildAt(position - listview1.getFirstVisiblePosition());
//
//            CheckableLayout itemlayout=itme.findViewById(R.id.parent_layout);
//
//            if(itemlayout.isChecked()){
//                setBackgroundChange(itme, R.drawable.tablebody3);
//            }else {
//                if(position%2==1){
//                    setBackgroundChange(itme, R.drawable.tablebody1);
//                }else {
//                    setBackgroundChange(itme, R.drawable.tablebody2);
//                }
//            }
//            itemlayout.toggle();
        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.cgddh).setBackgroundResource(i);
        view.findViewById(R.id.wllx).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.rksl).setBackgroundResource(i);
        view.findViewById(R.id.rklx).setBackgroundResource(i);
    }
    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }


    //冲销确认
    private void confirmDeleteDialog(Context context) {
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("请确认")
                .setMessage("确定要冲销吗？")
                .setSkinManager(QMUISkinManager.defaultInstance(context))
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "冲销", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        List<Warehouse105WriteoffReq> datas=new ArrayList<Warehouse105WriteoffReq>();
                        for (int i = 0; i < data1.size(); i++) {
                            View itmeview=listview1.getAdapter().getView(i,null,null);
                            CheckBox cb= itmeview.findViewById(R.id.checked);
                            if(cb.isChecked()){
                                WarehouseReceiptRecordRep currData = data1.get(i);
                                Warehouse105WriteoffReq req=new Warehouse105WriteoffReq(currData.getStorageId());
                                datas.add(req);
                            }
                        }
                        LoadingBar.dialog(KFCGRKRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).show();
                        presenter2.WarehouseReceiptRecord(datas,getCurrentdate2(),username);
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
