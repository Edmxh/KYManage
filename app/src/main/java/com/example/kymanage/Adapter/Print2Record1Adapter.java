package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kymanage.Beans.GetMainDumpRecord.GetMainDumpRecordRepBean;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Print2Record1Adapter extends ArrayAdapter<GetMainDumpRecordRepBean>implements View.OnClickListener {
    private int resourceId;
    private InnerItemOnclickListener mListener;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetMainDumpRecordRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public Print2Record1Adapter(Context context, int textViewResourceId, List<GetMainDumpRecordRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetMainDumpRecordRepBean>():objects;
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
        final GetMainDumpRecordRepBean rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        final ViewHolder viewHolder;
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

        // 获取控件实例
        viewHolder.xh=view.findViewById(R.id.xh);
        viewHolder.zcdh=view.findViewById(R.id.zcdh);
        viewHolder.zcgc=view.findViewById(R.id.zcgc);
        viewHolder.xsddh=view.findViewById(R.id.xsddh);
        viewHolder.cjsj=view.findViewById(R.id.cjsj);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);
        viewHolder.zcr=view.findViewById(R.id.zcr);
        viewHolder.cxr=view.findViewById(R.id.cxr);
        viewHolder.zt=view.findViewById(R.id.zt);
        viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
        viewHolder.detail=view.findViewById(R.id.detail);
        viewHolder.detail.setOnClickListener(this);
        viewHolder.detail.setTag(position);
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
        viewHolder.zcdh.setText(rep.getDumpNum());
        viewHolder.zcgc.setText(rep.getFactory());
        viewHolder.xsddh.setText(rep.getMarketOrderNO());
        viewHolder.cjsj.setText(rep.getCreateTime());
        viewHolder.gxsj.setText(rep.getUpdateTime());
        viewHolder.zcr.setText(rep.getHandler());
        viewHolder.cxr.setText(rep.getReverseHandler());
        viewHolder.zt.setText(rep.getStatus());
        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }
//        String num1str=""+rep.getMENGE();
//        viewHolder.xqsl.setText(num1str);
//        String num2str=""+rep.getInStorage();
//        viewHolder.rksl.setText(num2str);
//        String num3str=""+rep.getWESBS();
//        viewHolder.dhsl.setText(num3str);
//        areadess=rep.getStorage();
//        for (iddesBean iddesBean : areadess) {
//            dess.add(iddesBean.getDesc());
//        }
//        //下拉框
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
//        viewHolder.dhsl.setOnTouchListener(new View.OnTouchListener() {
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
        TextView zcdh;
        TextView zcgc;
        TextView xsddh;
        TextView cjsj;
        TextView gxsj;
        TextView zcr;
        TextView cxr;
        TextView zt;
        Button detail;
        CheckBox checked;
        View parent_layout;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
