package com.example.kymanage.Activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dyhdyh.widget.loadingbar2.LoadingBar;
import com.example.kymanage.Adapter.WXBCPSHRecordAdapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean2;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRep;
import com.example.kymanage.Beans.GetDispatchListJS.GetDispatchListJSRepBean3;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingLable.Semi_FinishedProductReceivingLableRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRep;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRepBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingwriteoffJS.Semi_FinishedProductReceivingwriteoffJSReqBean;
import com.example.kymanage.Bitmap.CreateBitmap;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.Print2BaseView;
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.WXPage1.GetDispatchListJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1.Semi_FinishedProductReceivingLablePresenter;
import com.example.kymanage.presenter.Presenters.WXPage1Record.Semi_FinishedProductReceivingRecordJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage1Record.Semi_FinishedProductReceivingwriteoffJSPresenter;
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

public class WXBCPSHRecordActivity extends BaseActivity implements BaseView1<Semi_FinishedProductReceivingRecordJSRep>, BaseView2<CodeMessageBean>, PrintBaseView<GetDispatchListJSRep>, Print2BaseView<Semi_FinishedProductReceivingLableRep> {
    //选择日期
    private TextView date;
    private List<Semi_FinishedProductReceivingRecordJSRepBean> data1;
    private Semi_FinishedProductReceivingRecordJSPresenter presenter1;
    private WXBCPSHRecordAdapter adapter;
    //入库冲销
    private ImageView receive;
    private Semi_FinishedProductReceivingwriteoffJSPresenter presenter2;
    //打印
    private ImageView print;
    private GetDispatchListJSPresenter presenter3;//派工单打印
    private Semi_FinishedProductReceivingLablePresenter presenterPrint2;//标签打印
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

    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();

    //筛选条件
    private TextView wlbm;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;
    private boolean queryall=true;


    @Override
    public int initLayoutId() {
        return R.layout.activity_wxbcpshrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        print = findViewById(R.id.print);
        listview1 = findViewById(R.id.listview1);

        //筛选条件
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        queryself = findViewById(R.id.queryself);

        presenter1=new Semi_FinishedProductReceivingRecordJSPresenter();
        presenter1.setView(this);

        presenter2=new Semi_FinishedProductReceivingwriteoffJSPresenter();
        presenter2.setView(this);

        //打印派工单
        presenter3=new GetDispatchListJSPresenter();
        presenter3.setView(this);

        //打印标签
        presenterPrint2=new Semi_FinishedProductReceivingLablePresenter();
        presenterPrint2.setView(this);

    }

    @Override
    public void initData() {
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
//        System.out.println("username:"+username);

        data1=new ArrayList<Semi_FinishedProductReceivingRecordJSRepBean>();

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋

        date.setText(getCurrentdate());

        queryself.setChecked(true);
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.Semi_FinishedProductReceivingRecordJS(date.getText().toString(),username,queryall,xsddh.getText().toString(),"",wlbm.getText().toString(),"","");
    }

    @Override
    public void initLisenter() {
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
                presenter1.Semi_FinishedProductReceivingRecordJS(date.getText().toString(),username,queryall,xsddh.getText().toString(),"",wlbm.getText().toString(),"","");
            }
        });
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
                confirmDeleteDialog(WXBCPSHRecordActivity.this);
            }
        });
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                List<Long> AvanceStorageIds=new ArrayList<Long>();
                List<Long> LabelAvanceStorageIds=new ArrayList<Long>();
                if(data1!=null){
                    for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()){
                            //根据类型判断打印派工单还是标签
                            if(data1.get(i).getOrderType().equals("2")){
                                //打印标签，判断是否冲销
                                if(data1.get(i).getStatus().equals("105")||data1.get(i).getStatus().equals("101")){
                                    LabelAvanceStorageIds.add(data1.get(i).getAdvanceStorageId());
                                }

                            }else {
                                //打印派工单，判断是否冲销
                                if(data1.get(i).getStatus().equals("105")||data1.get(i).getStatus().equals("101")){
                                    AvanceStorageIds.add(data1.get(i).getAdvanceStorageId());
                                }

                            }

                        }
                    }
                }
                //当前时间
                Date dateNow = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String currentdate = sf.format(dateNow);
                if(AvanceStorageIds.size()==0&&LabelAvanceStorageIds.size()==0){
                    Toast.makeText(WXBCPSHRecordActivity.this, "未选中要打印的内容或选中的记录已被冲销", Toast.LENGTH_SHORT).show();
                }else {
                    for (Long labelAvanceStorageId : LabelAvanceStorageIds) {
                        presenterPrint2.Semi_FinishedProductReceivingLable(labelAvanceStorageId,username,getCurrentdate());
                    }
                    presenter3.GetDispatchListJS(AvanceStorageIds,username,getCurrentdate());
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

                if(queryself.isChecked()){
                    queryall=false;
                }else {
                    queryall=true;
                }
                presenter1.Semi_FinishedProductReceivingRecordJS(date.getText().toString(),username,queryall,xsddh.getText().toString(),"",wlbm.getText().toString(),"","");

            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }

    @Override
    public void onDataSuccess1(Semi_FinishedProductReceivingRecordJSRep data) {

            try {
                data1 = data.getData();
                System.out.println(data1.size());
                //表格适配数据
                adapter=new WXBCPSHRecordAdapter(WXBCPSHRecordActivity.this, R.layout.wxbcpshrecorditem,data1);
                listview1.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            DialogUtil.errorMessageDialog(WXBCPSHRecordActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        LoadingBar.dialog(WXBCPSHRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).cancel();
        if(data.getCode()==1){
            Toast.makeText(WXBCPSHRecordActivity.this,data.getMessage(),Toast.LENGTH_SHORT).show();

            if(queryself.isChecked()){
                queryall=false;
            }else {
                queryall=true;
            }
            presenter1.Semi_FinishedProductReceivingRecordJS(date.getText().toString(),username,queryall,xsddh.getText().toString(),"",wlbm.getText().toString(),"","");
        }else {
            DialogUtil.errorMessageDialog(WXBCPSHRecordActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccessPrint(GetDispatchListJSRep data) {
        try {
            for (GetDispatchListJSRepBean2 datum : data.getData().getDispatchListDataArr()) {

                mPrintUtil.printPGBill(datum,printHelper);
                printHelper.printBlankLine(80);
            }

            for (GetDispatchListJSRepBean3 label : data.getData().getLableDataArr()) {
                printHelper.printBlankLine(40);
                Bitmap bm=cb.createImage5(label,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(80);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccessPrint2(Semi_FinishedProductReceivingLableRep data) {
        if(data.getCode()==1){
            for (Semi_FinishedProductReceivingLableRep.Semi_FinishedProductReceivingLableRepBean datum : data.getData()) {
                Bitmap bm=cb.createImage11(datum,tf);
                printHelper.PrintBitmapAtCenter(bm,384,480);
                printHelper.printBlankLine(80);
            }
        }else {
            DialogUtil.errorMessageDialog(WXBCPSHRecordActivity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {
        LoadingBar.dialog(WXBCPSHRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).cancel();
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
        printHelper.Open(WXBCPSHRecordActivity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
                        List<Long> idslist=new ArrayList<Long>();
                        if(data1!=null){
                            for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                                Semi_FinishedProductReceivingRecordJSRepBean currData = data1.get(i);
                                View itmeview=listview1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                if(cb.isChecked()){
//                            Semi_FinishedProductReceivingwriteoffJSReqBean idreq=new Semi_FinishedProductReceivingwriteoffJSReqBean(currData.getAdvanceStorageId(),currData.getAdvanceStorageId());
                                    idslist.add(currData.getAdvanceStorageId());
                                }
                            }
                        }
//                WriteOffProStorageRecordReq req=new WriteOffProStorageRecordReq(username,idlist);
//                System.out.println("冲销选中数:"+idlist.size());
                        LoadingBar.dialog(WXBCPSHRecordActivity.this).setFactoryFromResource(R.layout.layout_custom2).show();
                        presenter2.Semi_FinishedProductReceivingwriteoffJS(username,getCurrentdate(),idslist);
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
