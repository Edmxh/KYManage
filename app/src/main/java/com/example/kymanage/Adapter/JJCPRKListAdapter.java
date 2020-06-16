package com.example.kymanage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kymanage.Beans.InsertCMStorageRecevingRecordDetail.InsertCMStorageRecevingRecordDetailReq;
import com.example.kymanage.Beans.WarehouseReceipt.WarehouseReceiptReq;
import com.example.kymanage.R;

import java.util.List;

public class JJCPRKListAdapter extends ArrayAdapter<InsertCMStorageRecevingRecordDetailReq> {
    private int resourceId;

    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public JJCPRKListAdapter(Context context, int textViewResourceId, List<InsertCMStorageRecevingRecordDetailReq> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final InsertCMStorageRecevingRecordDetailReq rep=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.xh=view.findViewById(R.id.xh);
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.wllx=view.findViewById(R.id.wllx);

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

        String xh=position+1+"";
        viewHolder.xh.setText(xh);
        viewHolder.wlbm.setText(rep.getMatnr());
        viewHolder.wlms.setText(rep.getAufnr());
        viewHolder.wllx.setText(rep.getKdauf());
        switch (position%2){
            default:
                break;
            case 0:
                setRowBackgroundColor(viewHolder, R.drawable.tablebody2);
                break;
            case 1:
                setRowBackgroundColor(viewHolder,R.drawable.tablebody1);
                break;
        }
        return view;
    }

    public void setRowBackgroundColor(ViewHolder vh,int i){
        vh.xh.setBackgroundResource(i);
        vh.wlbm.setBackgroundResource(i);
        vh.wlms.setBackgroundResource(i);
        vh.wllx.setBackgroundResource(i);
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView xh;
        TextView wlbm;
        TextView wlms;
        TextView wllx;
    }

    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
