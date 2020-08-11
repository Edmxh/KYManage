package com.example.kymanage.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kymanage.Beans.GetMaterialStorage.GetMaterialStorageRepBean;
import com.example.kymanage.Beans.ScanIssueNoteDetail.ScanIssueNoteDetailRepBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class KFFLFKAdapter extends ArrayAdapter<ScanIssueNoteDetailRepBean> {
    private int resourceId;
    private List<ScanIssueNoteDetailRepBean> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public KFFLFKAdapter(Context context, int textViewResourceId, List<ScanIssueNoteDetailRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<ScanIssueNoteDetailRepBean>():objects;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final ScanIssueNoteDetailRepBean rep=getItem(position); //获取当前项的DataBean1实例
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
            viewHolder.flfk=view.findViewById(R.id.flfk);
            viewHolder.flgc=view.findViewById(R.id.flgc);
            viewHolder.flck=view.findViewById(R.id.flck);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.flsl=view.findViewById(R.id.flsl);
            viewHolder.dw=view.findViewById(R.id.dw);
            viewHolder.zt=view.findViewById(R.id.zt);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.flfk=view.findViewById(R.id.flfk);
            viewHolder.flgc=view.findViewById(R.id.flgc);
            viewHolder.flck=view.findViewById(R.id.flck);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.flsl=view.findViewById(R.id.flsl);
            viewHolder.dw=view.findViewById(R.id.dw);
            viewHolder.zt=view.findViewById(R.id.zt);
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
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());
        viewHolder.scddh.setText(rep.getProductOrderNO());
        viewHolder.flfk.setText(rep.getMessa());
        viewHolder.flgc.setText(rep.getIssueFactory());
        viewHolder.flck.setText(rep.getIssueStorage());
        viewHolder.xqsl.setText(rep.getDemandQty()+"");
        viewHolder.flsl.setText(rep.getIssueQty()+"");
        viewHolder.dw.setText(rep.getUnit()+"");
        viewHolder.zt.setText(rep.getStatus());
        if(rep.getMessa().equals("S")){
            viewHolder.zt.setTextColor(Color.GREEN);
        }else {
            viewHolder.zt.setTextColor(Color.RED);
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
        TextView flfk;
        TextView flgc;
        TextView flck;
        TextView xqsl;
        TextView flsl;
        TextView dw;
        TextView zt;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
