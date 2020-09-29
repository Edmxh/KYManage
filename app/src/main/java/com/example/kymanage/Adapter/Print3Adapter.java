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

import com.example.kymanage.Beans.GetDeliveryListInfoJS.GetDeliveryListInfoJSReqBean1;
import com.example.kymanage.Beans.GetPurchaseOrderInfoJS.GetPurchaseOrderInfoJSRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class Print3Adapter extends ArrayAdapter<GetDeliveryListInfoJSReqBean1>implements View.OnClickListener {
    private int resourceId;
//    private ArrayAdapter<String> adapter2;
//    private List<iddesBean> areadess=new ArrayList<iddesBean>();
//    private List<String> dess=new ArrayList<String>();
    private InnerItemOnclickListener mListener;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public Print3Adapter(Context context, int textViewResourceId, List<GetDeliveryListInfoJSReqBean1> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetDeliveryListInfoJSReqBean1 rep=getItem(position); //获取当前项的DataBean1实例
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
            viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
            viewHolder.jhck=view.findViewById(R.id.jhck);
            viewHolder.jhsl=view.findViewById(R.id.jhsl);
//            viewHolder.dhsl=view.findViewById(R.id.dhsl);
//            viewHolder.spinner1=view.findViewById(R.id.spinner1);
//            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
//            viewHolder.receive=view.findViewById(R.id.receive);
//            viewHolder.receive.setOnClickListener(this);
//            viewHolder.receive.setTag(position);
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

        String newStr1 = null;
        String newStr2 = null;
        try {
            newStr1 = rep.getVBELN().replaceAll("^(0+)", "");
            newStr2 = rep.getPOSNR().replaceAll("^(0+)", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);

        viewHolder.jhck.setText(rep.getLGORT());
        viewHolder.jhsl.setText(rep.getKWMENG()+"");


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
        TextView wlbm;
        TextView xsddh_hang;
        TextView jhck;
        TextView jhsl;

//        Spinner spinner1;
//        Button receive;
//        View parent_layout;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
