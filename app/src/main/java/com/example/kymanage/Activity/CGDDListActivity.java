package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kymanage.Adapter.CGListAdapter;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailrep;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Req;
import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CG103SHReceivePresenter;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHPrintPresenter;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHQueryPresenter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class CGDDListActivity extends BaseActivity implements BaseView1<GetRecevingDetailreps>, BaseView2<MaterialFlow103Rep>, PrintBaseView<GetParchaseCenterLableReps>, CGListAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //自定义请求码常量
    private static final int REQUEST_CODE = 1;
    //从主菜单传递
    private String username;
    //当前时间
    private String currentdate;
    //选择日期
    //private TextView date;
    //查询
    private ImageView query;
    private EditText cgddh;
    private CGSHQueryPresenter presenter1;
//    private List<GetRecevingDetailrep> datas1;
    private List<GetRecevingDetailrep> list;
    //预收货
//    private Button receive;
    private CG103SHReceivePresenter presenter2;
    //打印
    private ImageView print;
    private List<Long> printList;
    private CGSHPrintPresenter presenter3;
    //记录
    private ImageView record;
    //打印类
    private PrintHelper printHelper=null;
    //listview
    private ListView cglistview;
    //测试数据
    private CGListAdapter adapter;

    private SparseBooleanArray checkedItemPositions;

    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;
    //全选框
//    private CheckBox checkAll;

    //选中收货的index
    private int checkednum;
    //震动
    private Vibrator vibrator;






    @Override
    public int initLayoutId() {
        return R.layout.activity_cgddlist;
    }

    @Override
    public void initview() {
        //全选框
//        checkAll=findViewById(R.id.checkAll);
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        query=findViewById(R.id.query);
        cgddh=findViewById(R.id.cgddh);
        record=findViewById(R.id.record);
        cgddh.setText("4100011743");
        presenter1=new CGSHQueryPresenter();
        presenter1.setView(this);

//        receive=findViewById(R.id.receive);
        presenter2=new CG103SHReceivePresenter();
        presenter2.setView(this);

        print=findViewById(R.id.print);
        presenter3=new CGSHPrintPresenter();
        presenter3.setView(this);

        cglistview=findViewById(R.id.listview1);

        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        //选择日期
        //date=findViewById(R.id.date);
    }

    @Override
    public void initData() {
        //初始化日期为当前日期
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        currentdate=sf.format(date0);
//        date.setText(sf.format(date0));
//        SimpleDateFormat sf2 = new SimpleDateFormat("HH:mm:ss");
        SharedPreferences preferences = CGDDListActivity.this.getSharedPreferences("user", Context.MODE_PRIVATE);

//        datas1=new ArrayList<GetRecevingDetailrep>();
        list=new ArrayList<GetRecevingDetailrep>();
        printList=new ArrayList<Long>();
        for (int i = 0; i < 100; i++) {
            printList.add(0L);
        }
        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
//        //测试数据
//        DemoBean1 rep1=new DemoBean1("ZJ00000001","测试物料1","专有物料","","",10,10);
//        DemoBean1 rep2=new DemoBean1("ZJ00000002","测试物料2","专有物料","","",13,13);
//        DemoBean1 rep3=new DemoBean1("ZJ00000003","测试物料3","专有物料","","",8,8);
//        DemoBean1 rep4=new DemoBean1("ZJ00000004","测试物料4","非专有物料","","",21,21);
//        DemoBean1 rep5=new DemoBean1("ZJ00000005","测试物料5","专有物料","","",3,3);
//        DemoBean1 rep6=new DemoBean1("ZJ00000006","测试物料6","非专有物料","","",10,10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        System.out.println("返回执行码是："+ requestCode);
        switch (requestCode) {  //根据请求码可处理不同活动返回的数据
            case REQUEST_CODE: //返回的请求码
                List<ProductOrderBean> productOrder = (List<ProductOrderBean>)data.getSerializableExtra("productOrder");
                int index = data.getIntExtra("index", 0);
                float allNum = data.getFloatExtra("allNum", 0);
                long AdvanceStorageId = data.getLongExtra("AdvanceStorageId", 0);
                boolean isReceive = data.getBooleanExtra("isReceive",false);
                if(isReceive){
                    //printList.get(index);
                    printList.set(index,AdvanceStorageId);
                    queryList();
                }


                View itmeview=cglistview.getChildAt(index - cglistview.getFirstVisiblePosition());
                EditText et= itmeview.findViewById(R.id.dhsl);
                et.setText(allNum+"");
//                float storage=list.get(index).getInStorageQty()+allNum;
//                list.get(index).setInStorageQty(storage);
//                adapter.notifyDataSetChanged();
                System.out.println("2收到的AdvanceStorageId是："+AdvanceStorageId);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void initLisenter() {
//        checkAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //checkAll.toggle();
//                if(list!=null){
//                    for (int i = 0; i < list.size(); i++) {
//                        View itmeview=cglistview.getChildAt(i - cglistview.getFirstVisiblePosition());
//                        CheckBox cb= itmeview.findViewById(R.id.checked);
//                        cb.setChecked(checkAll.isChecked());
//                    }
//                }
//            }
//        });
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                Intent intent2 = new Intent(CGDDListActivity.this, CGRecordActivity.class);
                intent2.putExtra("username", username);
                startActivity(intent2);
            }
        });
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryList();
            }
        });
//        receive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                checkednum = cglistview.getCheckedItemPosition();
////                receive(checkednum);
//            }
//        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                //当前时间
                Date dateNow = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                currentdate = sf.format(dateNow);

                List<Long> checkedPrintList=new ArrayList<Long>();
                int cbs=0;
//                System.out.println("list.size():"+list.size());
                for (int i = 0; i < list.size(); i++) {
//                    View itmeview=cglistview.getAdapter().getView(i,null,null);
//                    CheckBox cb= itmeview.findViewById(R.id.checked);
                    View itmeview=cglistview.getAdapter().getView(i,null,null);
                    CheckBox cb= itmeview.findViewById(R.id.checked);
//                    CheckBox cb=cglistview.getChildAt(i - cglistview.getFirstVisiblePosition()).findViewById(R.id.checked);
                    //EditText et=itmeview.findViewById(R.id.dhsl);
                    //float num=Float.parseFloat(""+et.getText().toString());
                    //printList.get(i).setReceiveNum(num);
                    if (cb.isChecked()){
                        checkedPrintList.add(printList.get(i));
                        cbs++;
                    }
                }
                System.out.println("收货打印选中数:"+cbs);
                if(cbs==0){
                    Toast.makeText(CGDDListActivity.this, "未选中要打印的标签行", Toast.LENGTH_SHORT).show();
                }else {
                    presenter3.CGSHPrint(checkedPrintList,username,currentdate);
                }
//                Intent intent = new Intent(CGDDListActivity.this, PrintPerviewActivity.class);
//                startActivity(intent);
                //Toast.makeText(CGDDListActivity.this, "正在打印...", Toast.LENGTH_SHORT).show();
            }
        });
//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDateAndTable();
//            }
//        });
    }

    public void receive(int checkednum){
        GetRecevingDetailrep checkedData=list.get(checkednum);
//        if(((checkedData.getMaterialType()).equals("专有物料"))){
        if(checkedData.getMaterialType().equals("专有")){
            Intent intent=new Intent(CGDDListActivity.this,CGDDDialogActivity.class);
            intent.putExtra("materialCode",checkedData.getCode());
            System.out.println(checkedData.getCode()+"|||"+checkedData.getFactory());
//            intent.putExtra("materialCode","LJ4515006377-A01");
            intent.putExtra("factoryNO",checkedData.getFactory());
//            intent.putExtra("factoryNO","2090");
            EditText et=cglistview.getChildAt(checkednum - cglistview.getFirstVisiblePosition()).findViewById(R.id.dhsl);
            String recenumstr=et.getText().toString();
            float num=Float.parseFloat(("0"+recenumstr));
            intent.putExtra("dhsl",num);
            intent.putExtra("index",checkednum);
            intent.putExtra("username",username);
            intent.putExtra("checkedData",(Serializable) checkedData);
            startActivityForResult(intent,REQUEST_CODE);
//            overridePendingTransition(android.R.anim.slide_in_left,0);
        }else {
            List<ProductOrderBean> productOrder=new ArrayList<ProductOrderBean>();
            EditText et=cglistview.getChildAt(checkednum - cglistview.getFirstVisiblePosition()).findViewById(R.id.dhsl);
            String recenumstr=et.getText().toString();
            float num=Float.parseFloat(("0"+recenumstr));
            System.out.println(num);
            productOrder.clear();
            List<MaterialFlow103Req> detail=new ArrayList<MaterialFlow103Req>();
            MaterialFlow103Req req=new MaterialFlow103Req(num,checkedData.getOrderNum(),checkedData.getRow(),checkedData.getCode(),checkedData.getMaterialType(),checkedData.getFactory(),checkedData.getLGFSB(),checkedData.getDescription(),checkedData.getUnit(),checkedData.getRemark(),productOrder);
            detail.add(req);
            presenter2.CG103SHReceive(getCurrentdate(),getCurrentdate(),username,detail);
//            presenter2.CG103SHReceive("2020-01-01",getCurrentdate(),username,num,checkedData.getOrderNum(),checkedData.getRow(),checkedData.getCode(),checkedData.getMaterialType(),checkedData.getFactory(),checkedData.getDescription(),checkedData.getUnit(),checkedData.getRemark(),productOrder);
            //Toast.makeText(CGDDListActivity.this, "采购收货成功", Toast.LENGTH_SHORT).show();
        }
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
                //date.setText(str1+str2+str3);
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
    public void onDataSuccess1(GetRecevingDetailreps data) {
        list=data.getData();
//        System.out.println(data.getStatus().getMessage());
        //System.out.println(list.get(0).toString());
        if(data.getStatus().getCode()==1){
            adapter=new CGListAdapter(CGDDListActivity.this,R.layout.cgddlistitem,list);
            adapter.setOnInnerItemOnClickListener(this);
            // 将适配器上的数据传递给listView
            cglistview.setAdapter(adapter);
            cglistview.setOnItemClickListener(this);
        }
        Toast.makeText(CGDDListActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
//        datas1=data.getData();
    }

    @Override
    public void onDataSuccess2(MaterialFlow103Rep data) {
        Toast.makeText(CGDDListActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        if(data.getStatus().getData()!=null){
            if(data.getStatus().getData().size()>0){
                System.out.println(data.getStatus().getData().size());
                System.out.println(data.getStatus().getData().get(0));
                printList.set(checkednum,data.getStatus().getData().get(0));
            }
        }
        queryList();
    }

    @Override
    public void onDataSuccessPrint(GetParchaseCenterLableReps data) {
//        System.out.println("打印成功？");
        List<GetParchaseCenterLableRep> labels=data.getData();
        Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if(labels!=null){
            if (labels.size()==0){
                printHelper.Step((byte) 0x5f);
            }else {
                for (GetParchaseCenterLableRep label : labels) {
                    Bitmap bm=cb.createImage1(label,tf);
                    printHelper.PrintBitmapAtCenter(bm,384,480);
                    printHelper.printBlankLine(80);
                }
//                printHelper.printBlankLine(40);
                System.out.println("打印标签的数量为"+data.getData().size());
                Toast.makeText(CGDDListActivity.this, "打印标签的数量为"+labels.size(), Toast.LENGTH_SHORT).show();
            }
        }else {
            System.out.println("未打印标签");
        }

    }

    @Override
    public void onFailed(String msg) {
//        System.out.println("打印失败?");
        System.out.println(msg);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.e("整体item----->", i + "");
//        View itmeview=cglistview.getAdapter().getView(i,null,null);
//        CheckBox cb= itmeview.findViewById(R.id.checked);
//        cb.toggle();
//        adapter.getSelect().put(i,cb.isChecked());
//        Log.e("",cb.isChecked()+"");
//        cb.setChecked(true);
    }


    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.receive:
                vibrator.vibrate(30);
                Log.e("内部receive>>", position + "");
                checkednum = position;
                receive(checkednum);
                break;
            default:
                break;
        }
    }
    //时间弹窗
//    private void showtime(){
//        new TimePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT,new TimePickerDialog.OnTimeSetListener() {
//
//            @Override
//            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//
//                String day;
//                if (hourOfDay < 10){
//                    day="0"+hourOfDay;
//                }else {
//                    day=""+hourOfDay;
//                }
//                if (minute < 10){
//                    time.setText(day+":"+"0"+minute);
//                }else {
//                    time.setText(day+":"+minute);
//                }
//            }
//        }, 0, 0, true).show();
//
//    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            //View itme=cglistview.getChildAt(position);

            //CheckableLayout itemlayout=itme.findViewById(R.id.parent_layout);
            //单选
//            for (int i = 0; i < list.size(); i++) {
//                //View itme=cgshlistview.getChildAt(i);
////                View itme=cglistview.getChildAt(i);
//                View itme=cglistview.getChildAt(i - cglistview.getFirstVisiblePosition());
//                if (i==position){
//                    setBackgroundChange(itme, R.drawable.tablebody3);
//                }else {
//                    setBackgroundChange(itme, R.drawable.tablebody4);
//                }
//            }
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
        view.findViewById(R.id.parent_layout).setBackgroundResource(i);
    }
//    public void setBackgroundChangeWithoutRight(View view,int i){
//        view.findViewById(R.id.blank).setBackgroundResource(i);
//    }
    public void setBackgroundChangeWithoutLeft(View view,int i){
        view.findViewById(R.id.checked).setBackgroundResource(i);
    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(CGDDListActivity.this);
        Toast.makeText(CGDDListActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    //查询&&刷新
    private void queryList(){
        String cgddhstr=cgddh.getText().toString();
        if(cgddhstr.equals("")){
            Toast.makeText(CGDDListActivity.this, "请输入采购订单号", Toast.LENGTH_SHORT).show();
        }else {
            presenter1.CGSHQuerydata(cgddhstr);
            Toast.makeText(CGDDListActivity.this, "正在查询...", Toast.LENGTH_SHORT).show();
        }
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
                printHelper.Step((byte) 0x5f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }

}
