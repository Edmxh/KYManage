package com.example.kymanage.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WXCPSHAdapter extends ArrayAdapter<GetPurchaseOrderInfoJSRep>implements View.OnClickListener {
    private int resourceId;
    private List<GetPurchaseOrderInfoJSRep> mList;
    private InnerItemOnclickListener mListener;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXCPSHAdapter(Context context, int textViewResourceId, List<GetPurchaseOrderInfoJSRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetPurchaseOrderInfoJSRep>():objects;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetPurchaseOrderInfoJSRep rep=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.cgddh_hang=view.findViewById(R.id.cgddh_hang);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.ddlx=view.findViewById(R.id.ddlx);
            viewHolder.rklj=view.findViewById(R.id.rklj);

            viewHolder.xqrq=view.findViewById(R.id.xqrq);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yrksl=view.findViewById(R.id.yrksl);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);
            viewHolder.receive=view.findViewById(R.id.receive);
            viewHolder.receive.setOnClickListener(this);
            viewHolder.receive.setTag(position);

            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.dhsl.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.cgddh_hang=view.findViewById(R.id.cgddh_hang);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.ddlx=view.findViewById(R.id.ddlx);
            viewHolder.rklj=view.findViewById(R.id.rklj);

            viewHolder.xqrq=view.findViewById(R.id.xqrq);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yrksl=view.findViewById(R.id.yrksl);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);
            viewHolder.receive=view.findViewById(R.id.receive);
            viewHolder.receive.setOnClickListener(this);
            viewHolder.receive.setTag(position);

            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.dhsl.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
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
        String newStr1 = rep.getEBELN().replaceAll("^(0+)", "");
        String newStr2 = rep.getEBELP().replaceAll("^(0+)", "");
        viewHolder.cgddh_hang.setText(newStr1+"/"+newStr2);
        String newStr3 = rep.getAUFNR().replaceAll("^(0+)", "");
        viewHolder.scddh.setText(newStr3);
        viewHolder.wlbm.setText(rep.getMATNR());
        viewHolder.wlms.setText(rep.getTXZ01());

        switch (rep.getKINDS()){
            case "10":
                viewHolder.ddlx.setText("实物入库");
                viewHolder.rklj.setText("103->105");
                break;
            case "20":
                viewHolder.ddlx.setText("实物入库");
                viewHolder.rklj.setText("103->105->261->101");
                break;
            case "3":
                viewHolder.ddlx.setText("费用入库");
                viewHolder.rklj.setText("103->105->101");
                break;
            case "4":
                viewHolder.ddlx.setText("费用入库");
                viewHolder.rklj.setText("103->105->101->261->101");
                break;
            default:
                viewHolder.ddlx.setText("未知类型");
                viewHolder.rklj.setText("");
                break;
        }
        viewHolder.xqrq.setText(rep.getDeliveryDate());

        /**
         * 需求/已入库/到货
         */
        String num1str=""+rep.getMENGE();
        viewHolder.xqsl.setText(num1str);

        String num2str=""+rep.getInStorage();
        viewHolder.yrksl.setText(num2str);

        String num3str=""+rep.getWESBS();
        viewHolder.dhsl.setText(num3str);

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

    public void setRowBackgroundColor(CGDialogAdapter.ViewHolder vh, int i){
        vh.xqjb.setBackgroundResource(i);
        vh.scddh.setBackgroundResource(i);
        vh.jhksrq.setBackgroundResource(i);
        vh.xqsl.setBackgroundResource(i);
        vh.fpsl.setBackgroundResource(i);
        vh.yfpsl.setBackgroundResource(i);
    }

    @Override
    public void onClick(View v) {
        mListener.itemClick(v);
    }


    public interface InnerItemOnclickListener {
        void itemClick(View v);
    }

    public void setOnInnerItemOnClickListener(InnerItemOnclickListener listener){
        this.mListener=listener;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        View parent_layout;
        TextView xh;
        TextView cgddh_hang;
        TextView scddh;
        TextView wlbm;
        TextView wlms;
        TextView ddlx;
        TextView rklj;
        TextView xqrq;
        TextView xqsl;
        TextView yrksl;
        EditText dhsl;
        Button receive;
        MyTextWatcher mTextWatcher;

        //动态更新TextWathcer的position
        public void updatePosition(int position) {
            mTextWatcher.updatePosition(position);
        }
    }

    public interface DetailViewHolderListener {
        void setData(CGDialogAdapter.ViewHolder viewHolder, int position);
    }
    class MyTextWatcher implements TextWatcher {
        //由于TextWatcher的afterTextChanged中拿不到对应的position值，所以自己创建一个子类
        private int mPosition;

        public void updatePosition(int position) {
            mPosition = position;
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            System.out.println("afterTextChanged run!"+s.toString());
            float num=Float.parseFloat(("0"+s.toString()));
            mList.get(mPosition).setWESBS(num);
        }
    }
}
