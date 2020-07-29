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

import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CGRecordAdapter extends ArrayAdapter<PurchaseCenterRecordRep> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<PurchaseCenterRecordRep> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public CGRecordAdapter(Context context, int textViewResourceId, List<PurchaseCenterRecordRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<PurchaseCenterRecordRep>():objects;
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
        final PurchaseCenterRecordRep rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.shsl=view.findViewById(R.id.shsl);
        viewHolder.cxqrk=view.findViewById(R.id.cxqrk);
        viewHolder.shzt=view.findViewById(R.id.shzt);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);
        viewHolder.shr=view.findViewById(R.id.shr);
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
        viewHolder.cgddh.setText(rep.getOrderNum());
        viewHolder.wllx.setText(rep.getMaterialType());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());
        viewHolder.gxsj.setText(rep.getUpdateTime());
        viewHolder.shr.setText(rep.getHandler());
        String num1str=""+rep.getReceiveNum();
        viewHolder.shsl.setText(num1str);

        String num2str=""+rep.getMoreQty();
        viewHolder.cxqrk.setText(num2str);

        String str="";
        if(rep.getReverseHandler().equals("")){
            str=rep.getDescribe();
        }else {
            str=rep.getDescribe()+"("+rep.getReverseHandler()+")";
        }
        viewHolder.shzt.setText(str);
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
        viewHolder.shsl.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((ViewGroup) v.getParent())
                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                return false;
            }
        });
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

//    public void setRowBackgroundColor(ViewHolder vh,int i){
//        vh.xh.setBackgroundResource(i);
//        vh.cgddh.setBackgroundResource(i);
//        vh.wllx.setBackgroundResource(i);
//        vh.wlbm.setBackgroundResource(i);
//        vh.shsl.setBackgroundResource(i);
//        vh.shzt.setBackgroundResource(i);
//    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView cgddh;
        TextView wllx;
        TextView wlbm;
        TextView wlms;
        TextView shzt;
        TextView shsl;
        TextView cxqrk;
        TextView gxsj;
        TextView shr;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
