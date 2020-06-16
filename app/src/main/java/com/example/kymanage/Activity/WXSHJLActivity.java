package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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
import android.widget.Toast;

import com.example.kymanage.Adapter.CGRecordAdapter;
import com.example.kymanage.Adapter.WXRecordAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordRep;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReps;
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordReq;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRep;
import com.example.kymanage.Beans.GetFinProStorageRecordNote.GetFinProStorageRecordNoteRepBean;
import com.example.kymanage.Beans.StatusBean;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReq;
import com.example.kymanage.Beans.WriteOffProStorageRecord.WriteOffProStorageRecordReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.Presenters.WXPage3Record.GetFinProStorageRecordNotePresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Record.GetFinProStorageRecordPresenter;
import com.example.kymanage.presenter.Presenters.WXPage3Record.WriteOffProStorageRecordPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Printer.PrintHelper;

public class WXSHJLActivity extends BaseActivity implements BaseView1<GetFinProStorageRecordReps>, BaseView2<StatusRespBean>, BaseView3<GetFinProStorageRecordNoteRep> {
    //选择日期
    private TextView date;
    private List<GetFinProStorageRecordRep> data1;
    //入库冲销
    private ImageView receive;
    private WriteOffProStorageRecordPresenter presenter2;
    //打印
    private ImageView print;
    private GetFinProStorageRecordNotePresenter presenter3;
    //listview
    private ListView listview1;
    //
    private GetFinProStorageRecordPresenter presenter1;
    private WXRecordAdapter adapter;

    private String username;
    //震动
    private Vibrator vibrator;

    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

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

        presenter1=new GetFinProStorageRecordPresenter();
        presenter1.setView(this);

        presenter2=new WriteOffProStorageRecordPresenter();
        presenter2.setView(this);

        presenter3=new GetFinProStorageRecordNotePresenter();
        presenter3.setView(this);
    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
//        System.out.println("username:"+username);

        data1=new ArrayList<GetFinProStorageRecordRep>();

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdate();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<WriteOffProStorageRecordReqBean> idlist=new ArrayList<WriteOffProStorageRecordReqBean>();
                if(data1!=null){
                    for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            WriteOffProStorageRecordReqBean idreq=new WriteOffProStorageRecordReqBean((""+data1.get(i).getFinProEnterID()));
                            idlist.add(idreq);
                        }
                    }
                }
                WriteOffProStorageRecordReq req=new WriteOffProStorageRecordReq(username,idlist);
                System.out.println("冲销选中数:"+idlist.size());
                presenter2.WriteOffProStorageRecord(req);
                //Toast.makeText(CGRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<WriteOffProStorageRecordReqBean> idlist=new ArrayList<WriteOffProStorageRecordReqBean>();
                if(data1!=null){
                    for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            WriteOffProStorageRecordReqBean idreq=new WriteOffProStorageRecordReqBean((""+data1.get(i).getFinProEnterID()));
                            idlist.add(idreq);
                        }
                    }
                }
                System.out.println("冲销选中数:"+idlist.size());
                presenter3.GetFinProStorageRecordNote(idlist);
                //Toast.makeText(CGRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
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

                GetFinProStorageRecordReq req=new GetFinProStorageRecordReq((str1+str2+str3),username);
//                GetFinProStorageRecordReq req=new GetFinProStorageRecordReq("2020-05-31","kzheng");
                presenter1.GetFinProStorageRecord(req);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    @Override
    public void onDataSuccess1(GetFinProStorageRecordReps data) {
        try {
            System.out.println(data.getStatus().getMessage());
            data1 = data.getData();
            System.out.println(data1.size());
            //表格适配数据
            adapter=new WXRecordAdapter(WXSHJLActivity.this, R.layout.wxrecorditem,data1);
            listview1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(StatusRespBean data) {
        Toast.makeText(WXSHJLActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        GetFinProStorageRecordReq req=new GetFinProStorageRecordReq(date.getText().toString(),username);
//                GetFinProStorageRecordReq req=new GetFinProStorageRecordReq("2020-05-31","kzheng");
        presenter1.GetFinProStorageRecord(req);
    }

    @Override
    public void onDataSuccess3(GetFinProStorageRecordNoteRep data) {
        List<GetFinProStorageRecordNoteRepBean> labels=data.getData();
        //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if(labels!=null){
            printHelper.printBlankLine(10);
            for (GetFinProStorageRecordNoteRepBean label : labels) {
                Bitmap bm=cb.createImage6(label,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(40);
            }
            printHelper.printBlankLine(80);
            System.out.println("打印标签的数量为"+data.getData().size());
            Toast.makeText(WXSHJLActivity.this, "打印标签的数量为"+labels.size(), Toast.LENGTH_SHORT).show();
        }else {
            System.out.println("未打印标签");
        }

        Toast.makeText(WXSHJLActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {

    }

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXSHJLActivity.this);
        Toast.makeText(WXSHJLActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }
}
