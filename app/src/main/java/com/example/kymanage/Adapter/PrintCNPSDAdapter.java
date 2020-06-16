package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kymanage.Beans.GetCMInFactoryDeliver.GetCMInFactoryDeliverRepBean;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRepBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class PrintCNPSDAdapter extends ArrayAdapter<GetCMInFactoryDeliverRepBean> {
    private int resourceId;
    private List<GetCMInFactoryDeliverRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public PrintCNPSDAdapter(Context context, int textViewResourceId, List<GetCMInFactoryDeliverRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetCMInFactoryDeliverRepBean>():objects;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetCMInFactoryDeliverRepBean rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.pwlbm=view.findViewById(R.id.pwlbm);
            viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yfpsl=view.findViewById(R.id.yfpsl);
            viewHolder.client=view.findViewById(R.id.client);
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
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());

        String newStr1 = rep.getProductOrderNO().replaceAll("^(0+)", "");
        viewHolder.scddh.setText(newStr1);

        viewHolder.pwlbm.setText(rep.getProductMaterialCode());

        String newStr2 = rep.getMarketOrderNO().replaceAll("^(0+)", "");
        String newStr3 = rep.getMarketOrderRow().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr2+"/"+newStr3);

        viewHolder.xqsl.setText(rep.getDemandQty()+"");
        viewHolder.yfpsl.setText(rep.getDispatchQty()+"");
        viewHolder.client.setText(rep.getClient()+"");
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

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView wlbm;
        TextView wlms;
        TextView pwlbm;
        TextView scddh;
        TextView xsddh_hang;
        TextView xqsl;
        TextView yfpsl;
        TextView client;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
