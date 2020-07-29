package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.CGRecordAdapter;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetLableRecords.GetLableRecordsReps;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableRep;
import com.example.kymanage.Beans.GetParchaseCenterLable.GetParchaseCenterLableReps;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordRep;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordReps;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.CGPage1.CGSHPrintPresenter;
import com.example.kymanage.presenter.Presenters.CGPage2.CGSHRecordPresenter;
import com.example.kymanage.presenter.Presenters.YRKCX103Presenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class CGRecordActivity extends BaseActivity implements BaseView1<StatusRespBean>, BaseView2<PurchaseCenterRecordReps>, PrintBaseView<GetParchaseCenterLableReps> {
    //选择日期
    private TextView date;
    //筛选条件
    private TextView wlbm;
    private TextView cgddh;
    private ImageView query;
    private Button reset;
    //入库冲销
//    private ImageView receive;
    //listview
    private ListView listview1;
    //测试数据
    private List<PurchaseCenterRecordRep> datas;
    private CGRecordAdapter adapter;

    //103预入库冲销
    private YRKCX103Presenter presenter103;
    //查询收货记录
    private CGSHRecordPresenter presenter2;

    //打印
//    private ImageView print;
    private CGSHPrintPresenter presenter3;
    //打印类
    private PrintHelper printHelper=null;
    //标签生成器
    private CreateBitmap cb;
    //自定义字体
    private Typeface tf;

    //传递的值
    private  String username;
    //震动
    private Vibrator vibrator;

    private ImageView menupoint;
    PopupMenu popup = null;

    private CheckBox queryself;
    private boolean queryall=true;
    @Override
    public int initLayoutId() {
        return R.layout.activity_cgrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        wlbm = findViewById(R.id.wlbm);
        cgddh = findViewById(R.id.cgddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
//        receive = findViewById(R.id.receive);
//        print = findViewById(R.id.print);
        menupoint = findViewById(R.id.menupoint);
        listview1 = findViewById(R.id.listview1);
        queryself = findViewById(R.id.queryself);

        presenter103=new YRKCX103Presenter();
        presenter103.setView(this);

        presenter2=new CGSHRecordPresenter();
        presenter2.setView(this);

        presenter3=new CGSHPrintPresenter();
        presenter3.setView(this);


    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        System.out.println("---"+username+"---");
        datas=new ArrayList<PurchaseCenterRecordRep>();
        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();
        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋
//        tf = Typeface.createFromAsset(mgr, "fonts/STXIHEI.TTF");//细黑

//        onPopupButtonClick(menupoint);

        //初始今天记录
//        date.setText(getCurrentdate());
//        presenter2.CGSHRecord(date.getText().toString(),username);
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
//                System.out.println("未选择日期时："+date.getText().toString());
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
                presenter2.CGSHRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),queryall);
            }
        });
        menupoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                onPopupButtonClick(menupoint);
            }
        });
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.cgrecordmenu, popup.getMenu());
        // 为popup菜单的菜单项单击事件绑定事件监听器
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.print:
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                List<Long> AvanceStorageIds=new ArrayList<Long>();
                                if(datas!=null){
                                    for (int i = 0; i < datas.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                                        View itmeview=listview1.getAdapter().getView(i,null,null);
                                        CheckBox cb= itmeview.findViewById(R.id.checked);
                                        if(cb.isChecked()){
                                            AvanceStorageIds.add(datas.get(i).getAdvanceStorageId());
                                        }
                                    }
                                }
                                System.out.println("打印选中数:"+AvanceStorageIds.size());
                                //当前时间
                                Date dateNow = new Date();
                                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                String currentdate = sf.format(dateNow);
                                if(AvanceStorageIds.size()==0){
                                    Toast.makeText(CGRecordActivity.this, "未选中要打印的标签行", Toast.LENGTH_SHORT).show();
                                }else {
//                                    AvanceStorageIds.clear();
//                                    AvanceStorageIds.add(1562L);
                                    presenter3.CGSHPrint(AvanceStorageIds,username,currentdate);
                                }
                                break;
                            case R.id.exit:
                                vibrator.vibrate(30);
                                // 隐藏该对话框
                                popup.dismiss();
                                break;
                            case R.id.receive:
                                vibrator.vibrate(30);
                                // 隐藏该对话框
                                vibrator.vibrate(30);
                                List<Long> intlist=new ArrayList<Long>();
                                if(datas!=null){
                                    for (int i = 0; i < datas.size(); i++) {
                                        View itmeview=listview1.getAdapter().getView(i,null,null);
                                        CheckBox cb= itmeview.findViewById(R.id.checked);
                                        if(cb.isChecked()){
                                            intlist.add(datas.get(i).getAdvanceStorageId());
                                        }
                                    }
                                }
                                System.out.println("冲销选中数:"+intlist.size());
                                LoadingBar.dialog(CGRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).show();
                                presenter103.YRKCX103(intlist,username,getCurrentdate());
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(CGRecordActivity.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
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
//                presenter2.CGSHRecord((str1+str2+str3),"1");
                if(queryself.isChecked()){
                    queryall=false;
                }else {
                    queryall=true;
                }
                presenter2.CGSHRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),queryall);

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog


    }

    @Override
    public void onDataSuccess1(StatusRespBean data) {
        Toast.makeText(CGRecordActivity.this,data.getStatus().getMessage(),Toast.LENGTH_SHORT).show();
        LoadingBar.dialog(CGRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).cancel();
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter2.CGSHRecord(date.getText().toString(),username,cgddh.getText().toString(),wlbm.getText().toString(),queryall);
    }

    @Override
    public void onDataSuccess2(PurchaseCenterRecordReps data) {
        datas=data.getData();
        if(datas!=null){
            //表格
//            System.out.println("查询的数据条数为:"+datas.size());
//            System.out.println(datas.get(0).getDescribe());
            adapter=new CGRecordAdapter(CGRecordActivity.this, R.layout.cgrecorditem,datas);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(new ListViewItemOnClick());
        }else {
            listview1.setAdapter(null);
        }

    }

    @Override
    public void onDataSuccessPrint(GetParchaseCenterLableReps data) {
        List<GetParchaseCenterLableRep> labels=data.getData();
        //Toast.makeText(CGDDListActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
        if(labels!=null){
            for (GetParchaseCenterLableRep label : labels) {
                if(label.isSeparateLabel()){
                    int labelNum= (int) label.getNum();
//                    System.out.println("分签了，分签的数量是"+labelNum);
                    for (int i = 0; i <labelNum ; i++) {
                        System.out.println("第"+i+"个签打印");
                        Bitmap bm=cb.createImage1(label,tf);
                        //确保跳转到下一页了再进行打印
//                        Thread printThread=new Thread(new Runnable(){
//                            @Override
//                            public void run() {
//                                printHelper.GoToNextPage();
//                            }
//                        });
//                        printThread.start();
//                        try {
//                            Log.i("token","scanThread.join();");
//                            printThread.join();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                        printHelper.PrintBitmapAtCenter(bm,384,480);
                        printHelper.printBlankLine(81);
                    }
                }else {
                    Bitmap bm=cb.createImage1(label,tf);
                    //确保跳转到下一页了再进行打印
//                    Thread printThread=new Thread(new Runnable(){
//                        @Override
//                        public void run() {
//                            printHelper.GoToNextPage();
//                        }
//                    });
//                    printThread.start();
//                    try {
//                        Log.i("token","scanThread.join();");
//                        printThread.join();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    printHelper.PrintBitmapAtCenter(bm,384,480);
//                    printHelper.GoToNextPage();
                    printHelper.printBlankLine(81);
                }
            }
            System.out.println("打印标签的数量为"+data.getData().size());
//            Toast.makeText(CGRecordActivity.this, "打印标签的数量为"+labels.size(), Toast.LENGTH_SHORT).show();
        }else {
            System.out.println("未打印标签");
        }
        Toast.makeText(CGRecordActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String msg) {
        System.out.println(msg);
    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position,
                                long id) {
//            System.out.println("position是："+position);

            //很关键，getChildAt（）只能获取当前可视的子item
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
        view.findViewById(R.id.shsl).setBackgroundResource(i);
        view.findViewById(R.id.shzt).setBackgroundResource(i);
    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(getApplicationContext());
//        Toast.makeText(CGRecordActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onPause() {
        super.onPause();
        printHelper.Close();
    }
}
