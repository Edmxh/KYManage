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

import com.example.kymanage.Beans.DataBean1;
import com.example.kymanage.Beans.UpdateSemiStorage.AdvancedListBean;
import com.example.kymanage.R;

import java.util.List;

public class AdvancedListBeanAdapter extends ArrayAdapter<AdvancedListBean> {
    private int resourceId;

    //private DataBean1 DataBean1;

    // 适配器的构造函数，把要适配的数据传入这里
    public AdvancedListBeanAdapter(Context context, int textViewResourceId, List<AdvancedListBean> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        AdvancedListBean AdvancedListBean=getItem(position); //获取当前项的DataBean1实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.wlbm=view.findViewById(R.id.wlbm);
            viewHolder.wlms=view.findViewById(R.id.wlms);
            viewHolder.sl=view.findViewById(R.id.sl);
            viewHolder.gc=view.findViewById(R.id.gc);
            viewHolder.kcdd=view.findViewById(R.id.kcdd);
            viewHolder.xmwb=view.findViewById(R.id.xmwb);

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


        String num=""+AdvancedListBean.getNum();

        viewHolder.wlbm.setText(AdvancedListBean.getMaterialCode());
        viewHolder.wlms.setText(AdvancedListBean.getMaterialDes());
        viewHolder.sl.setText(num);
        viewHolder.gc.setText(AdvancedListBean.getFactory());
        viewHolder.kcdd.setText(AdvancedListBean.getArea());
        viewHolder.xmwb.setText(AdvancedListBean.getProjectText());

        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        TextView wlbm;
        TextView wlms;
        EditText sl;
        TextView gc;
        TextView kcdd;
        EditText xmwb;
    }
    public interface DetailViewHolderListener {
        void setData(ViewHolder viewHolder, int position);
    }
}
