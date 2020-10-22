package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXZCSHRecordAdapter;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRep;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRepBean;
import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataReqBean;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReq;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReq;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReqBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.KFPage3Record.WriteOffProductOrderIssuePresenter;
import com.example.kymanage.presenter.Presenters.WXPage6Record.GetDistributorDumpRecordDataPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.kymanage.API.API.GetDistributorDumpRecordData;

public class KFZCSHRecordActivity extends BaseActivity implements BaseView1<GetDistributorDumpRecordDataRep>, BaseView2<StatusRespBean> {

    //选择日期
    private TextView date;
    //筛选条件
    private TextView wlbm;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    //入库冲销
    private ImageView receive;
    //listview
    private ListView listview1;
    //查询记录
    private ImageView scan;
    private GetDistributorDumpRecordDataPresenter presenter1;
    private List<GetDistributorDumpRecordDataRepBean> data1;
    //
    private WXZCSHRecordAdapter adapter;
    //261冲销
    private WriteOffProductOrderIssuePresenter presenter2;
    //username
    private String username;
    //震动
    private Vibrator vibrator;


    private CheckBox queryself;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfzcshrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        listview1 = findViewById(R.id.listview1);
        query = findViewById(R.id.query);
        scan = findViewById(R.id.scan);
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        queryself = findViewById(R.id.queryself);
        receive = findViewById(R.id.receive);
        reset = findViewById(R.id.reset);

        //查询记录
        presenter1=new GetDistributorDumpRecordDataPresenter();
        presenter1.setView(this);

        //261冲销
        presenter2=new WriteOffProductOrderIssuePresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        data1=new ArrayList<GetDistributorDumpRecordDataRepBean>();
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        queryself.setChecked(true);
        date.setText(getCurrentdate());
        queryRecord();
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
                queryRecord();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(KFZCSHRecordActivity.this);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                date.setText("");
            }
        });
    }

    @Override
    public void onDataSuccess2(StatusRespBean data) {
        if (data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
//            LoadingBar.dialog(KFZCSHRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).cancel();
            queryRecord();
        }else {
            DialogUtil.errorMessageDialog(KFZCSHRecordActivity.this,data.getStatus().getMessage());
        }
    }

    @Override
    public void onDataSuccess1(GetDistributorDumpRecordDataRep data) {
        if(data.getStatus().getCode()==1){
            data1=data.getData();
            adapter=new WXZCSHRecordAdapter(KFZCSHRecordActivity.this, R.layout.wxzcshrecorditem,data1);
            listview1.setAdapter(adapter);
        }else {
            DialogUtil.errorMessageDialog(KFZCSHRecordActivity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {

    }

    private void queryRecord(){
        String queryall;
        if(queryself.isChecked()){
            queryall=username;
        }else {
            queryall="";
        }
        GetDistributorDumpRecordDataReqBean rep=new GetDistributorDumpRecordDataReqBean(date.getText().toString(), queryall, wlbm.getText().toString(), xsddh.getText().toString());
        presenter1.GetDistributorDumpRecordData(rep);
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
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

                queryRecord();

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    private void writeOff(){
        List<WriteOffProductOrderIssueReqBean> cxDatas=new ArrayList<WriteOffProductOrderIssueReqBean>();
        for (int i = 0; i < data1.size(); i++) {
            View itmeview=listview1.getAdapter().getView(i,null,null);
            CheckBox cb= itmeview.findViewById(R.id.checked);
            if (cb.isChecked()){
                WriteOffProductOrderIssueReqBean cxData=new WriteOffProductOrderIssueReqBean((""+data1.get(i).getIssueId()));
                cxDatas.add(cxData);
            }
        }
        WriteOffProductOrderIssueReq cxReq=new WriteOffProductOrderIssueReq(username,cxDatas);
        presenter2.WriteOffProductOrderIssue(cxReq);
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
                        writeOff();
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
