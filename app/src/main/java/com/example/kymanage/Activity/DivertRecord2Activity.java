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

import com.example.kymanage.Adapter.Print2Record2Adapter;
import com.example.kymanage.Beans.General.StatusRespBean;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRep;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordRepBean;
import com.example.kymanage.Beans.GetDumpRecord.GetDumpRecordReq;
import com.example.kymanage.Beans.WriteOffMaterialFactoryCDump.WriteOffMaterialFactoryCDumpReq;
import com.example.kymanage.R;
import com.example.kymanage.presenter.InterfaceView.BaseView1;
import com.example.kymanage.presenter.InterfaceView.BaseView2;
import com.example.kymanage.presenter.Presenters.Print2Record2.GetDumpRecordPresenter;
import com.example.kymanage.presenter.Presenters.Print2Record2.WriteOffMaterialFactoryCDumpPresenter;
import com.example.kymanage.utils.DialogUtil;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;

public class DivertRecord2Activity extends BaseActivity implements BaseView1<GetDumpRecordRep>, BaseView2<StatusRespBean> {

    private long id;
    private ListView listView1;
    private List<GetDumpRecordRepBean> datas;
    private Print2Record2Adapter adapter;
    private GetDumpRecordPresenter presenter1;

    private ImageView receive;
    private String username;
    private WriteOffMaterialFactoryCDumpPresenter presenter2;

    //震动
    private Vibrator vibrator;


    @Override
    public int initLayoutId() {
        return R.layout.activity_divert_record2;
    }

    @Override
    public void initview() {
        listView1=findViewById(R.id.listview1);
        receive=findViewById(R.id.receive);

        presenter1=new GetDumpRecordPresenter();
        presenter1.setView(this);

        presenter2=new WriteOffMaterialFactoryCDumpPresenter();
        presenter2.setView(this);
    }

    @Override
    public void initData() {
        vibrator=(Vibrator)getSystemService(VIBRATOR_SERVICE);
        datas=new ArrayList<GetDumpRecordRepBean>();
        Intent intent=getIntent();
        id=intent.getLongExtra("id",-1);

        SharedPreferences sharedPreferences= getSharedPreferences("userInfo",
                Activity.MODE_PRIVATE);
        username =sharedPreferences.getString("username", "");

        GetDumpRecordReq req=new GetDumpRecordReq(id);
        presenter1.GetDumpRecord(req);
    }

    @Override
    public void initLisenter() {
        receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(30);
                confirmDeleteDialog(DivertRecord2Activity.this);

            }
        });
    }

    @Override
    public void onDataSuccess1(GetDumpRecordRep data) {
//        Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
        if(data.getStatus().getCode()==1){
            try {
                datas=data.getData();
                adapter=new Print2Record2Adapter(this, R.layout.print2record2item,datas);
                listView1.setAdapter(adapter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            DialogUtil.errorMessageDialog(DivertRecord2Activity.this,data.getStatus().getMessage());
        }

    }

    @Override
    public void onDataSuccess2(StatusRespBean data) {
        if(data.getStatus().getCode()==1){
            Toast.makeText(this, data.getStatus().getMessage(), Toast.LENGTH_SHORT).show();
            GetDumpRecordReq req=new GetDumpRecordReq(id);
            presenter1.GetDumpRecord(req);
        }else {
            DialogUtil.errorMessageDialog(DivertRecord2Activity.this,data.getStatus().getMessage());
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
                        List<WriteOffMaterialFactoryCDumpReq.DataBean> strlist=new ArrayList<WriteOffMaterialFactoryCDumpReq.DataBean>();
                        if(datas!=null){
                            for (int i = 0; i < datas.size(); i++) {
                                View itmeview=listView1.getAdapter().getView(i,null,null);
                                CheckBox cb= itmeview.findViewById(R.id.checked);
                                System.out.println(cb.isChecked());
                                if(cb.isChecked()){
                                    WriteOffMaterialFactoryCDumpReq.DataBean bean=new WriteOffMaterialFactoryCDumpReq.DataBean(datas.get(i).getID());
                                    strlist.add(bean);
                                }
                            }
                        }
                        System.out.println("冲销选中数:"+strlist.size());
                        if(strlist.size()>0){
                            WriteOffMaterialFactoryCDumpReq req=new WriteOffMaterialFactoryCDumpReq(username, id, strlist);
                            presenter2.WriteOffMaterialFactoryCDump(req);
                        }else {
                            Toast.makeText(DivertRecord2Activity.this, "未选中要冲销的记录", Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
    }
}
