package com.example.kymanage.Activity;

import android.content.Intent;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainMenuActivity extends BaseActivity{

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

    @Override
    public int initLayoutId() {
        return R.layout.activity_main_menu;
    }

    @Override
    public void initview() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        //
        logout=findViewById(R.id.logout);
        user=findViewById(R.id.user);
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
        iconmap.put("半成品收货", R.drawable.icon_bcpsh);
        iconmap.put("成品收货", R.drawable.icon_cpsh);
        iconmap.put("半成品加工入库", R.drawable.icon_bcprk);
        iconmap.put("厂内配送单", R.drawable.icon_printcnpsd);
        iconmap.put("跨工厂配送单", R.drawable.icon_printkgcpsd);
        iconmap.put("销售发货单", R.drawable.icon_printxsfhd);
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
                case "采购管理":
                    cggl_layout.setVisibility(View.VISIBLE);
                    break;
                case "外协管理":
                    wxgl_layout.setVisibility(View.VISIBLE);
                    break;
                case "库房管理":
                    kfgl_layout.setVisibility(View.VISIBLE);
                    break;
                case "物料查询":
                    wlcx_layout.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }

        }



    }

    @Override
    public void initData() {
        FunctionActivity=new HashMap<String,Class<?>>();
        FunctionActivity.put("采购收货",CGDDListActivity.class);
        FunctionActivity.put("采购入库", KFCGSHRKActivity.class);
        FunctionActivity.put("转储收货", KFPSDSHAtivity.class);
        FunctionActivity.put("库房发料", KFFLActivity.class);
        FunctionActivity.put("半成品收货", WXBCPSHActivity.class);
        FunctionActivity.put("成品收货", WXCPSHActivity.class);
        FunctionActivity.put("半成品加工入库", WXBCPJGRKActivity.class);
        FunctionActivity.put("厂内配送单", PrintCNPSDActivity.class);
        FunctionActivity.put("跨工厂配送单", PrintKGCPSDActivity.class);
        FunctionActivity.put("销售发货单", PrintXSFHDActivity.class);
        FunctionActivity.put("物料查询", WLQueryActivity.class);
        //FunctionActivity.put("标签查询",QueryLabelActivity.class);
        //FunctionActivity.put("物料状态查询",LabelStatusActivity.class);
        //FunctionActivity.put("返回发料单",GetIssueNoteDetailActivity.class);
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
            System.out.println("--"+functionnamestr+"--");
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

}
