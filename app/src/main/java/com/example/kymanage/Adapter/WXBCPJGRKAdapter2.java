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

import com.example.kymanage.Beans.GetOutStorageMaterialOrderJS.GetOutStorageMaterialOrderJSRepBean;
import com.example.kymanage.Beans.GetSapStorageInfoByFactoryJS.iddesBean;
import com.example.kymanage.Beans.PreMaterialProductOrder.PreMaterialProductOrderRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WXBCPJGRKAdapter2 extends ArrayAdapter<PreMaterialProductOrderRep> {
    private int resourceId;
    private ArrayAdapter<String> adapter2;
    private List<iddesBean> areadess=new ArrayList<iddesBean>();
    private List<String> dess=new ArrayList<String>();
    private List<PreMaterialProductOrderRep> mList;
    HashMap<Integer, Boolean> select=new HashMap<>();
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public WXBCPJGRKAdapter2(Context context, int textViewResourceId, List<PreMaterialProductOrderRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<PreMaterialProductOrderRep>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            if(mList.get(i).getCurrentNum()>0){
                select.put(i, true);
            }else {
                select.put(i, false);
            }
        }
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final PreMaterialProductOrderRep rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        final ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.parent_layout=view.findViewById(R.id.parent_layout);
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.scddh=view.findViewById(R.id.scddh);
            viewHolder.jhksrq=view.findViewById(R.id.jhksrq);
            viewHolder.xqsl=view.findViewById(R.id.xqsl);
            viewHolder.yfpsl=view.findViewById(R.id.yfpsl);
            viewHolder.fpsl=view.findViewById(R.id.fpsl);
            viewHolder.mTextWatcher = new MyTextWatcher();
            viewHolder.fpsl.addTextChangedListener(viewHolder.mTextWatcher);
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
            viewHolder.updatePosition(position);
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
        viewHolder.wlbm.setText(rep.getMATNR());
        viewHolder.wlms.setText(rep.getMAKTX());

        String newStr1 = rep.getProductOrderNO().replaceAll("^(0+)", "");
        viewHolder.scddh.setText(newStr1);
        viewHolder.jhksrq.setText(rep.getPlanStartTime());

        String num1str=""+rep.getDemandNum();
        viewHolder.xqsl.setText(num1str);
        String num2str=""+rep.getDispatchNum();
        viewHolder.yfpsl.setText(num2str);
        String num3str=""+rep.getCurrentNum();
        viewHolder.fpsl.setText(num3str);
        if(select.get(position)){
            viewHolder.checked.setChecked(true);
        }else{
            viewHolder.checked.setChecked(false);
        }
//        areadess=rep.getStorage();
//        for (iddesBean iddesBean : areadess) {
//            dess.add(iddesBean.getDesc());
//        }
        //下拉框
//        adapter2 = new ArrayAdapter<String>(getContext(), R.layout.defined_spinner_item, dess);
//        //设置下拉列表的风格
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        //将adapter 添加到spinner中
//        viewHolder.spinner1.setAdapter(adapter2);

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

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        View parent_layout;
        TextView xh;
        TextView wlbm;
        TextView wlms;
        TextView scddh;
        TextView jhksrq;
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
            float num=Float.parseFloat(("0"+s.toString()));
            mList.get(mPosition).setCurrentNum(num);
        }
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}