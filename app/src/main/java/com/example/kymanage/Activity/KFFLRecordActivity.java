package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.kymanage.Adapter.CGRecordAdapter;
import com.example.kymanage.Adapter.KFFLRecordAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean1;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailBean2;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailRep;
import com.example.kymanage.Beans.GetIssueNoteDetail.GetIssueNoteDetailReq;
import com.example.kymanage.Beans.GetIssueNoteDetail.KFLabelBean;
import com.example.kymanage.Beans.GetIssueRecord.GetIssueRecordRep;
import com.example.kymanage.Beans.GetIssueRecord.GetIssueRecordReps;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordRep;
import com.example.kymanage.Beans.InsertStorageLableRecord.InsertStorageLableRecordReps;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.Presenters.KFPage3.GetIssueNoteDetail2Presenter;
import com.example.kymanage.presenter.Presenters.KFPage4.GetIssueRecordPresenter;
import com.example.kymanage.presenter.Presenters.KFPage4.GetWarehouselabelPresenter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Printer.PrintHelper;

public class KFFLRecordActivity extends BaseActivity implements BaseView1<GetIssueRecordReps>, BaseView3<GetIssueNoteDetailRep> {
    //选择日期
    private TextView date;
    //入库冲销
    private ImageView receive;
    //补打标签
    private ImageView print;
    //listview
    private ListView listview1;
    //
    private List<GetIssueRecordRep> datas;
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

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfflrecord;
    }

    @Override
    public void initview() {
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        print = findViewById(R.id.print);
        listview1 = findViewById(R.id.listview1);

        presenter1=new GetIssueRecordPresenter();
        presenter1.setView(this);

        presenter2=new GetIssueNoteDetail2Presenter();
        presenter2.setView(this);

    }

    @Override
    public void initData() {
        flDatas=new ArrayList<GetIssueNoteDetailReq>();
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        datas=new ArrayList<GetIssueRecordRep>();
        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateAndTable();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(KFFLRecordActivity.this,"入库冲销成功",Toast.LENGTH_SHORT).show();
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                presenter1.GetIssueRecord((str1+str2+str3),username);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onDataSuccess1(GetIssueRecordReps data) {
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
            printHelper.printBlankLine(10);
            String Linestr="--------------------------------------------------------------";
            printHelper.PrintLineInit(24);
            printHelper.PrintLineStringByType(Linestr, 24, PrintHelper.PrintType.Centering, false);
            printHelper.PrintLineEnd();
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
                                printHelper.printBlankLine(40);
                                labelnum++;
                            }

                        }
                    }
                }
            }
        }
        printHelper.printBlankLine(100);
        System.out.println("打印标签的数量为"+labelnum);
        Toast.makeText(KFFLRecordActivity.this, "打印标签的数量为"+labelnum, Toast.LENGTH_SHORT).show();
        //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
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

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.scddh).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.wlms).setBackgroundResource(i);
        view.findViewById(R.id.flsl).setBackgroundResource(i);
        view.findViewById(R.id.flzt).setBackgroundResource(i);
    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(KFFLRecordActivity.this);
        Toast.makeText(KFFLRecordActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }
}
