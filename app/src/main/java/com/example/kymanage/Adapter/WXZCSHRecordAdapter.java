package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.kymanage.Beans.GetDistributorDumpRecordData.GetDistributorDumpRecordDataRepBean;
import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRepBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WXZCSHRecordAdapter extends ArrayAdapter<GetDistributorDumpRecordDataRepBean> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetDistributorDumpRecordDataRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXZCSHRecordAdapter(Context context, int textViewResourceId, List<GetDistributorDumpRecordDataRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetDistributorDumpRecordDataRepBean>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            select.put(i, false);
        }
    }
    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final GetDistributorDumpRecordDataRepBean rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
//获取控件实例
        viewHolder.xh=view.findViewById(R.id.xh);
        viewHolder.psdh=view.findViewById(R.id.psdh);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.scddh=view.findViewById(R.id.scddh);
        viewHolder.psgc=view.findViewById(R.id.psgc);
        viewHolder.pskf=view.findViewById(R.id.pskf);
        viewHolder.pscd=view.findViewById(R.id.pscd);
        viewHolder.gxrq=view.findViewById(R.id.gxrq);
        viewHolder.zt=view.findViewById(R.id.zt);
        viewHolder.psr=view.findViewById(R.id.psr);

        viewHolder.cxr=view.findViewById(R.id.cxr);
        viewHolder.checked=view.findViewById(R.id.checked);
        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                select.put(position, isChecked);
            }

        });
        // 获取控件实例，并调用set...方法使其显示出来
//        viewHolder.check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(DataBean1.isCheck()){
//                    DataBean1.setCheck(false);
//                }else {
//                    DataBean1.setCheck(true);
//                }
//            }
//        });

        String no=(position+1)+"";
        viewHolder.xh.setText(no);

//        String newStr1 = rep.getPurchaseOrderNO().replaceAll("^(0+)", "");
//        String newStr2 = rep.getPurchaseOrderRow().replaceAll("^(0+)", "");
        viewHolder.psdh.setText(rep.getDumpNum());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());

        String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);

        String newStr3 = rep.getProductOrderNO().replaceAll("^(0+)", "");
        viewHolder.scddh.setText(newStr3);



        viewHolder.psgc.setText(rep.getFactory());
        viewHolder.pskf.setText(rep.getStorage());
        viewHolder.pscd.setText(rep.getArea());

        viewHolder.gxrq.setText(rep.getUpdateTime());
        viewHolder.zt.setText(rep.getMStatus()+"-"+rep.getWStatus());
        viewHolder.psr.setText(rep.getHandler());
        if(rep.getReverseHandler()==null||rep.getReverseHandler().equals("")){
            viewHolder.cxr.setText("");
        }else {
            viewHolder.cxr.setText(rep.getReverseHandler());
        }


        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }

//        viewHolder.rksl.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((ViewGroup) v.getParent())
//                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//                return false;
//            }
//        });
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((ViewGroup) v)
                        .setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                return false;
            }
        });
        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView psdh;
        TextView wlbm;
        TextView wlms;
        TextView xsddh_hang;
        TextView scddh;
        TextView psgc;
        TextView pskf;
        TextView pscd;
        TextView gxrq;
        TextView zt;
        TextView psr;
        TextView cxr;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
