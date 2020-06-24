package com.example.kymanage.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kymanage.Beans.GetRecevingDetail.GetRecevingDetailrep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CGListAdapter extends ArrayAdapter<GetRecevingDetailrep>implements View.OnClickListener {
    private int resourceId;
    private InnerItemOnclickListener mListener;
    private List<GetRecevingDetailrep> mList;
    HashMap<Integer, Boolean> select=new HashMap<>();

    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public CGListAdapter(Context context, int textViewResourceId, List<GetRecevingDetailrep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetRecevingDetailrep>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            select.put(i, false);
        }
    }

    public HashMap<Integer, Boolean> getSelect() {
        return select;
    }

    public void setSelect(HashMap<Integer, Boolean> select) {
        this.select = select;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final GetRecevingDetailrep rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        final ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();

            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        //获取控件和设置监听
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.wllx=view.findViewById(R.id.wllx);
        viewHolder.xqsl=view.findViewById(R.id.xqsl);
        viewHolder.dhsl=view.findViewById(R.id.dhsl);
        viewHolder.rksl=view.findViewById(R.id.rksl);
        viewHolder.checked=view.findViewById(R.id.checked);
        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                select.put(position, isChecked);
            }
        });
        viewHolder.receive=view.findViewById(R.id.receive);
//            viewHolder.blank=view.findViewById(R.id.blank);
        viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
        // 将ViewHolder存储在View中（即将控件的实例存储在其中）
        viewHolder.receive.setOnClickListener(this);
        viewHolder.receive.setTag(position);
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


        viewHolder.wlbm.setText(rep.getCode());
        viewHolder.wlms.setText(rep.getDescription());
        viewHolder.wllx.setText(rep.getMaterialType());
        String num1str=""+rep.getDemand();
        viewHolder.xqsl.setText(num1str);
        //String num2str=""+rep.getNum2();

        String num1str2=""+rep.getInStorageQty();
        viewHolder.rksl.setText(num1str2);

//        rep.setReceivenum(rep.getDemand()-rep.getInStorageQty());
        String num3str=""+rep.getCurrentQty();
        viewHolder.dhsl.setText(num3str);
        if(rep.getCurrentQty()==0){
            viewHolder.dhsl.setBackgroundColor(Color.GRAY);
        }
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
//                setRowBackgroundColorWithoutRightBorder(viewHolder, R.drawable.tablebody2_norightborder);
//                setRowBackgroundColorWithoutLeftBorder(viewHolder, R.drawable.tablebody2_noleftborder);
//                break;
//            case 1:
//                setRowBackgroundColor(viewHolder,R.drawable.tablebody1);
//                setRowBackgroundColorWithoutRightBorder(viewHolder,R.drawable.tablebody1_norightborder);
//                setRowBackgroundColorWithoutLeftBorder(viewHolder,R.drawable.tablebody1_noleftborder);
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

//    public void setRowBackgroundColor(ViewHolder vh,int i){
//        vh.wlbm.setBackgroundResource(i);
//        vh.wlms.setBackgroundResource(i);
//        vh.wllx.setBackgroundResource(i);
//        vh.xqsl.setBackgroundResource(i);
//        vh.dhsl.setBackgroundResource(i);
//        vh.rksl.setBackgroundResource(i);
//
//    }
//    public void setRowBackgroundColorWithoutRightBorder(ViewHolder vh,int i){
////        vh.blank.setBackgroundResource(i);
//    }
//    public void setRowBackgroundColorWithoutLeftBorder(ViewHolder vh,int i){
//        vh.checked.setBackgroundResource(i);
//    }

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
        TextView wlbm;
        TextView wlms;
        TextView wllx;
        TextView xqsl;
        EditText dhsl;
        TextView rksl;
        CheckBox checked;
//        TextView blank;
        View parent_layout;
        Button receive;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
