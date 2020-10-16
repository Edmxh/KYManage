package com.example.kymanage.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Vibrator;
import android.util.Log;
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

import com.example.kymanage.Adapter.Print1Record1Adapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRep;
import com.example.kymanage.Beans.GetCMInFactoryDeliverJS.GetCMInFactoryDeliverJSRepBean2;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRep;
import com.example.kymanage.Beans.GetInFactoryDeliverListJS.GetInFactoryDeliverListJSRepBean;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.InterfaceView.BaseView3;
import com.example.kymanage.presenter.Presenters.Print1.GetCMInFactoryDeliverJSPresenter;
import com.example.kymanage.presenter.Presenters.Print1Record1.GetInFactoryDeliverListJSPresenter;
import com.example.kymanage.presenter.Presenters.Print1Record1.GetOutSemifinProductIssueWriteOffJSPresenter;
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

public class PrintCNPSDRecord1Activity extends BaseActivity implements BaseView1<GetInFactoryDeliverListJSRep>, BaseView2<GetCMInFactoryDeliverJSRep>, BaseView3<CodeMessageBean>, Print1Record1Adapter.InnerItemOnclickListener, AdapterView.OnItemClickListener {
    //选择日期
    private TextView date;
    //筛选条件
    private TextView kw;
    private TextView psdh;
    private TextView sygc;
    private TextView xsddh;
    private ImageView query;
    private Button reset;
    private CheckBox queryself;
    private boolean queryall=true;
    //listview
    private ListView listview1;
    private Print1Record1Adapter adapter;
    private List<GetInFactoryDeliverListJSRepBean> datas;
    private GetInFactoryDeliverListJSPresenter presenter1;

    //传递的值
    private  String username;
    //震动
    private Vibrator vibrator;

    private ImageView menupoint;
    PopupMenu popup = null;

    //打印
    private GetCMInFactoryDeliverJSPresenter presenter2;
    private com.example.kymanage.utils.mPrintUtil mPrintUtil=new mPrintUtil();
    private PrintHelper printHelper=null;

    //冲销
    private GetOutSemifinProductIssueWriteOffJSPresenter presenter3;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_cnpsdrecord;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        date = findViewById(R.id.date);
        kw = findViewById(R.id.kw);
        psdh = findViewById(R.id.psdh);
        sygc = findViewById(R.id.sygc);
        xsddh = findViewById(R.id.xsddh);
        query = findViewById(R.id.query);
        reset = findViewById(R.id.reset);
        menupoint = findViewById(R.id.menupoint);
        listview1 = findViewById(R.id.listview1);
        queryself = findViewById(R.id.queryself);

        presenter1=new GetInFactoryDeliverListJSPresenter();
        presenter1.setView(this);

        presenter2=new GetCMInFactoryDeliverJSPresenter();
        presenter2.setView(this);

        presenter3=new GetOutSemifinProductIssueWriteOffJSPresenter();
        presenter3.setView(this);
    }

    @Override
    public void initData() {
        //获取username
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        datas=new ArrayList<GetInFactoryDeliverListJSRepBean>();
        initPrinter();

        date.setText(getCurrentdate());
        queryRecord();


    }
    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(PrintCNPSDRecord1Activity.this);
//        Toast.makeText(WXBCPSHActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
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
                queryRecord();
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

    public void queryRecord(){
        if(queryself.isChecked()){
            queryall=false;
        }else {
            queryall=true;
        }
        presenter1.GetInFactoryDeliverListJS(psdh.getText().toString(),kw.getText().toString(),username,date.getText().toString(),queryall,xsddh.getText().toString(),sygc.getText().toString());
    }

    public void onPopupButtonClick(View button)
    {
        // 创建PopupMenu对象
        popup = new PopupMenu(this, button);
        // 将R.menu.popup_menu菜单资源加载到popup菜单中
        getMenuInflater().inflate(R.menu.cnpsdrecordmenu, popup.getMenu());
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
                                List<String> nos=new ArrayList<String>();
                                for (int i = 0; i < datas.size(); i++) {
                                    View itmeview=listview1.getAdapter().getView(i,null,null);
                                    CheckBox cb= itmeview.findViewById(R.id.checked);
                                    if(cb.isChecked()&&!datas.get(i).getStatus().equals("已冲销")){
                                        nos.add(datas.get(i).getDeliverID());
                                    }
                                }
                                if(nos.size()>0){
                                    presenter2.GetCMInFactoryDeliverJS(nos);
                                }else {
                                    DialogUtil.infoMessageDialog(PrintCNPSDRecord1Activity.this,"未选中要补打的记录或选中的记录已被冲销");
                                }
                                break;
//                            case R.id.exit:
//                                vibrator.vibrate(30);
//                                // 隐藏该对话框
//                                popup.dismiss();
//                                break;
                            case R.id.receive:
                                vibrator.vibrate(30);
                                confirmDeleteDialog(PrintCNPSDRecord1Activity.this);
                                // 隐藏该对话框

//                                LoadingBar.dialog(PrintCNPSDRecord1Activity.this).setFactoryFromResource(R.layout.layout_custom2).show();

                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(PrintCNPSDRecord1Activity.this,
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
                queryRecord();
            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数
        datePickerDialog.show();//显示dialog
    }

    @Override
    public void onDataSuccess1(GetInFactoryDeliverListJSRep data) {
        if(data.getCode()==1){
            datas=data.getData();
            adapter=new Print1Record1Adapter(this, R.layout.print1record1item,datas);
            adapter.setOnInnerItemOnClickListener(this);
            listview1.setAdapter(adapter);
            listview1.setOnItemClickListener(this);
        }else {
            DialogUtil.errorMessageDialog(PrintCNPSDRecord1Activity.this,data.getMessage());
        }

    }

    @Override
    public void onDataSuccess2(GetCMInFactoryDeliverJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        for (GetCMInFactoryDeliverJSRepBean2 datum : data.getData()) {
            mPrintUtil.printCNBill(datum,printHelper);
            printHelper.printBlankLine(80);
        }
    }

    @Override
    public void onDataSuccess3(CodeMessageBean data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            queryRecord();
        }else {
            DialogUtil.errorMessageDialog(PrintCNPSDRecord1Activity.this,data.getMessage());
        }

    }

    @Override
    public void onFailed(String msg) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("整体item----->", position + "");
    }

    @Override
    public void itemClick(View v) {
        int position;
        position = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.detail:
                Log.e("detail----->", position + "");
                Intent intent=new Intent(PrintCNPSDRecord1Activity.this,PrintCNPSDRecord2Activity.class);
                intent.putExtra("DeliverID",datas.get(position).getDeliverID());
                startActivity(intent);
                break;
            default:
                break;
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
                printHelper.Step((byte) 0x1f);
                return true;
        }
        return super.onKeyDown (keyCode, event);
    }

    //获取当前日期
    private String getCurrentdate(){
        Date date0 = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sf.format(date0);//凭证日期
        return currentDate;
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
                        List<String> strlist=new ArrayList<String>();
                        if(datas!=null){
                            for (int i = 0; i < datas.size(); i++) {
                                View itmeview=listview1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                if(cb.isChecked()){
                                    strlist.add(datas.get(i).getDeliverID());
                                }
                            }
                        }
                        System.out.println("冲销选中数:"+strlist.size());
                        if(strlist.size()>0){
                            presenter3.GetOutSemifinProductIssueWriteOffJS(strlist,username);
                        }else {
                            Toast.makeText(PrintCNPSDRecord1Activity.this, "未选中要冲销的记录", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
