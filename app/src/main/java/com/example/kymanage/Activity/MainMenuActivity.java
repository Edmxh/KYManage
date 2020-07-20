package com.example.kymanage.Activity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Printer.PrintHelper;

public class MainMenuActivity extends BaseActivity{

    private ImageView home;

    private View cggl_layout;
    private View wxgl_layout;
    private View kfgl_layout;
    private View wlcx_layout;

    private TextView user;
    private String username;
    private String namedes;



    private GridView mGridView1;
    private GridView mGridView2;
    private GridView mGridView3;
    private GridView mGridView4;

    private HashMap<String,Class<?>> FunctionActivity;

    private TextView logout;
//    private int[] imageRes = { R.drawable.function};

    //功能名对应图标
    private HashMap<String,Integer> iconmap;

    private String AuthorityStr;
    private String Authority1str;
    private String Authority2str;
    private String Authority3str;
    private String Authority4str;

    //震动
    private Vibrator vibrator;

    //打印类
    private PrintHelper printHelper=null;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main_menu;
    }

    @Override
    public void initview() {
//        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorBlank));

        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //
        logout=findViewById(R.id.logout);
        user=findViewById(R.id.user);
        home=findViewById(R.id.home);
        cggl_layout=findViewById(R.id.cggl_layout);
        wxgl_layout=findViewById(R.id.wxgl_layout);
        kfgl_layout=findViewById(R.id.kfgl_layout);
        wlcx_layout=findViewById(R.id.wlcx_layout);

//        menulv=findViewById(R.id.menuLV);
        mGridView1=findViewById(R.id.MyGridView1);
        mGridView2=findViewById(R.id.MyGridView2);
        mGridView3=findViewById(R.id.MyGridView3);
        mGridView4=findViewById(R.id.MyGridView4);

        Intent intent=getIntent();
        //测试
        Authority1str=intent.getStringExtra("Authority1");
        Authority2str=intent.getStringExtra("Authority2");
        Authority3str=intent.getStringExtra("Authority3");
        Authority4str=intent.getStringExtra("Authority4");

        AuthorityStr=intent.getStringExtra("Authority");
        username=intent.getStringExtra("username");
        namedes=intent.getStringExtra("Name");
        user.setText(namedes);



        //功能名对应图标
        iconmap=new HashMap<String,Integer>();
        iconmap.put("采购收货", R.drawable.icon_cgsh);
        iconmap.put("采购入库", R.drawable.icon_kfcg);
        iconmap.put("转储收货", R.drawable.icon_pssh);
        iconmap.put("库房发料", R.drawable.icon_kffl);
        iconmap.put("出库发料", R.drawable.icon_ckfl);
        iconmap.put("半成品收货", R.drawable.icon_bcpsh);
        iconmap.put("成品收货", R.drawable.icon_cpsh);
        iconmap.put("加工成品入库", R.drawable.icon_bcprk);
        iconmap.put("厂内配送", R.drawable.icon_printcnpsd);
        iconmap.put("跨工厂配送", R.drawable.icon_printkgcpsd);
        iconmap.put("销售发货", R.drawable.icon_printxsfhd);
        iconmap.put("物料查询", R.drawable.wlcx);

        drawGridview(Authority1str,mGridView1);
        drawGridview(Authority2str,mGridView2);
        drawGridview(Authority3str,mGridView3);
        drawGridview(Authority4str,mGridView4);

        cggl_layout.setVisibility(View.GONE);
        wxgl_layout.setVisibility(View.GONE);
        kfgl_layout.setVisibility(View.GONE);
        wlcx_layout.setVisibility(View.GONE);


        String authStr=AuthorityStr.substring(1,AuthorityStr.length()-1);
        String[] strarr=authStr.split(",");
        for (String s : strarr) {
            //System.out.println("--"+s.replace(" ","")+"--");
            s.replace(" ","");
        }
        int length = strarr.length;
        for (int i = 0; i < length; i++) {
            String functionnamestr=strarr[i].trim();
            switch (functionnamestr){
                case "PD采购管理":
                    cggl_layout.setVisibility(View.VISIBLE);
                    break;
                case "CM外协管理":
                    wxgl_layout.setVisibility(View.VISIBLE);
                    break;
                case "BD_CM库房管理":
                    kfgl_layout.setVisibility(View.VISIBLE);
                    break;
                case "物料查询":
                    wlcx_layout.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }

        }

        //高度控制
        String authStr2=Authority2str.substring(1,Authority2str.length()-1);
        String[] strarr2=authStr2.split(",");
        for (String s : strarr2) {
            //System.out.println("--"+s.replace(" ","")+"--");
            s.replace(" ","");
        }
        int length2 = strarr2.length;
//        System.out.println("外协功能数量"+length2);
        ViewGroup.LayoutParams lp;
        lp= wxgl_layout.getLayoutParams();
        if(length2>4){
//            System.out.println("功能数量超出");
//            lp.width=400;
            lp.height=350;
            wxgl_layout.setLayoutParams(lp);
        }else {
            lp.height=200;
            wxgl_layout.setLayoutParams(lp);
        }

//        ImmersionBar.with(this)
//                .statusBarColor(R.color.colorBackground2)
//                .fitsSystemWindows(true)
//                .init();
    }

    @Override
    public void initData() {
        FunctionActivity=new HashMap<String,Class<?>>();
        FunctionActivity.put("采购收货",CGDDListActivity.class);
        FunctionActivity.put("采购入库", KFCGSHRKActivity.class);
        FunctionActivity.put("转储收货", KFZCSHAtivity.class);
        FunctionActivity.put("库房发料", KFFLActivity.class);
        FunctionActivity.put("出库发料", KFFL2Activity.class);
        FunctionActivity.put("半成品收货", WXBCPSHActivity.class);
        FunctionActivity.put("成品收货", WXCPSHActivity.class);
        FunctionActivity.put("加工成品入库", WXBCPJGRKActivity.class);
        FunctionActivity.put("厂内配送", PrintCNPSDActivity.class);
        FunctionActivity.put("跨工厂配送", PrintKGCPSDActivity.class);
        FunctionActivity.put("销售发货", PrintXSFHDActivity.class);
        FunctionActivity.put("物料查询", WLQueryActivity.class);
        //FunctionActivity.put("标签查询",QueryLabelActivity.class);
        //FunctionActivity.put("物料状态查询",LabelStatusActivity.class);
        //FunctionActivity.put("返回发料单",GetIssueNoteDetailActivity.class);

        initPrinter();
    }

    @Override
    public void initLisenter() {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                MainMenuActivity.this.finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
//                Intent intent = new Intent(MainMenuActivity.this,TestActivity.class );
                //intent.putExtra("username", username);
//                startActivity(intent);
//                downLoadApk();
            }
        });

    }

    public class GridViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            vibrator.vibrate(30);
//            View itme=parent.getChildAt(position);
//            TextView text=(TextView)itme.findViewById(R.id.functionname);
            TextView text=(TextView)view.findViewById(R.id.functionname);
            String s=text.getText().toString();
            String s2=s.trim();
            Class<?> activity=FunctionActivity.get(s2);
            Intent intent = new Intent(MainMenuActivity.this,activity );
            intent.putExtra("username", username);
            startActivity(intent);
        }

    }

    public void drawGridview(String Authoritystr,GridView mGridView){
        String authStr=Authoritystr.substring(1,Authoritystr.length()-1);
        String[] strarr=authStr.split(",");
        for (String s : strarr) {
            //System.out.println("--"+s.replace(" ","")+"--");
            s.replace(" ","");
        }

        List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        int length = strarr.length;
        for (int i = 0; i < length; i++) {
            String functionnamestr=strarr[i].trim();
//            System.out.println("--"+functionnamestr+"--");
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImageView", iconmap.get(functionnamestr));
            map.put("ItemTextView", functionnamestr);
            data.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(
                MainMenuActivity.this, data, R.layout.menuitem, new String[] {
                "ItemImageView", "ItemTextView" }, new int[] {
                R.id.icon, R.id.functionname });
        mGridView.setAdapter(mSimpleAdapter);
        mGridView.setOnItemClickListener(new GridViewItemOnClick());
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
                //printHelper.GoToNextPage();
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

    //初始化
    public void   initPrinter(){
        printHelper=new PrintHelper();
        printHelper.Open(MainMenuActivity.this);
//        Toast.makeText(MainMenuActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
    }


    //更新功能
    private void downLoadApk() {
        //创建request对象
        DownloadManager.Request request=new DownloadManager.Request(Uri.parse("http://10.254.100.81/updateAPP/app-debug.apk"));
        //设置什么网络情况下可以下载
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI);
        //设置通知栏的标题
        request.setTitle("下载");
        //设置通知栏的message
        request.setDescription("测试下载.....");
        //设置漫游状态下是否可以下载
        request.setAllowedOverRoaming(false);
        //设置文件存放目录
        request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS,"update.apk");
        //获取系统服务
        DownloadManager downloadManager= (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        //进行下载
        long id = downloadManager.enqueue(request);
    }


//    private void installApp() {
//        File appFile = new File("update.apk");
//        if(!appFile.exists()) {
//            return;
//        }
//        // 跳转到新版本应用安装页面
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setDataAndType(Uri.parse("file://" + appFile.toString()), "application/vnd.android.package-archive");
//        this.startActivity(intent);
//    }
}
