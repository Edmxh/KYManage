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
import com.example.kymanage.Beans.GetFinProStorageRecord.GetFinProStorageRecordRep;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WXRecordAdapter extends ArrayAdapter<GetFinProStorageRecordRep> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetFinProStorageRecordRep> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXRecordAdapter(Context context, int textViewResourceId, List<GetFinProStorageRecordRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetFinProStorageRecordRep>():objects;
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
        final GetFinProStorageRecordRep rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.ddh=view.findViewById(R.id.ddh);
        viewHolder.ddlx=view.findViewById(R.id.ddlx);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.xqgc=view.findViewById(R.id.xqgc);
        viewHolder.xqck=view.findViewById(R.id.xqck);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);

        viewHolder.rksl=view.findViewById(R.id.rksl);
        viewHolder.rkzt=view.findViewById(R.id.rkzt);
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
        viewHolder.ddh.setText(rep.getProductOrderNO());
        viewHolder.ddlx.setText(rep.getType());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.xqgc.setText(rep.getDemandFactory());
        viewHolder.xqck.setText(rep.getDemandStorage());
        viewHolder.gxsj.setText(rep.getCreateTime());
        String num1str=""+rep.getQty();
        viewHolder.rksl.setText(num1str);
        viewHolder.rkzt.setText(rep.getStatus());
        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }

        viewHolder.rksl.setOnTouchListener(new View.OnTouchListener() {

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

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView ddh;
        TextView ddlx;
        TextView wlbm;
        TextView xqgc;
        TextView xqck;
        TextView gxsj;
        TextView rksl;
        TextView rkzt;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
