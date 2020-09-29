package com.example.kymanage.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.kymanage.Activity.MainMenuActivity;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

public class DialogUtil {
    private static int mCurrentDialogStyle = com.qmuiteam.qmui.R.style.QMUI_Dialog;
    public static void errorMessageDialog(Context context,String msg) {
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("发生错误")
                .setSkinManager(QMUISkinManager.defaultInstance(context))
                .setMessage(msg)
                .addAction("关闭", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }

    public static void infoMessageDialog(Context context,String msg) {
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("请注意")
                .setSkinManager(QMUISkinManager.defaultInstance(context))
                .setMessage(msg)
                .addAction("关闭", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .create(mCurrentDialogStyle).show();
    }

    //冲销确认
    public static boolean confirmDeleteDialog(Context context) {
        final boolean[] isConfirm = new boolean[1];
        new QMUIDialog.MessageDialogBuilder(context)
                .setTitle("请确认")
                .setMessage("确定要冲销吗？")
                .setSkinManager(QMUISkinManager.defaultInstance(context))
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        isConfirm[0] =false;
                        dialog.dismiss();
                    }
                })
                .addAction(0, "冲销", QMUIDialogAction.ACTION_PROP_NEGATIVE, new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        isConfirm[0] =true;
                        dialog.dismiss();
                    }
                })
                .create(com.qmuiteam.qmui.R.style.QMUI_Dialog).show();
        return isConfirm[0];
    }
}
