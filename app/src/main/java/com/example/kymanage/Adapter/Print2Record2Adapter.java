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

import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRepBean;
import com.example.kymanage.Beans.PurchaseCenterRecord.PurchaseCenterRecordRep;
import com.example.kymanage.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Print2Record2Adapter extends ArrayAdapter<GetDumpRecordRepBean> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetDumpRecordRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public Print2Record2Adapter(Context context, int textViewResourceId, List<GetDumpRecordRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetDumpRecordRepBean>():objects;
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
        final GetDumpRecordRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.wlpz=view.findViewById(R.id.wlpz);
        viewHolder.gzrq=view.findViewById(R.id.gzrq);
        viewHolder.pzrq=view.findViewById(R.id.pzrq);
        viewHolder.scddh=view.findViewById(R.id.scddh);
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.ghgc=view.findViewById(R.id.ghgc);
        viewHolder.ghkf=view.findViewById(R.id.ghkf);
        viewHolder.xqgc=view.findViewById(R.id.xqgc);
        viewHolder.xqkf=view.findViewById(R.id.xqkf);
        viewHolder.zcsl=view.findViewById(R.id.zcsl);
        viewHolder.zt=view.findViewById(R.id.zt);
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
        try {
            viewHolder.wlbm.setText(rep.getMaterialCode());
            viewHolder.wlms.setText(rep.getMaterialDesc());
            viewHolder.wlpz.setText(rep.getMblnr());

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String sd1 = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getPostingdate()))));
            viewHolder.gzrq.setText(rep.getPostingdate());

//        String sd2 = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getDocumentdate()))));
            viewHolder.pzrq.setText(rep.getDocumentdate());

            String newStr0 = rep.getProductOrderNO().replaceAll("^(0+)", "");
            viewHolder.scddh.setText(newStr0);

            String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
            String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
            viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);

            viewHolder.ghgc.setText(rep.getSendFactory());
            viewHolder.ghkf.setText(rep.getSendStorage());
            viewHolder.xqgc.setText(rep.getDemandFactory());
            viewHolder.xqkf.setText(rep.getDemandStorage());
            String num1str=""+rep.getQty();
            viewHolder.zcsl.setText(num1str);
            if(rep.getReverseHandler()==null||rep.getReverseHandler().equals("")){
                viewHolder.zt.setText(rep.getStatus());
            }else {
                viewHolder.zt.setText(rep.getStatus()+"("+rep.getReverseHandler()+")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
        TextView wlbm;
        TextView wlms;
        TextView wlpz;
        TextView gzrq;
        TextView pzrq;
        TextView scddh;
        TextView xsddh_hang;
        TextView ghgc;
        TextView ghkf;
        TextView xqgc;
        TextView xqkf;
        TextView zcsl;
        TextView zt;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
