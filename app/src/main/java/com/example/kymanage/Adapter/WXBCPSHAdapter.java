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

import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataBean;
import com.example.kymanage.Beans.GetPurWayMaterialData.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class WXBCPSHAdapter extends ArrayAdapter<GetPurchaseOrderInfoJSRep>implements View.OnClickListener {
    private int resourceId;
    private ArrayAdapter<String> adapter2;
    private List<iddesBean> areadess=new ArrayList<iddesBean>();
    private List<String> dess=new ArrayList<String>();
    private InnerItemOnclickListener mListener;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXBCPSHAdapter(Context context, int textViewResourceId, List<GetPurchaseOrderInfoJSRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetPurchaseOrderInfoJSRep rep=getItem(position); //获取当前项的DataBean1实例
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
            viewHolder.cgddh_hang=view.findViewById(R.id.cgddh_hang);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.rksl=view.findViewById(R.id.rksl);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);
            viewHolder.spinner1=view.findViewById(R.id.spinner1);
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.receive=view.findViewById(R.id.receive);
            viewHolder.receive.setOnClickListener(this);
            viewHolder.receive.setTag(position);
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
        viewHolder.wlms.setText(rep.getTXZ01());
        viewHolder.cgddh_hang.setText(rep.getEBELN()+"/"+rep.getEBELP());
        String num1str=""+rep.getMENGE();
        viewHolder.xqsl.setText(num1str);
        String num2str=""+rep.getInStorage();
        viewHolder.rksl.setText(num2str);
        String num3str=""+rep.getWESBS();
        viewHolder.dhsl.setText(num3str);
        areadess=rep.getStorage();
        for (iddesBean iddesBean : areadess) {
            dess.add(iddesBean.getDesc());
        }
        //下拉框
        adapter2 = new ArrayAdapter<String>(getContext(), R.layout.defined_spinner_item, dess);
        //设置下拉列表的风格
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        viewHolder.spinner1.setAdapter(adapter2);

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
        viewHolder.dhsl.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((ViewGroup)viewHolder.parent_layout)
                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
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

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xh.setBackgroundResource(i);
        vh.wlbm.setBackgroundResource(i);
        vh.wlms.setBackgroundResource(i);
//        vh.yrksl.setBackgroundResource(i);
//        vh.yirksl.setBackgroundResource(i);
        vh.rksl.setBackgroundResource(i);
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
        TextView cgddh_hang;
        TextView xqsl;
        TextView rksl;
        EditText dhsl;
        Spinner spinner1;
        Button receive;
        View parent_layout;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
