package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.WXCPSHRecordAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRep;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSRepBean;
import com.example.kymanage.Beans.GetOutsourceFinProLableJS.GetOutsourceFinProLableJSReqBean;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRep;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRepBean;
import com.example.kymanage.Beans.OutsoureFinProductWriteOffJS.OutsoureFinProductWriteOffJSReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.Presenters.WXPage2.GetOutsourceFinProLableJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2Record.OutsoureFinProductWriteOffJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2Record.GetOutsoureFinProductDataJSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXCPSHRecordActivity extends BaseActivity implements BaseView1<GetOutsoureFinProductDataJSRep>, BaseView2<CodeMessageBean>, BaseView3<GetOutsourceFinProLableJSRep> {
    //选择日期
    private TextView date;
    private List<GetOutsoureFinProductDataJSRepBean> data1;
    private GetOutsoureFinProductDataJSPresenter presenter1;
    private WXCPSHRecordAdapter adapter;
//入库冲销
    private ImageView receive;
    private OutsoureFinProductWriteOffJSPresenter presenter2;
    //打印
    private ImageView print;
    private GetOutsourceFinProLableJSPresenter presenter3;
    private  List<GetOutsourceFinProLableJSReqBean> printList;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //listview
    private ListView listview1;
    //
    private String username;
    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxcpshrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        print = findViewById(R.id.print);
        listview1 = findViewById(R.id.listview1);

        presenter1=new GetOutsoureFinProductDataJSPresenter();
        presenter1.setView(this);

        presenter2=new OutsoureFinProductWriteOffJSPresenter();
        presenter2.setView(this);

        presenter3=new GetOutsourceFinProLableJSPresenter();
        presenter3.setView(this);
    }

    @Override
    public void initData() {
        printList=new ArrayList<GetOutsourceFinProLableJSReqBean>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
//        System.out.println("username:"+username);

        data1=new ArrayList<GetOutsoureFinProductDataJSRepBean>();

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
                vibrator.vibrate(30);
                showdate();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<OutsoureFinProductWriteOffJSReqBean> idslist=new ArrayList<OutsoureFinProductWriteOffJSReqBean>();
                if(data1!=null){
                    for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        GetOutsoureFinProductDataJSRepBean currData = data1.get(i);
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            OutsoureFinProductWriteOffJSReqBean idreq=new OutsoureFinProductWriteOffJSReqBean(currData.getID(),currData.getOrderType(),currData.getAdvanceStorageId());
                            idslist.add(idreq);
                        }
                    }
                }
//                WriteOffProStorageRecordReq req=new WriteOffProStorageRecordReq(username,idlist);
//                System.out.println("冲销选中数:"+idlist.size());
                presenter2.OutsoureFinProductWriteOffJS(username,getCurrentdate(),idslist);
                //Toast.makeText(CGRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                try {
                    List<GetOutsourceFinProLableJSReqBean> checkedPrintList=new ArrayList<GetOutsourceFinProLableJSReqBean>();
                    for (int i = 0; i < data1.size(); i++) {
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            checkedPrintList.add(printList.get(i));
                        }
                    }
                    presenter3.GetOutsourceFinProLableJS(username,getCurrentdate2(),checkedPrintList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

                presenter1.GetOutsoureFinProductDataJS((str1+str2+str3),username);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    @Override
    public void onDataSuccess1(GetOutsoureFinProductDataJSRep data) {
        try {
            data1 = data.getData();
            System.out.println(data1.size());
            //表格适配数据
            adapter=new WXCPSHRecordAdapter(WXCPSHRecordActivity.this, R.layout.wxcpshrecorditem,data1);
            listview1.setAdapter(adapter);
            for (GetOutsoureFinProductDataJSRepBean data2 : data1) {
                GetOutsourceFinProLableJSReqBean printBean=new GetOutsourceFinProLableJSReqBean(data2.getID(),data2.getOrderType(),data2.getAdvanceStorageId());
                printList.add(printBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        presenter1.GetOutsoureFinProductDataJS(date.getText().toString(),username);
    }

    @Override
    public void onDataSuccess3(GetOutsourceFinProLableJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            List<GetOutsourceFinProLableJSRepBean> beans = data.getData();
            for (GetOutsourceFinProLableJSRepBean bean : beans) {
                printHelper.printBlankLine(10);
                Bitmap bm=cb.createImage7(bean,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(40);
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(WXCPSHRecordActivity.this);
        Toast.makeText(WXCPSHRecordActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }
}
