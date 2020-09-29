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

import com.example.kymanage.Beans.GetOutsoureFinProductDataJS.GetOutsoureFinProductDataJSRepBean;
import com.example.kymanage.Beans.Semi_FinishedProductReceivingRecordJS.Semi_FinishedProductReceivingRecordJSRepBean;
import com.example.kymanage.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class WXCPSHRecordAdapter extends ArrayAdapter<GetOutsoureFinProductDataJSRepBean> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetOutsoureFinProductDataJSRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXCPSHRecordAdapter(Context context, int textViewResourceId, List<GetOutsoureFinProductDataJSRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetOutsoureFinProductDataJSRepBean>():objects;
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
        final GetOutsoureFinProductDataJSRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.ddlx=view.findViewById(R.id.ddlx);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.shlj=view.findViewById(R.id.shlj);
        viewHolder.shlx=view.findViewById(R.id.shlx);
        viewHolder.xqgc=view.findViewById(R.id.xqgc);
        viewHolder.xqck=view.findViewById(R.id.xqck);
        viewHolder.shry=view.findViewById(R.id.shry);
        viewHolder.shsj=view.findViewById(R.id.shsj);
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

//        String newStr1 = rep.getPurchaseOrderNO().replaceAll("^(0+)", "");
//        String newStr2 = rep.getPurchaseOrderRow().replaceAll("^(0+)", "");
        viewHolder.ddh.setText(rep.getPurchaseOrderNO()+"/"+rep.getPurchaseOrderRow());

        String newStr3 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr4 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr3+"/"+newStr4);

        viewHolder.ddlx.setText(rep.getMaterialType());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getDescription());

        switch (rep.getOrderType()){
            case "10":
                viewHolder.shlx.setText("实物入库");
                viewHolder.shlj.setText("103->105");
                break;
            case "20":
                viewHolder.shlx.setText("实物入库");
                viewHolder.shlj.setText("103->105->261->101");
                break;
            case "3":
                viewHolder.shlx.setText("费用入库");
                viewHolder.shlj.setText("103->105->101");
                break;
            case "4":
                viewHolder.shlx.setText("费用入库");
                viewHolder.shlj.setText("103->105->101->261->101");
                break;
            default:
                break;
        }

        viewHolder.xqgc.setText(rep.getDemandFactory());
        viewHolder.xqck.setText(rep.getDemandStorage());
        viewHolder.shry.setText(rep.getHandler());

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getCreateTime()))));
        viewHolder.shsj.setText(rep.getCreateTime());

//        String sd2 = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getUpdateTime()))));
        viewHolder.gxsj.setText(rep.getUpdateTime());

        String num1str=""+rep.getQty();
        viewHolder.rksl.setText(num1str);
        if(rep.getReverseHandler()==null||rep.getReverseHandler().equals("")){
            viewHolder.rkzt.setText(rep.getStatus());
        }else {
            viewHolder.rkzt.setText(rep.getStatus()+"("+rep.getReverseHandler()+")");
        }

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
        TextView xsddh_hang;
        TextView ddlx;
        TextView wlbm;
        TextView wlms;
        TextView shlx;
        TextView shlj;
        TextView xqgc;
        TextView xqck;
        TextView shry;
        TextView shsj;
        TextView gxsj;
        TextView rksl;
        TextView rkzt;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
