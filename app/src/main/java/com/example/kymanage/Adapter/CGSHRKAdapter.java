package com.example.kymanage.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetMaterialPropertieInfoJSRepBean;
import com.example.kymanage.Beans.GetMaterialPropertieInfoJS.GetPurWayMaterialDataRep;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.List;

public class CGSHRKAdapter extends ArrayAdapter<GetPurWayMaterialDataRep>implements View.OnClickListener {
    private int resourceId;
    private ArrayAdapter<String> adapter2;
    private List<iddesBean> areadess=new ArrayList<iddesBean>();
    private List<String> dess=new ArrayList<String>();
    private InnerItemOnclickListener mListener;
    private List<GetPurWayMaterialDataRep> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public CGSHRKAdapter(Context context, int textViewResourceId, List<GetPurWayMaterialDataRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetPurWayMaterialDataRep>():objects;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final GetPurWayMaterialDataRep rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);
            viewHolder.hjh=view.findViewById(R.id.hjh);
            viewHolder.rksl=view.findViewById(R.id.rksl);
            viewHolder.xlhlayout=view.findViewById(R.id.xlhlayout);
            viewHolder.xlh=view.findViewById(R.id.xlh);
            viewHolder.spinner1=view.findViewById(R.id.spinner1);
            viewHolder.receive=view.findViewById(R.id.receive);
            viewHolder.receive.setOnClickListener(this);
            viewHolder.receive.setTag(position);
            viewHolder.scan=view.findViewById(R.id.scan);
            viewHolder.scan.setOnClickListener(this);
            viewHolder.scan.setTag(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.xlh.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
            view.setTag(viewHolder);
        } else{
//            view=convertView;
//            viewHolder=(ViewHolder) view.getTag();

            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);
            viewHolder.hjh=view.findViewById(R.id.hjh);
            viewHolder.rksl=view.findViewById(R.id.rksl);
            viewHolder.xlhlayout=view.findViewById(R.id.xlhlayout);
            viewHolder.xlh=view.findViewById(R.id.xlh);
            viewHolder.spinner1=view.findViewById(R.id.spinner1);
            viewHolder.receive=view.findViewById(R.id.receive);
            viewHolder.receive.setOnClickListener(this);
            viewHolder.receive.setTag(position);
            viewHolder.scan=view.findViewById(R.id.scan);
            viewHolder.scan.setOnClickListener(this);
            viewHolder.scan.setTag(position);
            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            // 让ViewHolder持有一个TextWathcer，动态更新position来防治数据错乱；不能将position定义成final直接使用，必须动态更新
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.xlh.addTextChangedListener(viewHolder.mTextWatcher);
            viewHolder.updatePosition(position);
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
        GetMaterialPropertieInfoJSRepBean repData = rep.getData();
        String no=(position+1)+"";
        viewHolder.xh.setText(no);
        viewHolder.wlbm.setText(repData.getMaterialCode());
        viewHolder.wlms.setText(repData.getMaterialDesc());
        viewHolder.wllx.setText(repData.getMaterialType());
        viewHolder.hjh.setText(repData.getShelfNO());
        viewHolder.xlh.setText(repData.getXlh());
//        String num1str=""+repData.getPreQty();
//        viewHolder.yrksl.setText(num1str);
//        String num2str=""+repData.getInQty();
//        viewHolder.yirksl.setText(num2str);
        String num3str=""+repData.getQty();
        viewHolder.rksl.setText(num3str);
        areadess=rep.getData().getStorage();
        for (iddesBean iddesBean : areadess) {
            dess.add(iddesBean.getDesc());
        }
        //下拉框
        adapter2 = new ArrayAdapter<String>(getContext(), R.layout.defined_spinner_item, dess);
        //设置下拉列表的风格
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        viewHolder.spinner1.setAdapter(adapter2);

        if(!repData.getSerialNO().equals("KY01")){
            viewHolder.xlhlayout.setVisibility(View.GONE);
        }
//        viewHolder.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            public void onItemSelected(AdapterView<?> arg0, View arg1,
//                                       int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                chosenArea=areadess.get(arg2).getId();
//                System.out.println(viewHolder.spinner1.getSelectedItemPosition());
//            }
//
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
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
        viewHolder.xlh.setOnTouchListener(new View.OnTouchListener() {

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

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xh.setBackgroundResource(i);
        vh.wlbm.setBackgroundResource(i);
        vh.wlms.setBackgroundResource(i);
        vh.rksl.setBackgroundResource(i);
    }

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
        View parent_layout;
        TextView xh;
        TextView wlbm;
        TextView wlms;
        TextView wllx;
        TextView hjh;
        TextView rksl;
        View xlhlayout;
        EditText xlh;
        Spinner spinner1;
        Button receive;
        Button scan;

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
            mList.get(mPosition).getData().setXlh(s.toString());
        }
    }


}
