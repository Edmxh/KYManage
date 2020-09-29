package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.kymanage.Beans.General.CNPSDDisplayBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PrintCNPSDAdapter extends ArrayAdapter<CNPSDDisplayBean> {
    private int resourceId;
    private List<CNPSDDisplayBean> mList;
    HashMap<Integer, Boolean> select=new HashMap<>();
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public PrintCNPSDAdapter(Context context, int textViewResourceId, List<CNPSDDisplayBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<CNPSDDisplayBean>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            select.put(i, true);
        }
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final CNPSDDisplayBean rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.pgdh=view.findViewById(R.id.pgdh);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.pgry=view.findViewById(R.id.pgry);
            viewHolder.cjsj=view.findViewById(R.id.cjsj);
            viewHolder.checked=view.findViewById(R.id.checked);
            viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select.put(position, isChecked);
                }

            });
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.pgdh=view.findViewById(R.id.pgdh);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.pgry=view.findViewById(R.id.pgry);
            viewHolder.cjsj=view.findViewById(R.id.cjsj);
            viewHolder.checked=view.findViewById(R.id.checked);
            viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select.put(position, isChecked);
                }

            });
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
        viewHolder.pgdh.setText(rep.getDispatchno());
        viewHolder.scddh.setText(rep.getAufnr());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.pgry.setText(rep.getUser());
        viewHolder.cjsj.setText(rep.getCreateDate());
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
        TextView pgdh;
        TextView scddh;
        TextView wlbm;
        TextView pgry;
        TextView cjsj;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
