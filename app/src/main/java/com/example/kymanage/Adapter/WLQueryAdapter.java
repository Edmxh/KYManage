package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kymanage.Beans.DemoBeans.DemoBean1;
import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRepBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class WLQueryAdapter extends ArrayAdapter<GetMaterialStorageRepBean> {
    private int resourceId;
    private List<GetMaterialStorageRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WLQueryAdapter(Context context, int textViewResourceId, List<GetMaterialStorageRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetMaterialStorageRepBean>():objects;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetMaterialStorageRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
            viewHolder.pwlms=view.findViewById(R.id.pwlms);
            viewHolder.kf=view.findViewById(R.id.kf);
            viewHolder.flcd=view.findViewById(R.id.flcd);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yflsl=view.findViewById(R.id.yflsl);
            viewHolder.flsl=view.findViewById(R.id.flsl);
            viewHolder.zt=view.findViewById(R.id.zt);
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
        viewHolder.scddh.setText(rep.getProductOrderNO());
        viewHolder.pwlbm.setText(rep.getSMaterialCode());
        viewHolder.pwlms.setText(rep.getSMaterialDesc());
        viewHolder.kf.setText(rep.getIssueStorage());
        viewHolder.flcd.setText(rep.getArea());
        viewHolder.xqsl.setText(rep.getDemandQty()+"");
        viewHolder.yflsl.setText(rep.getLastQty()+"");
        viewHolder.flsl.setText(rep.getIssueQty()+"");
        viewHolder.zt.setText(rep.getStatus());
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
        TextView scddh;
        TextView pwlbm;
        TextView pwlms;
        TextView kf;
        TextView flcd;
        TextView xqsl;
        TextView yflsl;
        TextView flsl;
        TextView zt;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
