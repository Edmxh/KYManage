package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRepBean;
import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Print1Record2Adapter extends ArrayAdapter<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public Print1Record2Adapter(Context context, int textViewResourceId, List<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean>():objects;
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
        final GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
        viewHolder.scwlbm=view.findViewById(R.id.scwlbm);
        viewHolder.scdd=view.findViewById(R.id.scdd);
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.psdx=view.findViewById(R.id.psdx);
        viewHolder.czr=view.findViewById(R.id.czr);
        viewHolder.cjsj=view.findViewById(R.id.cjsj);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);
        viewHolder.zt=view.findViewById(R.id.zt);
        viewHolder.xqsl=view.findViewById(R.id.xqsl);
        viewHolder.gzsl=view.findViewById(R.id.gzsl);
        viewHolder.dw=view.findViewById(R.id.dw);
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
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());

//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String sd1 = sdf.format(new Date(Long.parseLong(String.valueOf(rep.getPostingdate()))));
        viewHolder.scwlbm.setText(rep.getProductMaterialCode());

        String newStr0 = rep.getProductNO().replaceAll("^(0+)", "");
        viewHolder.scdd.setText(newStr0);

        String newStr1 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr2 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);

        viewHolder.psdx.setText(rep.getClient());
        viewHolder.czr.setText(rep.getHandler());
        viewHolder.cjsj.setText(rep.getCreateTime());
        viewHolder.gxsj.setText(rep.getUpdateTime());
        if(rep.getReverseHandler()==null||rep.getReverseHandler().equals("")){
            viewHolder.zt.setText(rep.getStatus());
        }else {
            viewHolder.zt.setText(rep.getStatus()+"("+rep.getReverseHandler()+")");
        }

        viewHolder.xqsl.setText(rep.getDemandQty()+"");
        viewHolder.gzsl.setText(rep.getActuallyQty()+"");
        viewHolder.dw.setText(rep.getMaterialUnit());
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
        TextView scwlbm;
        TextView scdd;
        TextView xsddh_hang;
        TextView psdx;
        TextView czr;
        TextView cjsj;
        TextView gxsj;
        TextView zt;
        TextView xqsl;
        TextView gzsl;
        TextView dw;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
