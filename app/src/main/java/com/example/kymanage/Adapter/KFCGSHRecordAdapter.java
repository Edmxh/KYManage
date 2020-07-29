package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordRep;
import com.example.kymanage.Beans.WarehouseReceiptRecord.WarehouseReceiptRecordRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KFCGSHRecordAdapter extends ArrayAdapter<WarehouseReceiptRecordRep> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<WarehouseReceiptRecordRep> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public KFCGSHRecordAdapter(Context context, int textViewResourceId, List<WarehouseReceiptRecordRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<WarehouseReceiptRecordRep>():objects;
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
        final WarehouseReceiptRecordRep rep=getItem(position); //获取当前项的DataBean1实例
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
        //获取控件和设置监听
        viewHolder.xh=view.findViewById(R.id.xh);
        viewHolder.cgddh=view.findViewById(R.id.cgddh);
        viewHolder.wllx=view.findViewById(R.id.wllx);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.rksj=view.findViewById(R.id.rksj);
        viewHolder.shr=view.findViewById(R.id.shr);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);
        viewHolder.rksl=view.findViewById(R.id.rksl);
        viewHolder.rklx=view.findViewById(R.id.rklx);
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
        String newStr1 = rep.getPurchaseOrderNo().replaceAll("^(0+)", "");
        String newStr2 = rep.getPurchaseOrderRow().replaceAll("^(0+)", "");
        viewHolder.cgddh.setText(newStr1+"/"+newStr2);
        viewHolder.wllx.setText(rep.getMaterialType());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDescription());
        viewHolder.rksj.setText(rep.getCreateTime());
        viewHolder.shr.setText(rep.getHandler());
        viewHolder.gxsj.setText(rep.getUpdateTime());

        String str="";
        if(rep.getReverseHandler().equals("")){
            str=rep.getRecStatus();
        }else {
            str=rep.getRecStatus()+"("+rep.getReverseHandler()+")";
        }
        viewHolder.rklx.setText(str);
        String num1str=""+rep.getQty();
        viewHolder.rksl.setText(num1str);
        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }
//        switch (position%2){
//            default:
//                break;
//            case 0:
//                setRowBackgroundColor(viewHolder, R.drawable.tablebody2);
//                break;
//            case 1:
//                setRowBackgroundColor(viewHolder,R.drawable.tablebody1);
//                break;
//        }
//        viewHolder.shsl.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((ViewGroup) v.getParent())
//                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//                return false;
//            }
//        });
//        view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((ViewGroup) v)
//                        .setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
//                return false;
//            }
//        });
        return view;
    }

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xh.setBackgroundResource(i);
        vh.cgddh.setBackgroundResource(i);
        vh.wllx.setBackgroundResource(i);
        vh.wlbm.setBackgroundResource(i);
        vh.rksl.setBackgroundResource(i);
        vh.rklx.setBackgroundResource(i);
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView cgddh;
        TextView wllx;
        TextView wlbm;
        TextView wlms;
        TextView rksj;
        TextView shr;
        TextView gxsj;
        TextView rklx;
        TextView rksl;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
