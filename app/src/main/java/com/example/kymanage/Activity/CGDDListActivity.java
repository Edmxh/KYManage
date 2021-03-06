package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.CGListAdapter;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailrep;
import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailreps;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103Rep;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103RepStatus;
import com.example.kymanage.Beans.MaterialFlow103.MaterialFlow103ReqBean;
import com.example.kymanage.Beans.MaterialFlow103.ProductOrderBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CG103SHReceivePresenter;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHPrintPresenter;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHQueryPresenter;
import com.example.kymanage.utils.DialogUtil;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class CGDDListActivity extends BaseActivity implements BaseView1<GetRecevingDetailreps>, BaseView2<MaterialFlow103RepStatus>, PrintBaseView<GetParchaseCenterLableReps>, CGListAdapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
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
//    private ImageView print;
    private List<Long> printList;
    private CGSHPrintPresenter presenter3;
    //记录
//    private ImageView record;
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

    //扫描相关
    private ImageView scan;
    private String m_Broadcastname="com.barcode.sendBroadcast";
//    private String m_Broadcastname2="com.barcode.sendBroadcast2";
    private MyCodeReceiver receiver = new MyCodeReceiver();
    //扫到的string
    private String scanString;

    //选中收货的index
    private int checkednum;
    //震动
    private Vibrator vibrator;

    private ImageView menupoint;
    PopupMenu popup = null;

    //重复打印
    GetParchaseCenterLableReps againPrint=new GetParchaseCenterLableReps();
    boolean isAgain=false;






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
//        record=findViewById(R.id.record);
        menupoint=findViewById(R.id.menupoint);
//        cgddh.setText("4100011743");
        presenter1=new CGSHQueryPresenter();
        presenter1.setView(this);

//        receive=findViewById(R.id.receive);
        presenter2=new CG103SHReceivePresenter();
        presenter2.setView(this);

//        print=findViewById(R.id.print);
        scan=findViewById(R.id.scan);
        presenter3=new CGSHPrintPresenter();
        presenter3.setView(this);

        cglistview=findViewById(R.id.listview1);

        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        System.out.println(getCurrentdate());
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

        cb=new CreateBitmap();
        //初始化打印类
//        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
//        tf = Typeface.createFromAsset(mgr, "fonts/STXIHEI.TTF");//细黑
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
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                scan();

            }
        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);
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
//        print.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                vibrator.vibrate(30);
//                //当前时间
//                Date dateNow = new Date();
//                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                currentdate = sf.format(dateNow);
//
//                List<Long> checkedPrintList=new ArrayList<Long>();
//                int cbs=0;
////                System.out.println("list.size():"+list.size());
//                for (int i = 0; i < list.size(); i++) {
////                    View itmeview=cglistview.getAdapter().getView(i,null,null);
////                    CheckBox cb= itmeview.findViewById(R.id.checked);
//                    View itmeview=cglistview.getAdapter().getView(i,null,null);
//                    CheckBox cb= itmeview.findViewById(R.id.checked);
////                    CheckBox cb=cglistview.getChildAt(i - cglistview.getFirstVisiblePosition()).findViewById(R.id.checked);
//                    //EditText et=itmeview.findViewById(R.id.dhsl);
//                    //float num=Float.parseFloat(""+et.getText().toString());
//                    //printList.get(i).setReceiveNum(num);
//                    if (cb.isChecked()){
//                        checkedPrintList.add(printList.get(i));
//                        cbs++;
//                    }
//                }
//                System.out.println("收货打印选中数:"+cbs);
//                if(cbs==0){
//                    Toast.makeText(CGDDListActivity.this, "未选中要打印的标签行", Toast.LENGTH_SHORT).show();
//
//                }else {
//                    presenter3.CGSHPrint(checkedPrintList,username,currentdate);
//                }
////                Intent intent = new Intent(CGDDListActivity.this, PrintPerviewActivity.class);
////                startActivity(intent);
//                //Toast.makeText(CGDDListActivity.this, "正在打印...", Toast.LENGTH_SHORT).show();
//            }
//        });
//        date.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDateAndTable();
//            }
//        });
    }

    public void receive(){
        List<MaterialFlow103ReqBean> detail=new ArrayList<MaterialFlow103ReqBean>();
        for (int i = 0; i < list.size(); i++) {
            GetRecevingDetailrep currentData = list.get(i);
            View itmeview=cglistview.getAdapter().getView(i,null,null);
            EditText et=itmeview.findViewById(R.id.dhsl);
            CheckBox cb= itmeview.findViewById(R.id.checked);
            CheckBox cb1= itmeview.findViewById(R.id.checked1);

            if(cb.isChecked()){
                String recenumstr=et.getText().toString();
                float num=Float.parseFloat(("0"+recenumstr));
                MaterialFlow103ReqBean req=new MaterialFlow103ReqBean(currentData.getOrderNum(), currentData.getRow(), currentData.getFactory(), currentData.getCode(), currentData.getMaterialType(), currentData.getDescription(), num, currentData.getUnit(), currentData.getRemark(), cb1.isChecked(), currentData.getLGFSB(),currentData.getLGPBE(),currentData.getLOGGR(),currentData.getDemand(),currentData.getInStorageQty());
                detail.add(req);
            }
        }
        presenter2.CG103SHReceive(getCurrentdate(),getCurrentdate(),username,detail);
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
        if(data.getStatus().getCode()==1){
            list=data.getData();
            adapter=new CGListAdapter(CGDDListActivity.this,R.layout.cgddlistitem,list);
            adapter.setOnInnerItemOnClickListener(this);
            // 将适配器上的数据传递给listView
            cglistview.setAdapter(adapter);
            cglistview.setOnItemClickListener(this);
            Toast.makeText(CGDDListActivity.this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            DialogUtil.errorMessageDialog(CGDDListActivity.this,data.getStatus().getMessage());
        }
    }

    @Override
    public void onDataSuccess2(MaterialFlow103RepStatus data) {
        LoadingBar.dialog(CGDDListActivity.this).setFactoryFromResource(R.layout.layout_custom1).cancel();
        if(data.getCode()==1){
            try {
                printList.clear();
                Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                for (Long aLong : data.getData()) {
                    printList.add(aLong);
                }
                queryList();
                //当前时间
                Date dateNow = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                currentdate = sf.format(dateNow);
                //收货成功自动打印
                isAgain=false;
                presenter3.CGSHPrint(printList,username,currentdate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            DialogUtil.errorMessageDialog(CGDDListActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccessPrint(GetParchaseCenterLableReps data) {
        againPrint=data;
        if(data.getCode()==1){
            List<GetParchaseCenterLableRep> labels=data.getData();
            Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
            if(labels!=null){
                for (GetParchaseCenterLableRep label : labels) {
                    if(label.isSeparateLabel()){
                        int labelNum= (int) label.getNum();
                        for (int i = 0; i <labelNum ; i++) {
                            label.setNum(1);
                            Bitmap bm=cb.createImage1(label,(i+1),tf);
                            printHelper.PrintBitmapAtCenter(bm,384,480);
                            printHelper.printBlankLine(81);
                        }
                    }else {
                        Bitmap bm=cb.createImage1(label,1,tf);
                        printHelper.PrintBitmapAtCenter(bm,384,480);
                        printHelper.printBlankLine(81);
                    }
                }
//                printHelper.printBlankLine(40);
                System.out.println("打印标签的数量为"+data.getData().size());
//                Toast.makeText(CGDDListActivity.this, "打印标签的数量为"+labels.size(), Toast.LENGTH_SHORT).show();
            }else {
                System.out.println("未打印标签");
            }
        }else {
            if(!isAgain){
                DialogUtil.errorMessageDialog(CGDDListActivity.this,data.getMessage());
            }

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
//                Log.e("内部receive>>", position + "");
//                checkednum = position;
//                receive();
                break;
            default:
                break;
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
        printHelper.Open(getApplicationContext());
//        Toast.makeText(CGDDListActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
                printHelper.GoToNextPage();
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

    //扫描操作
    public void scan(){
        Intent intent = new Intent();
        intent.setAction("com.barcode.sendBroadcastScan");
        sendBroadcast(intent);
    }
    //注册广播
    public void registerBroadcast() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(m_Broadcastname);
//        intentFilter.addAction(m_Broadcastname2);
//        Toast.makeText(KFFLActivity.this, "扫描注册初始化", Toast.LENGTH_SHORT).show();
        registerReceiver(receiver, intentFilter);
    }
    //接收类
    public class MyCodeReceiver extends BroadcastReceiver
    {
        private static final String TAG = "MycodeReceiver";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(m_Broadcastname)) {
                String str = intent.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    //tv.setText(str);
                    scanString=str;
                    cgddh.setText(scanString);
                }else {
                    Toast.makeText(CGDDListActivity.this, "扫描结果为空", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        printHelper.Close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
        initPrinter();
    }


    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.cgmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.receive:
                                vibrator.vibrate(30);
                                isAgain=false;
                                if(list.size()==0){
                                    Toast.makeText(CGDDListActivity.this, "未查出要收货的物料", Toast.LENGTH_SHORT).show();
                                }else {
                                    receive();
                                    LoadingBar.dialog(CGDDListActivity.this).setFactoryFromResource(R.layout.layout_custom1).show();
                                }
                                break;
                            case R.id.print:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                isAgain=true;
                                onDataSuccessPrint(againPrint);

                                break;
//                            case R.id.exit:
//                                vibrator.vibrate(30);
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                            case R.id.record:
                                vibrator.vibrate(30);
                                // 隐藏该对话框
                                Intent intent2 = new Intent(CGDDListActivity.this, CGRecordActivity.class);
                                intent2.putExtra("username", username);
                                startActivity(intent2);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(CGDDListActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

}
