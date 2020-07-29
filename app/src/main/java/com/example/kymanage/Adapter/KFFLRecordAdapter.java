package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.kymanage.Beans.GetIssueDetailRecord.GetIssueDetailRecordRep;
import com.example.kymanage.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KFFLRecordAdapter extends ArrayAdapter<GetIssueDetailRecordRep> {
    private int resourceId;
    HashMap<Integer, Boolean> select=new HashMap<>();
    private List<GetIssueDetailRecordRep> mList;
    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public KFFLRecordAdapter(Context context, int textViewResourceId, List<GetIssueDetailRecordRep> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
        mList=objects==null?new ArrayList<GetIssueDetailRecordRep>():objects;
        initData();
    }
    private void initData() {
        for(int i=0;i<mList.size();i++){
            select.put(i, false);
        }
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        final GetIssueDetailRecordRep rep=getItem(position); //获取当前项的DataBean1实例
        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }
        //获取控件和设置监听
        viewHolder.xh=view.findViewById(R.id.xh);
        viewHolder.scddh=view.findViewById(R.id.scddh);
        viewHolder.wlbm=view.findViewById(R.id.wlbm);
        viewHolder.wlms=view.findViewById(R.id.wlms);
        viewHolder.flsl=view.findViewById(R.id.flsl);
        viewHolder.flzt=view.findViewById(R.id.flzt);
        viewHolder.xqsl=view.findViewById(R.id.xqsl);
        viewHolder.yfsl=view.findViewById(R.id.yfsl);
        viewHolder.gxsj=view.findViewById(R.id.gxsj);
        viewHolder.flr=view.findViewById(R.id.flr);
        viewHolder.checked=view.findViewById(R.id.checked);
        viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                select.put(position, isChecked);
            }

        });
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
        viewHolder.scddh.setText(rep.getProductOrderNO());
        viewHolder.wlbm.setText(rep.getMaterialCode());
        viewHolder.wlms.setText(rep.getMaterialDesc());
        String num1str=""+rep.getDemandQty();
        viewHolder.xqsl.setText(num1str);
        String num2str=""+rep.getLastQty();
        viewHolder.yfsl.setText(num2str);
        String num3str=""+rep.getIssueQty();
        viewHolder.flsl.setText(num3str);
        viewHolder.gxsj.setText(rep.getUpdateTime());
        viewHolder.flr.setText(rep.getHandler());

        String str="";
        if(rep.getReverseHandler().equals("")){
            str=rep.getStatus();
        }else {
            str=rep.getStatus()+"("+rep.getReverseHandler()+")";
        }

        viewHolder.flzt.setText(str);
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
//        viewHolder.shsl.setOnTouchListener(new View.OnTouchListener() {
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
        TextView scddh;
        TextView wlbm;
        TextView wlms;
        TextView xqsl;
        TextView yfsl;
        TextView flsl;
        TextView flzt;
        TextView gxsj;
        TextView flr;
        CheckBox checked;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
