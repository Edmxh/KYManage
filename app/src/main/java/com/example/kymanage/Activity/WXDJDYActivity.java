package com.example.kymanage.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kymanage.Adapter.DJDYListAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;

import java.util.ArrayList;
import java.util.List;

public class WXDJDYActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mListview1;
    private Spinner mSpinner1;
    /**
     * 物料扫码
     */
    private Button mScan;
    /**
     * 表单打印
     */
    private Button mPrint;
    /**
     * 打印记录
     */
    private Button mRecord;

    //下拉框
    private ArrayAdapter<String> adapter;

    private List<String> types;
    private String type;

    //测试数据
    private List<DemoBean1> datas;
    private DJDYListAdapter adapter2;

    //选中行
    private SparseBooleanArray checkedItemPositions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxdjdy);
        initView();
        initData();
    }

    private void initView() {
        mListview1 = (ListView) findViewById(R.id.listview1);
        mSpinner1 = (Spinner) findViewById(R.id.spinner1);
        mScan = (Button) findViewById(R.id.scan);
        mScan.setOnClickListener(this);
        mPrint = (Button) findViewById(R.id.print);
        mPrint.setOnClickListener(this);

        //测试数据


        types = new ArrayList<String>();
        types.add("厂内配送单");
        types.add("跨工厂配送单");
        types.add("销售发货单");
        //将可选内容与ArrayAdapter连接起来
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,types);
        adapter = new ArrayAdapter<String>(this, R.layout.defined_spinner_item, types);
        //设置下拉列表的风格
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        mSpinner1.setAdapter(adapter);
        //添加事件Spinner事件监听
        //mSpinner1.setOnItemSelectedListener(new SpinnerSelectedListener());
        mSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                // TODO Auto-generated method stub
                type=types.get(arg2);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        //设置默认值
        mSpinner1.setVisibility(View.VISIBLE);
        mRecord = (Button) findViewById(R.id.record);
        mRecord.setOnClickListener(this);
    }

    public void initData() {
        datas = new ArrayList<DemoBean1>();
        DemoBean1 db1 = new DemoBean1("ZJ0000000001", "2010", "", "", "", 6, 8);
        DemoBean1 db2 = new DemoBean1("ZJ0000000002", "2030", "", "", "", 3, 8);
        DemoBean1 db3 = new DemoBean1("ZJ0000000003", "2040", "", "", "", 12, 8);
        datas.add(db1);
        datas.add(db2);
        datas.add(db3);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.scan:
                adapter2 = new DJDYListAdapter(WXDJDYActivity.this, R.layout.djdyitem, datas);
                mListview1.setAdapter(adapter2);
                mListview1.setOnItemClickListener(new ListViewItemOnClick());
                break;
            case R.id.print:
                Intent intent1=new Intent(WXDJDYActivity.this, DJDYPrintPerviewActivity.class);
                checkedItemPositions = mListview1.getCheckedItemPositions();
                //int checkednum = 0;
                int checkedCount=0;
                //checkedItemPositions无法正常循环
                for (int i=0;i<datas.size();i++){
                    if(checkedItemPositions.get(i)==true){
                        //checkednum=i;
                        checkedCount++;
                    }
                }
                intent1.putExtra("lines",checkedCount);
                intent1.putExtra("type",type);
                startActivity(intent1);
                break;
            case R.id.record:
                Intent intent2 = new Intent(WXDJDYActivity.this, WXDJDYJLActivity.class);
                startActivity(intent2);
                break;
        }
    }

//    //使用数组形式操作
//    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
//
//        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
//                                   long arg3) {
//            view.setText("你的血型是："+m[arg2]);
//        }
//
//        public void onNothingSelected(AdapterView<?> arg0) {
//        }
//    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            View itme = mListview1.getChildAt(position);

            CheckableLayout itemlayout = itme.findViewById(R.id.parent_layout);

            if (itemlayout.isChecked()) {
                setBackgroundChange(itme, R.drawable.tablebody3);
            } else {
                if (position % 2 == 1) {
                    setBackgroundChange(itme, R.drawable.tablebody1);
                } else {
                    setBackgroundChange(itme, R.drawable.tablebody2);
                }
            }
            itemlayout.toggle();
        }

    }

    public void setBackgroundChange(View view, int i) {
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.sl).setBackgroundResource(i);
        view.findViewById(R.id.gc).setBackgroundResource(i);
    }
}
