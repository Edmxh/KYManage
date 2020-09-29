package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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

import com.example.kymanage.Adapter.Print2Record1Adapter;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRep;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeRepBean2;
import com.example.kymanage.Beans.GetDumpRecordNode.GetDumpRecordNodeReqBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRep;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRepBean;
import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordReq;
import com.example.kymanage.Beans.WriteOffMaterialFactoryDump.WriteOffMaterialFactoryDumpReq;
import com.example.kymanage.Beans.WriteOffMaterialFactoryDump.WriteOffMaterialFactoryDumpReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.Presenters.Print2.GetDumpRecordNodePresenter;
import com.example.kymanage.presenter.Presenters.Print2Record1.GetMainDumpRecordPresenter;
import com.example.kymanage.presenter.Presenters.Print2Record1.WriteOffMaterialFactoryDumpPresenter;
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

public class DivertRecord1Activity extends BaseActivity implements BaseView1<GetMainDumpRecordRep>, BaseView2<GetDumpRecordNodeRep>, BaseView3<StatusRespBean>, Print2Record1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //选择日期
    private TextView date;
    private ListView listView1;
    private Print2Record1Adapter adapter;
    private List<GetMainDumpRecordRepBean> datas;

    private GetMainDumpRecordPresenter presenter1;

    //跨工厂配送单打印
    private ImageView print;
    private GetDumpRecordNodePresenter presenter2;
    private List<GetDumpRecordNodeReqBean> printDatas;

    //301转储冲销
    private ImageView receive;
    private WriteOffMaterialFactoryDumpPresenter presenter3;
    private List<WriteOffMaterialFactoryDumpReqBean> cxDatas;

    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    //username
    private String username;
    //震动
    private Vibrator vibrator;

    private mPrintUtil mPrintUtil;

    //筛选条件
    private TextView zcdh;
    private TextView wlbm;
    private TextView xsddh;
    private TextView xqgc;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;

    @Override
    public int initLayoutId() {
        return R.layout.activity_divert_record1;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        print = findViewById(R.id.print);
        receive = findViewById(R.id.receive);
        listView1 = findViewById(R.id.listview1);

        //筛选条件
        zcdh = findViewById(R.id.zcdh);
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        xqgc = findViewById(R.id.xqgc);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        queryself = findViewById(R.id.queryself);


        presenter1=new GetMainDumpRecordPresenter();
        presenter1.setView(this);

        presenter2=new GetDumpRecordNodePresenter();
        presenter2.setView(this);

        presenter3=new WriteOffMaterialFactoryDumpPresenter();
        presenter3.setView(this);

    }

    @Override
    public void initData() {
        mPrintUtil=new mPrintUtil();
        cxDatas=new ArrayList<WriteOffMaterialFactoryDumpReqBean>();
        printDatas=new ArrayList<GetDumpRecordNodeReqBean>();
        datas=new ArrayList<GetMainDumpRecordRepBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋

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
//                if(queryself.isChecked()){
//                    queryall=false;
//                }else {
//                    queryall=true;
//                }
                queryRecord();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(DivertRecord1Activity.this);

            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                printDatas.clear();
                if(datas!=null){
                    for (int i = 0; i < datas.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        View itmeview=listView1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            GetDumpRecordNodeReqBean printData=new GetDumpRecordNodeReqBean(datas.get(i).getID());
                            printDatas.add(printData);
                        }
                    }
                }
                System.out.println("打印选中数:"+printDatas.size());
                //当前时间
                Date dateNow = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String currentdate = sf.format(dateNow);
                if(printDatas.size()==0){
                    Toast.makeText(DivertRecord1Activity.this, "未选中要打印的标签行", Toast.LENGTH_SHORT).show();
                }else {
                    presenter2.GetDumpRecordNode(printDatas);
                }
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
    public void onDataSuccess2(GetDumpRecordNodeRep data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        List<GetDumpRecordNodeRepBean2> data1 = data.getData();
        //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            printHelper.printBlankLine(10);
            for (GetDumpRecordNodeRepBean2 data2 : data1) {
//                Bitmap bm=cb.createImage10(data2,tf);
//                printHelper.PrintBitmapAtCenter(bm,384,450+55*(data2.getData().size()));
//                printHelper.printBlankLine(40);
                mPrintUtil.printKGCBill(data2,printHelper);
                printHelper.printBlankLine(80);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDataSuccess3(StatusRespBean data) {
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            queryRecord();
        }else {
            DialogUtil.errorMessageDialog(DivertRecord1Activity.this,data.getStatus().getMessage());
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
                queryRecord();

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
                intent.putExtra("id",datas.get(position).getID());
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(DivertRecord1Activity.this);
//        Toast.makeText(DivertRecord1Activity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    private void queryRecord(){
        String queryall;
        if(queryself.isChecked()){
            queryall=username;
        }else {
            queryall="";
        }
        GetMainDumpRecordReq req=new GetMainDumpRecordReq(date.getText().toString(),queryall,zcdh.getText().toString(),xsddh.getText().toString(),wlbm.getText().toString(),xqgc.getText().toString());
        presenter1.GetMainDumpRecord(req);
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
                        cxDatas.clear();
                        if(datas!=null){
                            for (int i = 0; i < datas.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                                View itmeview=listView1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                if(cb.isChecked()){
                                    WriteOffMaterialFactoryDumpReqBean cxData=new WriteOffMaterialFactoryDumpReqBean(datas.get(i).getID(),datas.get(i).getDumpNum());
                                    cxDatas.add(cxData);
                                }
                            }
                            if(cxDatas.size()==0){
                                Toast.makeText(DivertRecord1Activity.this, "未选中要冲销的记录", Toast.LENGTH_SHORT).show();
                            }else {
                                WriteOffMaterialFactoryDumpReq cxreq=new WriteOffMaterialFactoryDumpReq(cxDatas,username);
                                presenter3.WriteOffMaterialFactoryDump(cxreq);
                            }
                        }
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
