package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.kymanage.Beans.DataBean1;
import com.example.kymanage.R;

import java.util.List;

public class DataBean1Adapter extends ArrayAdapter<DataBean1> {
    private int resourceId;

    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public DataBean1Adapter(Context context, int textViewResourceId, List<DataBean1> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final DataBean1 DataBean1=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.check=view.findViewById(R.id.check);
            viewHolder.hanghao=view.findViewById(R.id.hanghao);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.gongchang=view.findViewById(R.id.gongchang);
            viewHolder.xqrk=view.findViewById(R.id.xq_rk);
            viewHolder.dhsl=view.findViewById(R.id.dhsl);

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

        viewHolder.check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    DataBean1.setCheck(true);
                }else{
                    DataBean1.setCheck(false);
                }
            }
        });

        viewHolder.check.setChecked(DataBean1.isCheck());
        viewHolder.hanghao.setText(DataBean1.getRow());
        viewHolder.wlms.setText(DataBean1.getDescription());
        viewHolder.gongchang.setText(DataBean1.getFactory());
        viewHolder.xqrk.setText(DataBean1.getDemand()+"/"+DataBean1.getStorage());
        long dh= (long) DataBean1.getDemand();
        viewHolder.dhsl.setText((dh+""));

        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        CheckBox check;
        TextView hanghao;
        TextView wlms;
        TextView gongchang;
        TextView xqrk;
        EditText dhsl;
    }
    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
