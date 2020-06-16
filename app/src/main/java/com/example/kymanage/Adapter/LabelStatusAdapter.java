package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kymanage.Beans.DataBean1;
import com.example.kymanage.Beans.GetLableInfo.DataBean3;
import com.example.kymanage.R;

import java.util.List;

public class LabelStatusAdapter extends ArrayAdapter<DataBean3> {
    private int resourceId;

    // 适配器的构造函数，把要适配的数据传入这里
    public LabelStatusAdapter(Context context, int textViewResourceId, List<DataBean3> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        DataBean3 DataBean3=getItem(position); //获取当前项的DataBean3实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.status=view.findViewById(R.id.status);
            viewHolder.chargeman=view.findViewById(R.id.chargeman);
            viewHolder.scantime=view.findViewById(R.id.scantime);


            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }

        // 获取控件实例，并调用set...方法使其显示出来

        viewHolder.status.setText(DataBean3.getStatus());
        viewHolder.chargeman.setText(DataBean3.getChargeman());
        viewHolder.scantime.setText(DataBean3.getScanTime());


        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView status;
        TextView chargeman;
        TextView scantime;
    }
    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
