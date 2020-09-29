package com.example.kymanage.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kymanage.Adapter.Print1Record2Adapter;
import com.example.kymanage.Beans.General.CodeMessageBean;
import com.example.kymanage.Beans.GetInFactoryDeliverListDetailJS.GetInFactoryDeliverListDetailJSRep;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.Print1Record2.GetInFactoryDeliverListDetailJSPresenter;
import com.example.kymanage.presenter.Presenters.Print1Record2.OutSemifinProductIssueWriteOffJSPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;

public class PrintCNPSDRecord2Activity extends BaseActivity implements BaseView1<GetInFactoryDeliverListDetailJSRep>, BaseView2<CodeMessageBean> {

    private String DeliverID;
    private ListView listView1;
    private List<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean> datas;
    private Print1Record2Adapter adapter;
    private GetInFactoryDeliverListDetailJSPresenter presenter1;

    //震动
    private Vibrator vibrator;

    private ImageView receive;
    private String username;
    private OutSemifinProductIssueWriteOffJSPresenter presenter2;

    @Override
    public int initLayoutId() {
        return R.layout.activity_print_cnpsdrecord2;
    }

    @Override
    public void initview() {
        listView1=findViewById(R.id.listview1);
        receive=findViewById(R.id.receive);

        presenter1=new GetInFactoryDeliverListDetailJSPresenter();
        presenter1.setView(this);

        presenter2=new OutSemifinProductIssueWriteOffJSPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        datas=new ArrayList<GetInFactoryDeliverListDetailJSRep.GetInFactoryDeliverListDetailJSRepBean>();
        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");
        Intent intent=getIntent();
        DeliverID=intent.getStringExtra("DeliverID");
        presenter1.GetInFactoryDeliverListDetailJS(DeliverID);
    }

    @Override
    public void initLisenter() {
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(PrintCNPSDRecord2Activity.this);

            }
        });
    }

    @Override
    public void onDataSuccess1(GetInFactoryDeliverListDetailJSRep data) {
        Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
        try {
            datas=data.getData();
            adapter=new Print1Record2Adapter(this, R.layout.print1record2item,datas);
            listView1.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDataSuccess2(CodeMessageBean data) {
        if(data.getCode()==1){
            Toast.makeText(this, data.getMessage(), Toast.LENGTH_SHORT).show();
            presenter1.GetInFactoryDeliverListDetailJS(DeliverID);
        }else {
            DialogUtil.errorMessageDialog(PrintCNPSDRecord2Activity.this,data.getMessage());
        }
    }

    @Override
    public void onFailed(String msg) {

    }

    //冲销确认
    private void confirmDeleteDialog(Context context) {
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("请确认")
                .setMessage("确定要冲销吗？")
                .setSkinManager(QMUISkinManager.defaultInstance(context))
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .addAction(0, "冲销", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                        List<String> strlist=new ArrayList<String>();
                        if(datas!=null){
                            for (int i = 0; i < datas.size(); i++) {
                                View itmeview=listView1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                System.out.println(cb.isChecked());
                                if(cb.isChecked()){
                                    strlist.add(datas.get(i).getDispatchListNO());
                                }
                            }
                        }
                        System.out.println("冲销选中数:"+strlist.size());
                        if(strlist.size()>0){
                            presenter2.OutSemifinProductIssueWriteOffJS(strlist,username,DeliverID);
                        }else {
                            Toast.makeText(PrintCNPSDRecord2Activity.this, "未选中要冲销的记录", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
