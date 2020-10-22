package com.example.kymanage.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.kymanage.presenter.InterfaceView.PrintBaseView;
import com.example.kymanage.presenter.Presenters.WXPage2.GetOutsourceFinProLableJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2Record.OutsoureFinProductWriteOffJSPresenter;
import com.example.kymanage.presenter.Presenters.WXPage2Record.GetOutsoureFinProductDataJSPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Printer.PrintHelper;

public class WXCPSHRecordActivity extends BaseActivity implements BaseView1<GetOutsoureFinProductDataJSRep>, BaseView2<CodeMessageBean>, PrintBaseView<GetOutsourceFinProLableJSRep> {
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

    //筛选条件
    private TextView wlbm;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;
    private boolean queryall=true;

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

        //筛选条件
        wlbm = findViewById(R.id.wlbm);
        xsddh = findViewById(R.id.xsddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        queryself = findViewById(R.id.queryself);

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
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
//        System.out.println("username:"+username);

        data1=new ArrayList<GetOutsoureFinProductDataJSRepBean>();

        cb=new CreateBitmap();
        //初始化打印类
        initPrinter();

        //从asset 读取字体
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf = Typeface.createFromAsset(mgr, "fonts/simfang.ttf");//仿宋

        queryself.setChecked(true);
        date.setText(getCurrentdate());
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.GetOutsoureFinProductDataJS(username,date.getText().toString(),xsddh.getText().toString(),"","",queryall,"",wlbm.getText().toString(),"");
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
                presenter1.GetOutsoureFinProductDataJS(username,date.getText().toString(),xsddh.getText().toString(),"","",queryall,"",wlbm.getText().toString(),"");
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(WXCPSHRecordActivity.this);


            }
        });

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                try {
                    List<Integer> checkedPrintLists=new ArrayList<Integer>();
                    for (int i = 0; i < data1.size(); i++) {
                        View itmeview=listview1.getAdapter().getView(i,null,null);
                        CheckBox cb= itmeview.findViewById(R.id.checked);
                        if(cb.isChecked()&&(data1.get(i).getStatus().equals("105")||data1.get(i).getStatus().equals("101"))){
                            String[] split = data1.get(i).getAllocatedId().split(",");
                            for (String s : split) {
                                int i1 = Integer.parseInt(s);
                                checkedPrintLists.add(i1);
                            }
                        }
                    }
                    if(checkedPrintLists.size()>0){
                        presenter3.GetOutsourceFinProLableJS(checkedPrintLists);
                    }else {
                        DialogUtil.errorMessageDialog(WXCPSHRecordActivity.this,"未选中要打印的记录行或选中的记录已被冲销");
                    }

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

                if(queryself.isChecked()){
                    queryall=false;
                }else {
                    queryall=true;
                }
                presenter1.GetOutsoureFinProductDataJS(username,date.getText().toString(),xsddh.getText().toString(),"","",queryall,"",wlbm.getText().toString(),"");

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
                GetOutsourceFinProLableJSReqBean printBean=new GetOutsourceFinProLableJSReqBean(data2.getStorageId(),data2.getOrderType(),data2.getAdvanceStorageId(),data2.getFactory());
                printList.add(printBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            DialogUtil.errorMessageDialog(WXCPSHRecordActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            if(queryself.isChecked()){
                queryall=false;
            }else {
                queryall=true;
            }
            presenter1.GetOutsoureFinProductDataJS(username,date.getText().toString(),xsddh.getText().toString(),"","",queryall,"",wlbm.getText().toString(),"");
        }else {
            DialogUtil.errorMessageDialog(WXCPSHRecordActivity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccessPrint(GetOutsourceFinProLableJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            List<GetOutsourceFinProLableJSRepBean> beans = data.getData();
            for (GetOutsourceFinProLableJSRepBean bean : beans) {
                printHelper.printBlankLine(40);
                Bitmap bm=cb.createImage7(bean,tf);
                printHelper.PrintBitmapAtCenter(bm,384,530);
                printHelper.printBlankLine(80);
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
//        Toast.makeText(WXCPSHRecordActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }

    //获取当前日期
    private String getCurrentdate2(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
//                printHelper.Unreeling((byte) 0x1f);
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
                        List<OutsoureFinProductWriteOffJSReqBean> idslist=new ArrayList<OutsoureFinProductWriteOffJSReqBean>();
                        if(data1!=null){
                            for (int i = 0; i < data1.size(); i++) {
//                            CheckBox cb=listview1.getChildAt(i - listview1.getFirstVisiblePosition()).findViewById(R.id.checked);
                                GetOutsoureFinProductDataJSRepBean currData = data1.get(i);
                                View itmeview=listview1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                if(cb.isChecked()){
                                    OutsoureFinProductWriteOffJSReqBean idreq=new OutsoureFinProductWriteOffJSReqBean(currData.getOrderType(), currData.getAdvanceStorageId(), currData.getStorageId(),currData.getAllocatedId());
                                    idslist.add(idreq);
                                }
                            }
                        }
                        if(idslist.size()>0){
                            presenter2.OutsoureFinProductWriteOffJS(username,getCurrentdate(),idslist);
                        }
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
