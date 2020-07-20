package com.example.kymanage.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class KFFLDialogAdapter extends ArrayAdapter<PreMaterialProductOrderRep> {
    private int resourceId;
    private List<PreMaterialProductOrderRep> mList;

    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public KFFLDialogAdapter(Context context, int textViewResourceId, List<PreMaterialProductOrderRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<PreMaterialProductOrderRep>():objects;
        for (PreMaterialProductOrderRep bean : mList) {
            bean.setCurrentNum(0);
        }
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final PreMaterialProductOrderRep rep=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xqjb=view.findViewById(R.id.xqjb);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.jhksrq=view.findViewById(R.id.jhksrq);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yfpsl=view.findViewById(R.id.yfpsl);
            viewHolder.fpsl=view.findViewById(R.id.fpsl);

            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.fpsl.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
            viewHolder.updatePosition(position);
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


        viewHolder.xqjb.setText(rep.getDemandLevel());
        viewHolder.scddh.setText(rep.getProductOrderNO());
        viewHolder.jhksrq.setText(rep.getPlanStartTime());
        String num1str=""+rep.getDemandNum();
        viewHolder.xqsl.setText(num1str);

        //CurrentNum归0
//        rep.setCurrentNum(0);
        String num2str=""+rep.getCurrentNum();
        viewHolder.fpsl.setText(num2str);
        String num3str=""+rep.getIssuedNum();
        viewHolder.yfpsl.setText(num3str);
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
//                ((ViewGroup) v.getParent())
//                        .setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

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

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xqjb.setBackgroundResource(i);
        vh.scddh.setBackgroundResource(i);
        vh.jhksrq.setBackgroundResource(i);
        vh.xqsl.setBackgroundResource(i);
        vh.fpsl.setBackgroundResource(i);
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xqjb;
        TextView scddh;
        TextView jhksrq;
        TextView xqsl;
        TextView yfpsl;
        EditText fpsl;
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
            mList.get(mPosition).setCurrentNum(num);
        }
    }
}
