package com.example.kymanage.Adapter;

import android.content.Context;
import android.graphics.Color;
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
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.kymanage.Activity.CGDDListActivity;
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
    HashMap<Integer, Boolean> select1=new HashMap<>();
    HashMap<Integer, Float> unable=new HashMap<>();

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
            if(mList.get(i).getCurrentQty()>0){
                select.put(i, true);
            }else {
                select.put(i, false);
            }
            select1.put(i, false);
            unable.put(i, mList.get(i).getCurrentQty());
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
            //获取控件和设置监听
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);
            viewHolder.rksl=view.findViewById(R.id.rksl);
            viewHolder.checked=view.findViewById(R.id.checked);
            viewHolder.checked1=view.findViewById(R.id.checked1);
            viewHolder.label=view.findViewById(R.id.label);
            viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select.put(position, isChecked);
                }
            });
            viewHolder.checked1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select1.put(position, isChecked);
                }
            });
//            viewHolder.blank=view.findViewById(R.id.blank);
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.dhsl.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
            view.setTag(viewHolder);
//            viewHolder.updatePosition(position);
        } else{

            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);
            viewHolder.rksl=view.findViewById(R.id.rksl);
            viewHolder.checked=view.findViewById(R.id.checked);
            viewHolder.checked1=view.findViewById(R.id.checked1);
            viewHolder.label=view.findViewById(R.id.label);
            viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select.put(position, isChecked);
                }
            });
            viewHolder.checked1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    select1.put(position, isChecked);
                }
            });
//            viewHolder.blank=view.findViewById(R.id.blank);
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.dhsl.addTextChangedListener(viewHolder.mTextWatcher);
            view.setTag(viewHolder);
            viewHolder.updatePosition(position);
//            view=convertView;
//            viewHolder=(ViewHolder) view.getTag();
//            viewHolder.updatePosition(position);
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
        if(unable.get(position)<=0){
            viewHolder.dhsl.setBackgroundColor(Color.GRAY);
            viewHolder.checked1.setVisibility(View.GONE);
            viewHolder.label.setVisibility(View.GONE);
        }
        if(!rep.getMaterialType().equals("专有")){
            viewHolder.checked1.setVisibility(View.GONE);
            viewHolder.label.setVisibility(View.GONE);
        }
        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }
        if(select1.get(position)){
            viewHolder.checked1.setChecked(true);
        }else{
            viewHolder.checked1.setChecked(false);
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
        CheckBox checked1;
        TextView label;
        View parent_layout;

        MyTextWatcher mTextWatcher;

        //动态更新TextWathcer的position
        public void updatePosition(int position) {
            mTextWatcher.updatePosition(position);
        }
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
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
            float num;
            if(s.toString().equals("")){
                num=Float.parseFloat(("0"+s.toString()));
            }else {
                num=Float.parseFloat((s.toString()));
            }
            mList.get(mPosition).setCurrentQty(num);
        }
    }
}
