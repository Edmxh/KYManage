package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.KFFLRecordAdapter;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean1;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean2;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.KFLabelBean;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordRep;
import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordReps;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReq;
import com.example.kymanage.Beans.WriteOffProductOrderIssue.WriteOffProductOrderIssueReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.InterfaceView.BaseView4;
import com.example.kymanage.presenter.Presenters.KFPage3.GetIssueNoteDetail2Presenter;
import com.example.kymanage.presenter.Presenters.KFPage3Record.GetIssueNoteDetail4Presenter;
import com.example.kymanage.presenter.Presenters.KFPage3Record.WriteOffProductOrderIssuePresenter;
import com.example.kymanage.presenter.Presenters.KFPage4.GetIssueRecordPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class KFFLRecordActivity extends BaseActivity implements BaseView1<GetIssueDetailRecordReps>, BaseView3<GetIssueNoteDetailRep>, BaseView2<StatusRespBean>, BaseView4<GetIssueNoteDetailRep> {
    //选择日期
    private TextView date;
    //入库冲销
    private ImageView receive;
    private WriteOffProductOrderIssuePresenter presenter3;
    //补打发料单
    private ImageView print1;
    private GetIssueNoteDetail4Presenter presenter4;
    //补打标签
    private ImageView print2;
    //listview
    private ListView listview1;
    //
    private List<GetIssueDetailRecordRep> datas;
    private KFFLRecordAdapter adapter;
    //获取记录
    private GetIssueRecordPresenter presenter1;
    //补打标签
    private GetIssueNoteDetail2Presenter presenter2;
    private List<GetIssueNoteDetailReq> flDatas;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //打印类
    private PrintHelper printHelper=null;
    private String username;

    //震动
    private Vibrator vibrator;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfflrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        print1 = findViewById(R.id.print1);
        print2 = findViewById(R.id.print2);
        listview1 = findViewById(R.id.listview1);

        presenter1=new GetIssueRecordPresenter();
        presenter1.setView(this);

        presenter2=new GetIssueNoteDetail2Presenter();
        presenter2.setView(this);

        presenter3=new WriteOffProductOrderIssuePresenter();
        presenter3.setView(this);

        presenter4=new GetIssueNoteDetail4Presenter();
        presenter4.setView(this);

    }

    @Override
    public void initData() {
        flDatas=new ArrayList<GetIssueNoteDetailReq>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        datas=new ArrayList<GetIssueDetailRecordRep>();
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
                showDateAndTable();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<WriteOffProductOrderIssueReqBean> cxDatas=new ArrayList<WriteOffProductOrderIssueReqBean>();
                for (int i = 0; i < datas.size(); i++) {
                    View itmeview=listview1.getAdapter().getView(i,null,null);
                    CheckBox cb= itmeview.findViewById(R.id.checked);
                    if (cb.isChecked()){
                        WriteOffProductOrderIssueReqBean cxData=new WriteOffProductOrderIssueReqBean((""+datas.get(i).getIssueId()));
                        cxDatas.add(cxData);
                    }
                }
                WriteOffProductOrderIssueReq cxReq=new WriteOffProductOrderIssueReq(getCurrentdate(),cxDatas);
                presenter3.WriteOffProductOrderIssue(cxReq);
//                Toast.makeText(KFFLRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });
        print1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                flDatas.clear();
                for (int i = 0; i < datas.size(); i++) {
                    View itmeview=listview1.getAdapter().getView(i,null,null);
                    CheckBox cb= itmeview.findViewById(R.id.checked);
                    if (cb.isChecked()){
                        GetIssueNoteDetailReq flData=new GetIssueNoteDetailReq((""+datas.get(i).getIssueId()));
                        flDatas.add(flData);
                    }
                }
                presenter4.GetIssueNoteDetail2(flDatas);
                //Toast.makeText(KFFLRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });
        print2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                flDatas.clear();
                for (int i = 0; i < datas.size(); i++) {
                    View itmeview=listview1.getAdapter().getView(i,null,null);
                    CheckBox cb= itmeview.findViewById(R.id.checked);
                    if (cb.isChecked()){
                        GetIssueNoteDetailReq flData=new GetIssueNoteDetailReq((""+datas.get(i).getIssueId()));
                        flDatas.add(flData);
                    }
                }
                presenter2.GetIssueNoteDetail2(flDatas);
                //Toast.makeText(KFFLRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
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
                GetIssueDetailRecordReq req=new GetIssueDetailRecordReq(username, (str1+str2+str3));
                presenter1.GetIssueRecord(req);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onDataSuccess1(GetIssueDetailRecordReps data) {
        datas=data.getData();
        //表格
        adapter=new KFFLRecordAdapter(KFFLRecordActivity.this, R.layout.kfflrecorditem,data.getData());
        listview1.setAdapter(adapter);
        listview1.setOnItemClickListener(new ListViewItemOnClick());
    }

    @Override
    public void onDataSuccess3(GetIssueNoteDetailRep data) {
        Toast.makeText(KFFLRecordActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        List<GetIssueNoteDetailBean2> data1 = data.getData();

        int labelnum=0;
        if(data1!=null){
            if(data1.size()>0){
//                System.out.println();
                for (int i = 0; i < data1.size(); i++) {
                    GetIssueNoteDetailBean2 data2 = data1.get(i);
                    List<GetIssueNoteDetailBean1> data3 = data2.getData();
                    if(data3!=null){
                        if(data3.size()>0){
                            for (GetIssueNoteDetailBean1 data4 : data3) {
                                KFLabelBean labelBean=new KFLabelBean(data2.getMaterialDesc(), data2.getMarketOrderNO(),data4 ,data2.getProductOrderNO(), data2.getMaterialCode(), data2.getMarketOrderRow());
                                Bitmap bm=cb.createImage2(labelBean,tf);
                                printHelper.PrintBitmapAtCenter(bm,384,480);
                                printHelper.printBlankLine(80);
                                labelnum++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("打印标签的数量为"+labelnum);
    }

    @Override
    public void onDataSuccess2(StatusRespBean data) {
        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        GetIssueDetailRecordReq req=new GetIssueDetailRecordReq(username, date.getText().toString());
        presenter1.GetIssueRecord(req);
    }

    @Override
    public void onDataSuccess4(GetIssueNoteDetailRep data) {
        Toast.makeText(KFFLRecordActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        List<GetIssueNoteDetailBean2> data1 = data.getData();
        if(data1!=null){
            if(data1.size()>0){
                Bitmap bm=cb.createImage3(data,tf);//创建发料单

                int picHeight = 100;//生成图片的高度，基础100+heightone85+heighttwo55+bottom 30
                List<GetIssueNoteDetailBean2> orders = data.getData();
                for (GetIssueNoteDetailBean2 order : orders) {
                    picHeight+=85;
                    List<GetIssueNoteDetailBean1> materials = order.getData();
                    for (GetIssueNoteDetailBean1 material : materials) {
                        picHeight+=55;
                    }
                }
                picHeight+=30;
                printHelper.PrintBitmapAtCenter(bm,384,picHeight);
                printHelper.printBlankLine(80);
//                hasFL=true;
            }
        }
    }

    @Override
    public void onFailed(String msg) {

    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            View itme=listview1.getChildAt(position);
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

//    public void setBackgroundChange(View view,int i){
//        view.findViewById(R.id.xh).setBackgroundResource(i);
//        view.findViewById(R.id.scddh).setBackgroundResource(i);
//        view.findViewById(R.id.wlbm).setBackgroundResource(i);
//        view.findViewById(R.id.wlms).setBackgroundResource(i);
//        view.findViewById(R.id.flsl).setBackgroundResource(i);
//        view.findViewById(R.id.flzt).setBackgroundResource(i);
//    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(KFFLRecordActivity.this);
        Toast.makeText(KFFLRecordActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
    }

    @Override
    public boolean onKeyDown (int keyCode, KeyEvent event) {
        // 获取手机当前音量值
//        int i = getCurrentRingValue ();
        switch (keyCode) {
            // 音量减小
            case KeyEvent.KEYCODE_VOLUME_DOWN:
//                Toast.makeText (CGDDListActivity.this, "上上上", Toast.LENGTH_SHORT).show ();
                // 音量减小时应该执行的功能代码
                return true;
            // 音量增大
            case KeyEvent.KEYCODE_VOLUME_UP:
//                Toast.makeText (CGDDListActivity.this, "下下下", Toast.LENGTH_SHORT).show ();
                // 音量增大时应该执行的功能代码
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }
}
