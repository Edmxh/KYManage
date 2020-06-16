package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kymanage.Beans.GetMaterialMasterDataJS.GetMaterialMasterDataInfo;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class WXBCPJGRKAdapter extends ArrayAdapter<GetMaterialMasterDataInfo>implements View.OnClickListener {
    private int resourceId;
    private ArrayAdapter<String> adapter2;
    private List<iddesBean> areadess=new ArrayList<iddesBean>();
    private List<String> dess=new ArrayList<String>();
    private InnerItemOnclickListener mListener;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXBCPJGRKAdapter(Context context, int textViewResourceId, List<GetMaterialMasterDataInfo> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetMaterialMasterDataInfo rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        final ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);
            viewHolder.rkdd=view.findViewById(R.id.rkdd);
            viewHolder.sydd=view.findViewById(R.id.sydd);
//            viewHolder.rksl=view.findViewById(R.id.rksl);
//            viewHolder.spinner1=view.findViewById(R.id.spinner1);
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.receive1=view.findViewById(R.id.receive1);
            viewHolder.receive1.setOnClickListener(this);
            viewHolder.receive1.setTag(position);
            viewHolder.receive2=view.findViewById(R.id.receive2);
            viewHolder.receive2.setOnClickListener(this);
            viewHolder.receive2.setTag(position);
            viewHolder.receive3=view.findViewById(R.id.receive3);
            viewHolder.receive3.setOnClickListener(this);
            viewHolder.receive3.setTag(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }

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
        viewHolder.wlbm.setText(rep.getMATNR());
        viewHolder.wlms.setText(rep.getMAKTX());
        viewHolder.wllx.setText(rep.getMaterialType());
        viewHolder.rkdd.setText("");
        viewHolder.sydd.setText("");
//        String num2str=""+rep.getWESBS();
//        viewHolder.rksl.setText("0.0");
//        String num3str=""+repData.getQty();
//        viewHolder.dhsl.setText(num1str);
//        areadess=rep.getStorage();
//        for (iddesBean iddesBean : areadess) {
//            dess.add(iddesBean.getDesc());
//        }
        //下拉框
//        adapter2 = new ArrayAdapter<String>(getContext(), R.layout.defined_spinner_item, dess);
//        //设置下拉列表的风格
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //将adapter 添加到spinner中
//        viewHolder.spinner1.setAdapter(adapter2);

//        viewHolder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                chosenArea=areadess.get(arg2).getId();
//                System.out.println(viewHolder.spinner1.getSelectedItemPosition());
//            }
//
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
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
//        viewHolder.rksl.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                ((ViewGroup)viewHolder.parent_layout)
//                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
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

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xh.setBackgroundResource(i);
        vh.wlbm.setBackgroundResource(i);
        vh.wlms.setBackgroundResource(i);
//        vh.yrksl.setBackgroundResource(i);
//        vh.yirksl.setBackgroundResource(i);
//        vh.rksl.setBackgroundResource(i);
    }

    public interface InnerItemOnclickListener {
        void itemClick(View v);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }
    @Override
    public void onClick(View view) {
        mListener.itemClick(view);
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView wlbm;
        TextView wlms;
        TextView wllx;
        TextView rkdd;
        TextView sydd;
//        EditText rksl;
//        Spinner spinner1;
        Button receive1;
        Button receive2;
        Button receive3;
        View parent_layout;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
