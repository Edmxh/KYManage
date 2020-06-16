package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kymanage.Adapter.KFPSDAdapter;
import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.R;
import com.example.kymanage.definedClass.CheckableLayout;

import java.util.ArrayList;
import java.util.List;

public class KFPSDSHAtivity extends BaseActivity {
    private Button scan;
    private Button receive;
    private ListView listview1;
    private TextView psdh;
    //cs
    private KFPSDAdapter adapter;
    private List<DemoBean1> datas;

    @Override
    public int initLayoutId() {
        return R.layout.activity_kfpsdsh_ativity;
    }

    @Override
    public void initview() {
        scan=findViewById(R.id.scan);
        receive=findViewById(R.id.receive);
        listview1=findViewById(R.id.listview1);
        psdh=findViewById(R.id.psdh);
    }

    @Override
    public void initData() {
        //测试数据
        datas=new ArrayList<DemoBean1>();
        DemoBean1 db1=new DemoBean1("ZJ0000000001","测试描述1","2010","A123","G90000054321",6,8);
        DemoBean1 db2=new DemoBean1("ZJ0000000002","测试描述2","2030","B132","G90000054322",3,8);
        DemoBean1 db3=new DemoBean1("ZJ0000000003","测试描述3","2030","H152","G90000054323",12,8);
        datas.add(db1);
        datas.add(db2);
        datas.add(db3);

    }

    @Override
    public void initLisenter() {
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //KFCGSHRKActivity.this.finish();
                adapter=new KFPSDAdapter(KFPSDSHAtivity.this, R.layout.kfpsditem,datas);
                listview1.setAdapter(adapter);
                listview1.setOnItemClickListener(new ListViewItemOnClick());
                psdh.setText("G90000054323");
            }
        });
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(KFPSDSHAtivity.this,"收货成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ListViewItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
//            View itme=listview1.getChildAt(position);
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
//            DemoBean1 tempdb=datas.get(position);
//            psdh.setText(tempdb.getStr5());
//            GetRecevingDetailrep temprep=datas.get(position);
//            wlms.setText(temprep.getDescription());
//            wllx.setText(temprep.getClassStr());
//            String s1=""+temprep.getDemand();
//            xqsl.setText(s1);
//            String s2=""+temprep.getStorage();
//            dhsl.setText(s2);

        }

    }

    public void setBackgroundChange(View view,int i){
        view.findViewById(R.id.xh).setBackgroundResource(i);
        view.findViewById(R.id.wlbm).setBackgroundResource(i);
        view.findViewById(R.id.wlms).setBackgroundResource(i);
        view.findViewById(R.id.sl).setBackgroundResource(i);
        view.findViewById(R.id.gc).setBackgroundResource(i);
        view.findViewById(R.id.cd).setBackgroundResource(i);
    }
}
