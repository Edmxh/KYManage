package com.example.kymanage.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kymanage.Beans.GetMarketOrderNoByCode.GetMarketOrderNoByCodeRepBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WXKFBQDY2Adapter extends ArrayAdapter<GetMarketOrderNoByCodeRepBean>{
    private int resourceId;
    private List<GetMarketOrderNoByCodeRepBean> mList;
    HashMap<Integer, Boolean> select=new HashMap<>();
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXKFBQDY2Adapter(Context context, int textViewResourceId, List<GetMarketOrderNoByCodeRepBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetMarketOrderNoByCodeRepBean>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            if(mList.get(i).getWaitNum()>0){
                select.put(i, true);
            }else {
                select.put(i, false);
            }
        }
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetMarketOrderNoByCodeRepBean rep=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        } else{
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        }

        // 获取控件实例，并调用set...方法使其显示出来
        viewHolder=new ViewHolder();
        viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
        viewHolder.xh=view.findViewById(R.id.xh);
        viewHolder.xsddh_hang=view.findViewById(R.id.xsddh_hang);
        viewHolder.xqsl=view.findViewById(R.id.xqsl);
        viewHolder.fpsl=view.findViewById(R.id.fpsl);
        viewHolder.yfpsl=view.findViewById(R.id.yfpsl);


        // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
        if (viewHolder.mTextWatcher ==null){
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.fpsl.addTextChangedListener(viewHolder.mTextWatcher);
        }

        viewHolder.checked=view.findViewById(R.id.checked);
        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                select.put(position, isChecked);
            }

        });
        viewHolder.updatePosition(position);
        // 将ViewHolder存储在View中（即将控件的实例存储在其中）
        view.setTag(viewHolder);
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


        viewHolder.xh.setText((position+1)+"");
        String newStr1 = rep.getKDAUF().replaceAll("^(0+)", "");
        String newStr2 = rep.getKDPOS().replaceAll("^(0+)", "");
        viewHolder.xsddh_hang.setText(newStr1+"/"+newStr2);
//        viewHolder.wlms.setText(rep.getProOrderMaterialDesc());
//        viewHolder.scddh.setText(rep.getProductOrderNO());
//        viewHolder.jhksrq.setText(rep.getPlanStartTime());
        String num1str=""+rep.getWMENG();
        viewHolder.xqsl.setText(num1str);
        if(rep.getWaitNum()==0&&!rep.isChange()){
            viewHolder.fpsl.setText(num1str);
        }else {
            String num2str=""+rep.getWaitNum();
            viewHolder.fpsl.setText(num2str);
        }
//
        String num3str=""+rep.getYJHSL();
        viewHolder.yfpsl.setText(num3str);
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
        viewHolder.fpsl.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ((ViewGroup)viewHolder.parent_layout)
                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                ((ViewGroup) v.getParent())
                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
                return false;
            }
        });
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

    public void setRowBackgroundColor(CGDialogAdapter.ViewHolder vh, int i){
        vh.xqjb.setBackgroundResource(i);
        vh.scddh.setBackgroundResource(i);
        vh.jhksrq.setBackgroundResource(i);
        vh.xqsl.setBackgroundResource(i);
        vh.fpsl.setBackgroundResource(i);
        vh.yfpsl.setBackgroundResource(i);
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        View parent_layout;
        TextView xh;
        TextView xsddh_hang;
        TextView xqsl;
        TextView yfpsl;
        EditText fpsl;
        CheckBox checked;
        MyTextWatcher mTextWatcher;

        //动态更新TextWathcer的position
        public void updatePosition(int position) {
            mTextWatcher.updatePosition(position);
        }
    }

    public interface DetailViewHolderListener {
        void setData(CGDialogAdapter.ViewHolder viewHolder, int position);
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
            //Log.i(TAG, "afterTextChanged: editable=" + s);
            System.out.println("afterTextChanged run!"+s.toString());
            float num=Float.parseFloat(("0"+s.toString()));
            mList.get(mPosition).setWaitNum(num);
            mList.get(mPosition).setChange(true);
            //System.out.println(mList.get(mPosition).getCurrentNum());
        }
    }
}
