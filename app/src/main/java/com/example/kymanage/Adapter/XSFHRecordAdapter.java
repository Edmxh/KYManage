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

import com.example.kymanage.Beans.GetDeliveryListDetailDataJS.GetDeliveryListDetailDataJSRepBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRepBean;
import com.example.kymanage.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class XSFHRecordAdapter extends ArrayAdapter<GetDeliveryListDetailDataJSRepBean> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetDeliveryListDetailDataJSRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public XSFHRecordAdapter(Context context, int textViewResourceId, List<GetDeliveryListDetailDataJSRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetDeliveryListDetailDataJSRepBean>():objects;
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
        final GetDeliveryListDetailDataJSRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.jhdh_hang=view.findViewById(R.id.jhdh_hang);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.client=view.findViewById(R.id.client);
        viewHolder.cjsj=view.findViewById(R.id.cjsj);

        viewHolder.sl=view.findViewById(R.id.sl);
        viewHolder.gzh=view.findViewById(R.id.gzh);
        viewHolder.fhxx=view.findViewById(R.id.fhxx);
//        viewHolder.checked=view.findViewById(R.id.checked);
//        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
//
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView,
//                                         boolean isChecked) {
//                select.put(position, isChecked);
//            }
//
//        });
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

        String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);

        newStr1 = rep.getDeliveryListNO().replaceAll("^(0+)", "");
        newStr2 = rep.getDeliveryListRow().replaceAll("^(0+)", "");
        viewHolder.jhdh_hang.setText(newStr1+"/"+newStr2);

        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());
        viewHolder.gzh.setText(rep.getWorkNO());
        viewHolder.fhxx.setText(rep.getMessage());
        viewHolder.client.setText(rep.getClientNO());

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getCreateTime()))));
        viewHolder.cjsj.setText(sd);

        String num1str=""+rep.getQty();
        viewHolder.sl.setText(num1str);
//        viewHolder.czr.setText(rep.());
//        if(select.get(position)){
//            viewHolder.checked.setChecked(true);
//        }else{
//            viewHolder.checked.setChecked(false);
//        }

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
        TextView xsddh_hang;
        TextView jhdh_hang;
        TextView wlbm;
        TextView wlms;
        TextView client;
        TextView cjsj;
        TextView sl;
        TextView gzh;
        TextView fhxx;
//        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
