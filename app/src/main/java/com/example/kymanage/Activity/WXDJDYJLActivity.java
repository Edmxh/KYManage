package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.WXDJDYJL2Adapter;
import com.example.kymanage.Adapter.WXDJDYJLAdapter;
import com.example.kymanage.Adapter.WXRecordAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WXDJDYJLActivity extends BaseActivity {
    //选择日期
    private TextView date;
    //入库冲销
    private Button receive;
    //listview
    private ListView listview1;
    private ListView listview2;
    //测试数据
    private List<DemoBean1> datas;
    private WXDJDYJLAdapter adapter;
    private List<DemoBean1> datas2;
    private WXDJDYJL2Adapter adapter2;

    @Override
    public int initLayoutId() {
        return R.layout.activity_wxdjdyjl;
    }

    @Override
    public void initview() {
        date = findViewById(R.id.date);
        receive = findViewById(R.id.receive);
        listview1 = findViewById(R.id.listview1);
        listview2 = findViewById(R.id.listview2);
    }

    @Override
    public void initData() {
        datas=new ArrayList<DemoBean1>();
        DemoBean1 db1=new DemoBean1("0000000001","2020-04-21 16:21","ZJ0000000001","","",6,8);
        DemoBean1 db2=new DemoBean1("0000000002","2020-04-21 16:21","ZJ0000000002","","",3,8);
        DemoBean1 db3=new DemoBean1("0000000003","2020-04-21 16:21","ZJ0000000003","","",12,8);
        datas.add(db1);
        datas.add(db2);
        datas.add(db3);

        datas2=new ArrayList<DemoBean1>();
        DemoBean1 db4=new DemoBean1("ZJ0000000001","15","2010","","",6,8);
        DemoBean1 db5=new DemoBean1("ZJ0000000002","21","2030","","",3,8);
        DemoBean1 db6=new DemoBean1("ZJ0000000003","8","2040","","",12,8);
        datas2.add(db4);
        datas2.add(db5);
        datas2.add(db6);
    }

    @Override
    public void initLisenter() {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdate();
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WXDJDYJLActivity.this,"冲销成功",Toast.LENGTH_SHORT).show();
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
                //表格适配数据
                adapter=new WXDJDYJLAdapter(WXDJDYJLActivity.this, R.layout.wxdjdyjlitem1,datas);
                listview1.setAdapter(adapter);
                listview1.setOnItemClickListener(new ListViewItemOnClick());
            }
        }, mYear,mMonth, mDay);//将年月日放入DatePickerDialog中，并将值传给参数

        datePickerDialog.show();//显示dialog

    }
    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            View itme=listview1.getChildAt(position);

            CheckableLayout itemlayout=itme.findViewById(R.id.parent_layout);

            if(itemlayout.isChecked()){
                setBackgroundChange(itme, R.drawable.tablebody3);
            }else {
                if(position%2==1){
                    setBackgroundChange(itme, R.drawable.tablebody1);
                }else {
                    setBackgroundChange(itme, R.drawable.tablebody2);
                }
            }
            itemlayout.toggle();

            //cs
            adapter2=new WXDJDYJL2Adapter(WXDJDYJLActivity.this, R.layout.wxdjdyjlitem2,datas2);
            listview2.setAdapter(adapter2);
        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.psdh).setBackgroundResource(i);
        view.findViewById(R.id.dysj).setBackgroundResource(i);
    }
}
