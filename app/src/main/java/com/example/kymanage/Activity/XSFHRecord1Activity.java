package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.Print3Record1Adapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRep;
import com.example.kymanage.Beans.GetDeliveryListDataJS.GetDeliveryListDataJSRepBean;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean2;
import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSRepBean3;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Print3Record.DeliveryListDataWriteOffPresenter;
import com.example.kymanage.presenter.Print3Record.GetDeliveryListDataJSPresenter;
import com.example.kymanage.presenter.Print3Record.GetDeliveryListJSPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.example.kymanage.utils.mPrintUtil;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class XSFHRecord1Activity extends BaseActivity implements BaseView1<GetDeliveryListDataJSRep>, BaseView2<CodeMessageBean>, PrintBaseView<GetDeliveryListInfoJSRepBean3>, Print3Record1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {

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

    //冲销
    private ImageView receive;
    private DeliveryListDataWriteOffPresenter presenter2;

    //补打
    private ImageView print;
    private GetDeliveryListJSPresenter presenterPrint;

    //打印类
    private PrintHelper printHelper=null;
    private com.example.kymanage.utils.mPrintUtil mPrintUtil;

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
        receive = findViewById(R.id.receive);
        print = findViewById(R.id.print);

        //查询记录
        presenter1=new GetDeliveryListDataJSPresenter();
        presenter1.setView(this);

        //冲销
        presenter2=new DeliveryListDataWriteOffPresenter();
        presenter2.setView(this);

        //补打
        presenterPrint=new GetDeliveryListJSPresenter();
        presenterPrint.setView(this);
    }

    @Override
    public void initData() {
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        datas=new ArrayList<GetDeliveryListDataJSRepBean>();

        date.setText(getCurrentdate());
        queryself.setChecked(true);
        queryRecord();

        mPrintUtil=new mPrintUtil();
        //初始化打印类
        initPrinter();

    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(XSFHRecord1Activity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(XSFHRecord1Activity.this);
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                String reqStr="";
                for (int i = 0; i < datas.size(); i++) {
                    View view = listview1.getAdapter().getView(i, null, null);
                    CheckBox cb=view.findViewById(R.id.checked);
                    if(cb.isChecked()&&datas.get(i).getStatus().equals("0")){
                        if(reqStr.equals("")){
                            reqStr+=datas.get(i).getDeliveryListNO();
                        }else {
                            reqStr+=","+datas.get(i).getDeliveryListNO();
                        }

                    }
                }
                if(!reqStr.equals("")){
                    presenterPrint.GetDeliveryListJS(reqStr);
                }else {
                    DialogUtil.errorMessageDialog(XSFHRecord1Activity.this,"未选择要补打的记录或选择的记录已被冲销");
                }
            }
        });
    }

    private void writeOff(){
        List<String> req=new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            View view = listview1.getAdapter().getView(i, null, null);
            CheckBox cb=view.findViewById(R.id.checked);
            if(cb.isChecked()){
                req.add(datas.get(i).getDeliveryListNO());
            }
        }
        if(req.size()!=0){
            presenter2.DeliveryListDataWriteOff(req,username);
        }else {
            DialogUtil.errorMessageDialog(XSFHRecord1Activity.this,"未选择要冲销的记录");
        }
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
    public void onDataSuccess2(CodeMessageBean data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            queryRecord();
        }else {
            DialogUtil.errorMessageDialog(XSFHRecord1Activity.this,data.getMessage());
        }
    }

    @Override
    public void onDataSuccessPrint(GetDeliveryListInfoJSRepBean3 data) {
        if(data.getCode()==1){
//            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();

            List<GetDeliveryListInfoJSRepBean2> data1 = data.getData();
            for (GetDeliveryListInfoJSRepBean2 data2 : data1) {
                mPrintUtil.printXSFHBill(data2,printHelper);
                printHelper.printBlankLine(80);
            }

        }else {
            DialogUtil.errorMessageDialog(XSFHRecord1Activity.this,data.getMessge());
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
        System.out.println("record:"+position);
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.detail:
                Log.e("detail----->", position + "");
                Intent intent=new Intent(XSFHRecord1Activity.this,XSFHRecord2Activity.class);
                intent.putExtra("DeliveryListNO",datas.get(position).getDeliveryListNO());
                startActivity(intent);
                break;
            default:
                break;
        }
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
